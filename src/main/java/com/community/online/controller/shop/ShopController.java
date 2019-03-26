package com.community.online.controller.shop;

import com.community.online.domain.Shop;
import com.community.online.domain.Waiter;
import com.community.online.service.ShopService;
import com.community.online.service.WaiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author hiram 2019年03月17日 23:33
 */
@Controller
public class ShopController {

    @Autowired
    private ShopService studentService;

    @RequestMapping("/shop/login")
    public String waiterLogin() {
        return "shop/loginPage";
    }

    @RequestMapping(value = "/shopLogin", method = RequestMethod.POST)
    public String studentLogin(String userName, String password, Model model, HttpServletRequest request) {
        System.out.println("-> waiter login : " + userName + " - " + password);
        Shop student = studentService.login(userName, password);
        System.out.println(student);
//        List<Paper> allPapers = paperService.getAllPapers();
//        model.addAttribute("papers", allPapers);
        if (student == null) {
            model.addAttribute("error","用户名或密码错误");
            return "redirect:/shop/login";
        }
        request.getSession().setAttribute("id", student.getId());
        request.getSession().setAttribute("realName", student.getRealName());
        request.getSession().setAttribute("role", "shop");
        return "shop/shopPage";
    }
}
