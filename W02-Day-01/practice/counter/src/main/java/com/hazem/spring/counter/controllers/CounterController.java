package com.hazem.spring.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CounterController {

    @GetMapping("/counter")
    public String showCounter(HttpSession session, Model model) {
        Integer counter = (Integer) session.getAttribute("counter");
        if (counter == null) {
            counter = 0;
        }
        model.addAttribute("counter", counter);
        return "counter";
    }

    @GetMapping("/increment")
    public String incrementCounter(HttpSession session) {
        Integer counter = (Integer) session.getAttribute("counter");
        if (counter == null) {
            counter = 0;
        }
        counter++;
        session.setAttribute("counter", counter);
        return "redirect:/counter";
    }

    @GetMapping("/incrementby2")
    public String incrementByTwo(HttpSession session) {
        Integer counter = (Integer) session.getAttribute("counter");
        if (counter == null) {
            counter = 0;
        }
        counter += 2;
        session.setAttribute("counter", counter);
        return "redirect:/counter";
    }

    @GetMapping("/reset")
    public String resetCounter(HttpSession session) {
        session.setAttribute("counter", 0);
        return "redirect:/counter";
    }
}
