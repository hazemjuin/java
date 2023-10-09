package com.hazem.spring.ninjagame.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class GameController {

    private Player player = new Player();
    private List<String> activities = new ArrayList<>();

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("player", player);
        return "index";
    }

    @PostMapping("/process")
    public String processAction(@RequestParam String action) {
        String result = "";
        int goldEarned = 0;

        // Implement game logic based on the action
        switch (action) {
            case "farm":
                goldEarned = new Random().nextInt(11) + 10;
                break;
            case "cave":
                goldEarned = new Random().nextInt(6) + 5;
                break;
            case "house":
                goldEarned = new Random().nextInt(4) + 2;
                break;
            case "quest":
                goldEarned = new Random().nextInt(101) - 50; // Can earn or lose up to 50 gold
                break;
            case "spa":
                goldEarned = -1 * (new Random().nextInt(16) + 5); // Ninja loses 5-20 gold
                break;
        }

        // Update player data
        player.setGold(player.getGold() + goldEarned);

        // Update activity log
        String activity = "You entered a " + action + " and ";
        if (goldEarned >= 0) {
            activity += "earned " + goldEarned + " gold. (" + new Date() + ")";
        } else {
            activity += "lost " + Math.abs(goldEarned) + " gold. (" + new Date() + ")";
        }
        activities.add(activity);

        return "redirect:/";
    }

    @GetMapping("/activity")
    public String viewActivity(Model model) {
        model.addAttribute("activities", activities);
        return "activity";
    }
}