package com.codingdojo.danaaltier.dojosAndNinjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.danaaltier.dojosAndNinjas.models.Dojo;
import com.codingdojo.danaaltier.dojosAndNinjas.models.Ninja;
import com.codingdojo.danaaltier.dojosAndNinjas.services.DojoNinjaService;

@Controller
public class MainController {
	
	// Attributes
	private final DojoNinjaService dNService;
	
	
	// Constructor
	public MainController(DojoNinjaService dNService) {
		this.dNService = dNService;
	}
	
	
	// GET index route
	@GetMapping("/")
 	// Model used for instantiating and binding to our view model
	public String index(Model model) {
		List<Dojo> dojos = dNService.getAllDojos();
		model.addAttribute("dojos", dojos);
		return "index.jsp";
	}
	
	
	// Render new dojo form
	@GetMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "newDojo.jsp";
	}
	
	
	// Render new ninja form 
	@GetMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		List<Dojo> dojos = dNService.getAllDojos();
		model.addAttribute("dojos", dojos);
		return "newNinja.jsp";
	}
	
	
	// Display all ninjas in a dojo
	@RequestMapping("/dojos/{id}")
	public String viewDojo(Model model, @PathVariable("id") Long id) {
		Dojo dojo = dNService.findDojoById(id);
		model.addAttribute("dojo", dojo);
		model.addAttribute("ninjas", dojo.getNinjas());
		return "showDojo.jsp";
	}
	
	
	// POST route for creating new dojo
	@PostMapping("/dojos/new")
  	// @Valid checks for validation
  	// @BindingResult after, checks for errors
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if (result.hasErrors()) {
			return "newDojo.jsp";
		} else {
			dNService.createDojo(dojo);
			return "redirect:/ninjas/new";
		}
	}
	
	
	// POST route for creating new ninja
	@PostMapping("/ninjas/new")
  	// @Valid checks for validation
  	// @BindingResult after, checks for errors
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
		if (result.hasErrors()) {
			List<Dojo> dojos = dNService.getAllDojos();
			model.addAttribute("dojos", dojos);
			return "newNinja.jsp";
		} else {
			dNService.createNinja(ninja);
			return "redirect:/";
		}
	}
}
