package com.anthonygarcia.burgertracker.controllers;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.anthonygarcia.burgertracker.models.Burger;
import com.anthonygarcia.burgertracker.services.BurgerService;

import jakarta.validation.Valid;

@Controller
public class BurgerTrackerController {
    private final BurgerService burgerService;
    public BurgerTrackerController(BurgerService burgerService){
        this.burgerService = burgerService;
    }
    
//    SHOW ALL OBJECTS
    @RequestMapping("/burgers")
    public String index(Model model, @ModelAttribute("burger") Burger burger) { 
    	List<Burger> allBurgers = burgerService.allBurgers();
    	model.addAttribute("allBurgers", allBurgers); //remember model takes two params -1) what it will be referred to in the jsp, 2) what it's called via Service.
    	return "index.jsp";
    }
    
//    CREATE NEW OBJECT
    @PostMapping("/burgers/new")
    public String create(@Valid @ModelAttribute("burger") Burger burger, BindingResult result, Model model) {
    	if (result.hasErrors()) {
    		List<Burger> allBurgers = burgerService.allBurgers();
    		model.addAttribute("allBurgers", allBurgers); 
    		return "index.jsp";
    	} else {
    		burgerService.createBurger(burger);
    		return "redirect:/burgers";
    		}
    	}

//    EDIT PAGE
    @GetMapping("/burgers/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
    	Burger burger = burgerService.findBurger(id);
    	model.addAttribute("burger", burger);
    	return "edit.jsp";
    }
    
//    EDIT SUBMIT
    @RequestMapping(value="/burger/{id}/edit/submit", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("burger") Burger burger, BindingResult result, Model model) {
    	if (result.hasErrors()) {
    		model.addAttribute("burger", burger);
    		return "edit.jsp";
    	} else {
    		burgerService.updateBurger(burger);
    		return "redirect:/burgers";
    	}
    }
    
   }
//You can use this to print whats in bindingResult to see the validation errors:
//System.out.println("Validation errors:");
//for (ObjectError error : result.getAllErrors()) {
//	System.out.println(error.getDefaultMessage());