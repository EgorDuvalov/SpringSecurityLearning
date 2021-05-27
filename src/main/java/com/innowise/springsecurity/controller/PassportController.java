package com.innowise.springsecurity.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/passport")
public class PassportController {

	@GetMapping("/login")
	public String getLoginPage(){
		return "login";
	}

	@GetMapping("/success")
	public String getSuccessPage(){
		return "success";
	}
}
