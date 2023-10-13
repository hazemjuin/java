package com.vcabading.bookclub.controllers;

import javax.servlet.http.HttpSession;
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

import com.vcabading.bookclub.models.Book;
import com.vcabading.bookclub.models.User;
import com.vcabading.bookclub.services.BookService;
import com.vcabading.bookclub.services.UserService;

////////////////////////////////////////////////////////////////////
//	BOOK CONTROLLER
////////////////////////////////////////////////////////////////////

@Controller
public class BookController {

	//	//// FIELDS ////////////////////////////////////////////////
    
    @Autowired
    private UserService userServ;
    
    @Autowired
    private BookService bookServ;

    //	//// BOOKS SHOW ////////////////////////////////////////////
    //	Show information from a Book
    
    //	**** GET: Render book information **************************
    @GetMapping("/books/{id}")
    public String booksId(@PathVariable("id") Long id,
    						Model model, HttpSession session) {
    	//	---- Check if User is Logged In  -----------------------
    	if (session.isNew() || session.getAttribute("user_id") == null) {
    		return "redirect:/";
    	}
    	//	---- Get the Log In User -------------------------------
    	User loggedInUser = this.userServ.retrieveUser((Long) session.getAttribute("user_id"));
    	model.addAttribute("loggedInUser", loggedInUser);
    	//	---- Get Book specified by ID --------------------------
    	Book book = this.bookServ.retrieveBook(id);
    	model.addAttribute("book", book);
    	return "booksid.jsp";
    }
    
    //	//// BOOKS NEW /////////////////////////////////////////////
    //	Add a Book to books table
    
    //	**** GET: Render Form **************************************
    @GetMapping("/books/new")
    public String booksNew(Model model, HttpSession session) {
    	//    	---- Check if User is Logged In  -------------------
    	if (session.isNew() || session.getAttribute("user_id") == null) {
    		return "redirect:/";
    	}
    	//	---- Get the Log In User -------------------------------
    	User loggedInUser = this.userServ.retrieveUser((Long) session.getAttribute("user_id"));
    	model.addAttribute("loggedInUser", loggedInUser);
    	//	---- Get a New Book ------------------------------------
    	Book newBook = new Book();
    	model.addAttribute("newBook", newBook);
    	return "booksnew.jsp";
    }
    
    //	**** POST: Add New Book to database *************************
    @PostMapping("/books/new")
    public String booksNewPost(@Valid @ModelAttribute("newBook") Book newBook,
    		BindingResult result, Model model, HttpSession session) {
    	// 	---- Check if User is Logged In  ------------------------
    	if (session.isNew() || session.getAttribute("user_id") == null) {
    		return "redirect:/";
    	}
    	//	---- Get the Log In User --------------------------------
    	User loggedInUser = this.userServ.retrieveUser((Long) session.getAttribute("user_id"));
    	model.addAttribute("loggedInUser", loggedInUser);
    	if (result.hasErrors()) {
            return "booksnew.jsp";
        } else {
        	newBook.setUser(loggedInUser);
            this.bookServ.create(newBook);
            return "redirect:/books";
        }
    }
    
    //	//// BOOKS EDIT ////////////////////////////////////////////
    //	Edit information from a Book
    
    //	**** GET: Render Edit Form *********************************
    @GetMapping("/books/{id}/edit")
    public String booksIdEdit(@PathVariable("id") Long id,
    							Model model, HttpSession session) {
    	//  ---- Check if User is Logged In  -----------------------
    	if (session.isNew() || session.getAttribute("user_id") == null) {
    		return "redirect:/";
    	}
    	//	---- Get the Log In User -------------------------------
    	User loggedInUser = this.userServ.retrieveUser((Long) session.getAttribute("user_id"));
    	model.addAttribute("loggedInUser", loggedInUser);
    	//	---- Get Book specified by ID --------------------------
    	Book oldBook = this.bookServ.retrieveBook(id);
    	model.addAttribute("oldBook", oldBook);
    	return "booksidedit.jsp";
    }
    
    //	**** PUT: Update Old Book on database *************************
    @PutMapping("/books/{id}/edit")
    public String booksIdEditPutt(@Valid @ModelAttribute("oldBook") Book oldBook,
    		BindingResult result, @PathVariable("id") Long id,
    		Model model, HttpSession session) {
    	// 	---- Check if User is Logged In  ------------------------
    	if (session.isNew() || session.getAttribute("user_id") == null) {
    		return "redirect:/";
    	}
    	//	---- Get the Log In User --------------------------------
    	User loggedInUser = this.userServ.retrieveUser((Long) session.getAttribute("user_id"));
    	model.addAttribute("loggedInUser", loggedInUser);
    	oldBook.setUser(loggedInUser);
    	if (result.hasErrors()) {
            return "booksidedit.jsp";
        } else {
        	this.bookServ.update(oldBook);
            return "redirect:/books/" + oldBook.getId();
        }
    }
	
    //	//// BOOKS DELETE //////////////////////////////////////////
    
    @DeleteMapping("/books/{id}/delete")
    public String booksIdDelete(@PathVariable("id") Long id, Model model) {
    	this.bookServ.delete(id);
    	return "redirect:/books";
    }
}
