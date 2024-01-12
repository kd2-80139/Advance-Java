package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.app.service.PlayerService;

@Controller
public class PlayerController {
	public PlayerController() {
		// TODO Auto-generated constructor stub
		System.out.println("inside PlayerController");
	}
	@Autowired
	private PlayerService playerservice;
	@PostMapping("/team_details")
	public String getAllPlayerById(Model map,@RequestParam Integer team_id) {
		map.addAttribute("players", playerservice.getAllPlayerById(team_id));
		return "/team_details";
	}
}
