package com.ultron.mvc.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ultron.root.services.FileUploadService;

@Controller
@RequestMapping("upload")
public class BookUploadController {

	@Autowired
	private FileUploadService service;

	@PostMapping
	public String upload(@RequestParam("uploadFile") MultipartFile partFile, RedirectAttributes redirect)
			throws IOException {

		if (!partFile.isEmpty() && null != partFile) {
			var message = service.upload(partFile);
			redirect.addFlashAttribute("uploadMessage", message);
			return "redirect:/home";
		}

		return "home";
	}
	
	
}
