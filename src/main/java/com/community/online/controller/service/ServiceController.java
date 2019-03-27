package com.community.online.controller.service;

import com.community.online.domain.Service;
import com.community.online.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

/**
 * @author hiram 2019年03月17日 23:33
 */
@Controller
public class ServiceController {

    @Autowired
    private ServiceService serviceService;

    @RequestMapping("/serviceCreate")
    public String serviceCreate(String title, String content, String time, String price, String place, Model model, HttpServletRequest request) throws ParseException {
        if (request.getSession().getAttribute("id") == null || request.getSession().getAttribute("id").equals("")) {
            return "login";
        }
        Service service = new Service();
        service.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        service.setStudentId((String) request.getSession().getAttribute("id"));
        service.setWaiterId(null);
        service.setTitle(title);
        service.setContent(content);
        service.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(time));
        service.setPrice(price);
        service.setPlace(place);
        service.setState("0");
        service.setReply(null);
        service.setDanger("no");
        // TODO 判断敏感词
        String[] dangerWord = {"党", "色情", "特殊服务"};
        for (String word : dangerWord) {
            if (title.contains(word) || content.contains(word)) {
                service.setDanger("yes");
            }
        }
        Service service1 = serviceService.createService(service);
        if (service1 == null) {
            model.addAttribute("error","发布错误");
            return "service";
        }
        return "redirect:/";
    }

    @RequestMapping("/servicesPage")
    public String toStudentPage(Model model, HttpServletRequest request) {
        if (request.getSession().getAttribute("role") == null || !request.getSession().getAttribute("role").equals("admin")) {
            return "404";
        }
        List<Service> services = serviceService.getServices("0");
        model.addAttribute("services", services);
        return "admin/services";
    }

    @RequestMapping("/servicesPage1")
    public String toStudentPage1(Model model, HttpServletRequest request) {
        if (request.getSession().getAttribute("role") == null || !request.getSession().getAttribute("role").equals("waiter")) {
            return "404";
        }
        List<Service> services = serviceService.getServices("1");
        model.addAttribute("services", services);
        List<Service> services2 = serviceService.getServices((String) request.getSession().getAttribute("id"), "2");
        model.addAttribute("services2", services2);
        List<Service> services3 = serviceService.getServices((String) request.getSession().getAttribute("id"), "3");
        model.addAttribute("services3", services3);
        return "waiter/services";
    }

    @RequestMapping("/acceptService")
    public String acceptService(String id, Model model, HttpSession session) {
        Service service = serviceService.getServiceById(id);
        service.setWaiterId((String) session.getAttribute("id"));
        service.setState("2");
        serviceService.updateService(service);
        model.addAttribute("service", service);
        return "redirect:/servicesPage1";
    }

    @RequestMapping("/passService")
    public String passService(String id, Model model, HttpSession session) {
        Service service = serviceService.getServiceById(id);
        service.setState("1");
        serviceService.updateService(service);
        model.addAttribute("service", service);
        return "redirect:/servicesPage";
    }

    @RequestMapping("/serviceInfo")
    public String serviceInfo(String id, Model model) {
        Service service = serviceService.getServiceById(id);
        model.addAttribute("service", service);
        return "admin/service";
    }

    @RequestMapping("/finishService")
    public String finishService(String id, Model model) {
        Service service = serviceService.getServiceById(id);
        model.addAttribute("service", service);
        return "waiter/service";
    }

    @RequestMapping(value = "/finishService", method = RequestMethod.POST)
    public String finishService(String id, String reply) {
        Service service = serviceService.getServiceById(id);
        service.setState("3");
        service.setReply(reply);
        serviceService.updateService(service);
        return "redirect:/servicesPage1";
    }

//    @RequestMapping("/addService")
//    public String toAddQuestion(HttpServletRequest request) {
//        if (request.getSession().getAttribute("role") == null || !request.getSession().getAttribute("role").equals("admin")) {
//            return "404";
//        }
//        return "admin/serviceAdd";
//    }

    @RequestMapping(value = "/addService", method = RequestMethod.POST)
    public String addStudent(Service service, Model model, HttpServletRequest request) {
        if (request.getSession().getAttribute("role") == null || !request.getSession().getAttribute("role").equals("admin")) {
            return "404";
        }
        Service service1 = serviceService.createService(service);
//        if (addStudent != null) {
//            model.addAttribute("student", student);
//            return "admin/students";
//        }
        return "redirect:/";
    }

    @RequestMapping("/updateService")
    public String updateStudent(String id, Model model, HttpServletRequest request) {
        if (request.getSession().getAttribute("role") == null || !request.getSession().getAttribute("role").equals("admin")) {
            return "404";
        }
        Service service = serviceService.getServiceById(id);
        if (service != null) {
            model.addAttribute("service", service);
            return "admin/serviceUpd";
        }
        return "redirect:/servicesPage";
    }

    @RequestMapping(value = "/updateService", method = RequestMethod.POST)
    public String updateStudent(Service service, Model model, HttpServletRequest request) {
        if (request.getSession().getAttribute("role") == null || !request.getSession().getAttribute("role").equals("admin")) {
            return "404";
        }
        serviceService.updateService(service);
        return "redirect:/servicesPage";
    }

    @RequestMapping("/deleteService")
    public String deleteStudent(String id, HttpServletRequest request) {
        if (request.getSession().getAttribute("role") == null || !request.getSession().getAttribute("role").equals("admin")) {
            return "404";
        }
        if (id != null) {
            String ids[] = id.split(",");
            for (String id1 : ids) {
                serviceService.deleteService(id1);
            }
        }
        return "redirect:/servicesPage";
    }
}
