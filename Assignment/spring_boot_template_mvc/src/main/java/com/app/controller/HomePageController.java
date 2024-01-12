package com.app.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {
@GetMapping("/")
public String showIndex() {
	return "/index";
}
}
