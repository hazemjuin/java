package com.jeffs.burgertracker.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.jeffs.burgertracker.models.Burger;
import com.jeffs.burgertracker.services.BurgerService;

@Controller
public class BurgerController {
	
	@Autowired
	private BurgerService burgerServ;
	
	@GetMapping("/")
	public String index(@ModelAttribute("burger")Burger burger, Model model) {
		List<Burger> allBurgers = burgerServ.allBurgers();
		model.addAttribute("allBurgers", allBurgers);
		return "index.jsp";
	}
	
	@PostMapping("/create")
	public String createBurger(@Valid @ModelAttribute("burger")Burger burger, BindingResult result) {
		burgerServ.createBurger(burger);
		return "redirect:/";
	}
	
	@GetMapping("/burgers/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) {
		Burger burger = burgerServ.findBurger(id);
		model.addAttribute("burger", burger);
		return "edit.jsp";
	}
	
	@PutMapping("/burgers/{id}")
	public String update(@Valid @ModelAttribute("burger") Burger burger, BindingResult result) {
		if (result.hasErrors()) {
			System.out.println(result);
			return "edit.jsp";
		} else {
			burgerServ.updateBurger(burger);
			return "redirect:/";
		}
	}
}
