package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.service.TeamService;

@Controller

public class TeamController {
	public TeamController() {
		// TODO Auto-generated constructor stub
		System.out.println("inside TeamController");
	}
	@Autowired
	private TeamService teamservice;
	@RequestMapping("/teams")
	public ModelAndView getTeamDetails() {
		return new ModelAndView("/teams","team_detail", teamservice.getAllTeam() );
	}
}
