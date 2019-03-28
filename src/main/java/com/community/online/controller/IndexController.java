package com.community.online.controller;

import com.community.online.domain.*;
import com.community.online.domain.dto.HelpDto;
import com.community.online.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class IndexController {

	@Autowired
	private GoodService goodService;
	@Autowired
	private ServiceService serviceService;
	@Autowired
	private ComplaintService complaintService;
    @Autowired
    private HelpService helpService;
    @Autowired
    private TradeService tradeService;

	@RequestMapping("")
	public String index(Model model, HttpSession session) {
		List<Good> allGoods = goodService.getAllGoods();
		model.addAttribute("goods", allGoods);
        List<Trade> trades = tradeService.getUserTrades((String) session.getAttribute("id"));
        model.addAttribute("trades", trades);
        return "shop";
	}
	
	@RequestMapping("service")
	public String service(Model model, HttpSession session) {
	    if (session.getAttribute("id") == null) {
	        return "login";
        }
		List<Service> serviceList = serviceService.getServiceByStudentId((String) session.getAttribute("id"));
		model.addAttribute("services", serviceList);
		return "service";
	}
	
	@RequestMapping("help")
	public String help(Model model) {
        List<HelpDto> helps = helpService.getAllComplaintDtosParent();
        model.addAttribute("helps", helps);
		return "help";
	}
	
	@RequestMapping("advice")
	public String advice(Model model, HttpSession session) {
        if (session.getAttribute("id") == null) {
            return "login";
        }
		List<Complaint> complaints = complaintService.getComplaintsByUserId((String) session.getAttribute("id"));
		model.addAttribute("complaints", complaints);
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

	@RequestMapping("car")
    public String car(Model model, HttpSession session) {
	    if (session.getAttribute("id") == null) {
	        return "login";
        }
        String car = (String) session.getAttribute("car");
        System.out.println(car);
	    if (car != null) {
            String[] goods = car.split("~");
            List<CarGood> carGoods = new ArrayList<>();
            CarGood carGood;
            double totalPrice = 0;
            for (String good : goods) {
                String[] infos = good.split("-");
                carGood = new CarGood();
                carGood.setId(infos[0]);
                carGood.setName(infos[1]);
                carGood.setPrice(Double.valueOf(infos[2]));
                carGood.setNum(Double.valueOf(infos[3]));
                carGood.setTotal(Double.valueOf(infos[2]) * Double.valueOf(infos[3]));
                totalPrice += Double.valueOf(infos[2]) * Double.valueOf(infos[3]);
                carGoods.add(carGood);
            }
            model.addAttribute("goods", carGoods);
            model.addAttribute("totalPrice", totalPrice);
        }
        return "car";
    }
}
