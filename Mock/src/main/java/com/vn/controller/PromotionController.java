package com.vn.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.vn.entity.Promotion;
import com.vn.service.PromotionService;

@Controller
public class PromotionController {
	
	final static String PATH_FILE = "./src/main/resources/static/image/promotion/";

	@Autowired
	private PromotionService service;

	@GetMapping("/promotion-list")
	public String viewPromotionList(Model model) {
		return listByPage(1, model);
	}
	
	@GetMapping("/page/{pageNumber}")
	public String listByPage(@PathVariable("pageNumber") int pageNumber, Model model) {
		Page<Promotion> page = service.listAll(pageNumber);
		int totalPages = page.getTotalPages();
		
		
		List<Promotion> listPromotions = page.getContent();
		
		model.addAttribute("listPromotions", listPromotions);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("currentPage", pageNumber);
		return "promotionMNG/promotion-list";
	}

	@GetMapping("/new-promotion")
	public String showNewPromotionForm(Model model) {
		model.addAttribute("promotion", new Promotion());
		return "promotionMNG/promotion-add";
	}

	@PostMapping("/save-promotion")
	public String savePromotion(@ModelAttribute(name = "promotion") Promotion promotion,
			@RequestParam("imageFile") MultipartFile multipartFile) throws IOException {
		
		if (!multipartFile.isEmpty()) {
			String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
			promotion.setImage(fileName);
			Promotion savedPromotion = service.save(promotion);
			String uploadDir = PATH_FILE + savedPromotion.getId();
			Path uploadPath = Paths.get(uploadDir);
			
			if (!Files.exists(uploadPath)) {
				Files.createDirectories(uploadPath);
			} else {
				deleteFilesInDir(uploadDir);
			}
			
			try {
				InputStream inputStream = multipartFile.getInputStream();

				Path filePath = uploadPath.resolve(fileName);
				Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e) {
				throw new IOException("Could not save uploaded file: " + fileName);
			} 
		} else {
			if (promotion.getId() != null) {
				service.save(promotion);
			} else {
				promotion.setImage("N/A");
				service.save(promotion);
			}
			
		}
		return "redirect:/promotion-list";
	}
	
	@GetMapping("/edit-promotion/{id}")
	public String showEditPromotionForm(@PathVariable(name = "id") Integer id, Model model) {
		Promotion promotion = service.get(id);
		model.addAttribute("promotion", promotion);
		return "promotionMNG/promotion-edit";
	}
	
	@GetMapping("delete-promotion/{id}")
	public String deletePromotion(@PathVariable(name = "id") Integer id) throws IOException {
	
		if (!service.get(id).getImage().equals("N/A")) {
			String deleteDir = PATH_FILE + id;
			Path deletePath = Paths.get(deleteDir);
			deleteFilesInDir(deleteDir);
			Files.delete(deletePath);
		}
		
		service.delete(id);
		return "redirect:/promotion-list";
	}
	
	public void deleteFilesInDir(String path) {
		File directory = new File(path);
		
		String[] listFile = directory.list();
		
		if (listFile == null) {
			return;
		} else {
			for (String fileName : listFile) {
				File file = new File(directory, fileName);
				file.delete();
			}
		}
	}
}
