package com.community.online.controller;

import com.community.online.domain.Good;
import com.community.online.domain.Service;
import com.community.online.service.GoodService;
import com.community.online.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/")
public class IndexController {

	@Autowired
	private GoodService goodService;
	@Autowired
	private ServiceService serviceService;

	@RequestMapping("")
	public String index(Model model) {
		List<Good> allGoods = goodService.getAllGoods();
		model.addAttribute("goods", allGoods);
		return "shop";
	}
	
	@RequestMapping("service")
	public String service(Model model, HttpSession session) {
		List<Service> serviceList = serviceService.getServiceByStudentId((String) session.getAttribute("id"));
		model.addAttribute("services", serviceList);
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

	@RequestMapping("logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:/";
	}
}
