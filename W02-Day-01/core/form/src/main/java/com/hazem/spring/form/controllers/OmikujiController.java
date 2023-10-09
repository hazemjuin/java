package com.hazem.spring.form.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("fortune")
public class OmikujiController {

    @GetMapping("/omikuji")
    public String showOmikujiForm() {
        return "omikuji-form"; // This will be the name of your JSP file (omikuji-form.jsp).
    }

    @PostMapping("/omikuji/submit")
    public ModelAndView processOmikujiForm(@RequestParam("fortune") String fortune) {
        ModelAndView modelAndView = new ModelAndView("omikuji-show"); // This will be the name of your JSP file (omikuji-show.jsp).
        modelAndView.addObject("fortune", fortune); // Add the fortune attribute to the model.

        return modelAndView;
    }
}

