package com.wilsondevelopment.springwebcrudmysql.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wilsondevelopment.springwebcrudmysql.services.TorreService;

@Controller
@RequestMapping("/torre")
public class TorreController {
	@Autowired
	TorreService torreService;
	
	@GetMapping("/listaTorresWeb")
	public String listaTorresWeb(Model model) {
		model.addAttribute("lastorres", torreService.listaTorres());
		return "torre/torres";
	}
	
}
