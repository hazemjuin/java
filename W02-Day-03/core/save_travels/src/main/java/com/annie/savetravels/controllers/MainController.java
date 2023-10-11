package com.annie.savetravels.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.annie.savetravels.models.Expense;
import com.annie.savetravels.services.ExpenseService;

@Controller
public class MainController {
	//Dependency injection to talk to the service
	@Autowired
	private ExpenseService expenseService;
	
	// Redirect
	@RequestMapping("/")
	public String redirect() {
		return "redirect:/expenses";
	}
	
	// Display: Expense list and new form
	@GetMapping("/expenses")
	public String expenses(@ModelAttribute("expense") 
							Expense expense, Model model) {		
		List<Expense> alldaExpenses = expenseService.allExpenses();
		model.addAttribute("alldaExpenses", alldaExpenses);
		
		return "index.jsp";
	}
	
	// Action : process form
	@PostMapping("/processForm")
	public String create(@Valid @ModelAttribute("expense")Expense expense, 
							BindingResult result, Model model) {
		if (result.hasErrors()) {
			List<Expense> alldaExpenses = expenseService.allExpenses();
			model.addAttribute("alldaExpenses", alldaExpenses);
			return "index.jsp";
		} else {
			expenseService.createExpense(expense);
			return "redirect:/expenses";
		}
	}
	
	// Display: Edit page
	@RequestMapping("/expenses/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		Expense expense = expenseService.findExpense(id);
		model.addAttribute("expense", expense);
		return "edit.jsp";
	}
	
	// Action : process update 
	@PutMapping("/expenses/{id}")
	public String update(@Valid @ModelAttribute("expense")Expense expense,
							BindingResult result) {
		if(result.hasErrors()) {
			return "edit.jsp";
		}else {
			expenseService.updateExpense(expense);
			return "redirect:/expenses";
		}
	}
	
	// Action: process delete
	@DeleteMapping("/expenses/{id}")
	public String delete(@PathVariable("id") Long id) {
		expenseService.deleteExpense(id);
		return "redirect:/expenses";
	}
	
	// Display: Show One 
	@GetMapping("/expenses/{id}")
	public String showOne(@PathVariable("id") Long id, Model model) {
		Expense expense = expenseService.findExpense(id);
		model.addAttribute("expense", expense);
		return "showOne.jsp";
	}
	
}
