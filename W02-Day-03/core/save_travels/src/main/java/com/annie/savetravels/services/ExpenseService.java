package com.annie.savetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.annie.savetravels.models.Expense;
import com.annie.savetravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	// adding the ExpenseRepository as a dependency to talk to repository
	@Autowired
	private ExpenseRepository expenseRepository;
	
	// READ ALL
	public List<Expense> allExpenses() {
		return expenseRepository.findAll();
	}
	
	// CREATE Expense
	public Expense createExpense(Expense expense) {
		return expenseRepository.save(expense);
	}
	
	// READ ONE by id
	public Expense findExpense(Long id) {
		Optional<Expense> optionalExpense = expenseRepository.findById(id);
		if(optionalExpense.isPresent()) {
			return optionalExpense.get();
		}else {
			return null;
		}
	}
	
	// UPDATE ONE
	public Expense updateExpense(Expense expense) {
		return expenseRepository.save(expense);
	}
	
	// DELETE ONE
	public void deleteExpense(Long id) {
		expenseRepository.deleteById(id);
	}
	
	
	
}
