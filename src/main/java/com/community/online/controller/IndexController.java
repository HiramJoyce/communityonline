package com.community.online.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {

	@RequestMapping("")
	public String index() {
		return "shop";
	}
	
	@RequestMapping("service")
	public String service() {
		return "service";
	}
	
	@RequestMapping("help")
	public String help() {
		return "help";
	}
	
	@RequestMapping("advice")
	public String advice() {
		return "advice";
	}
	
	@RequestMapping("login")
	public String login() {
		return "login";
	}
}
