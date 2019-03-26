package com.community.online.controller.waiter;

import com.community.online.domain.Waiter;
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
public class WaiterController {

    @Autowired
    private WaiterService studentService;

    @RequestMapping("/waiterLogin")
    public String studentLogin(String userName, String password, Model model, HttpServletRequest request) {
        System.out.println("-> student login : " + userName + " - " + password);
        Waiter student = studentService.login(userName, password);
//        List<Paper> allPapers = paperService.getAllPapers();
//        model.addAttribute("papers", allPapers);
        if (student == null) {
            model.addAttribute("error","用户名或密码错误");
            return "index";
        }
        request.getSession().setAttribute("id", student.getId());
        request.getSession().setAttribute("realName", student.getRealName());
        request.getSession().setAttribute("role", "student");
        return "redirect:/";
    }

    @RequestMapping("/waiterRegister")
    public String studentRegister(String studentNum, String userName, String realName, String password, String chapter, String section, Model model, HttpServletRequest request) {
        System.out.println("-> student register : " + userName + " - " + password + " - " + realName);
        Waiter student = studentService.register(studentNum, userName, realName, password);
        if (student == null) {
            model.addAttribute("error","注册失败错误");
            return "index";
        }
        request.getSession().setAttribute("id", student.getId());
        request.getSession().setAttribute("realName", student.getRealName());
        request.getSession().setAttribute("role", "student");
        return "redirect:/";
    }

    @RequestMapping("/waiterInfo")
    public String studentInfo(Model model, HttpServletRequest request) {
        System.out.println("-> student studentInfo");
        Waiter student = studentService.getStudentById((String) request.getSession().getAttribute("id"));
        if (student != null) {
            model.addAttribute("student", student);
            return "student/waiterInfo";
        }
        return "redirect:/";
    }

    @RequestMapping("/waitersPage")
    public String toStudentPage(Model model, HttpServletRequest request) {
        if (request.getSession().getAttribute("role") == null || !request.getSession().getAttribute("role").equals("admin")) {
            return "404";
        }
        List<Waiter> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        System.out.println(students);
        return "admin/waiters";
    }

    @RequestMapping("/addWaiter")
    public String toAddQuestion(HttpServletRequest request) {
        if (request.getSession().getAttribute("role") == null || !request.getSession().getAttribute("role").equals("admin")) {
            return "404";
        }
        return "admin/waiterAdd";
    }

    @RequestMapping(value = "/addWaiter", method = RequestMethod.POST)
    public String addStudent(Waiter student, Model model, HttpServletRequest request) {
        if (request.getSession().getAttribute("role") == null || !request.getSession().getAttribute("role").equals("admin")) {
            return "404";
        }
        System.out.println("-> addStudent ->");
        System.out.println(student);
        Waiter addStudent = studentService.register(student.getStudentNum(), student.getUserName(), student.getRealName(), student.getPassword());
//        if (addStudent != null) {
//            model.addAttribute("student", student);
//            return "admin/students";
//        }
        return "redirect:/waitersPage";
    }

    @RequestMapping("/updateWaiter")
    public String updateStudent(String id, Model model, HttpServletRequest request) {
        if (request.getSession().getAttribute("role") == null || !request.getSession().getAttribute("role").equals("admin")) {
            return "404";
        }
        Waiter student = studentService.getStudentById(id);
        if (student != null) {
            model.addAttribute("student", student);
            return "admin/waiterUpd";
        }
        return "redirect:/waitersPage";
    }

    @RequestMapping(value = "/updateWaiter", method = RequestMethod.POST)
    public String updateStudent(Waiter student, Model model, HttpServletRequest request) {
        if (request.getSession().getAttribute("role") == null || !request.getSession().getAttribute("role").equals("admin")) {
            return "404";
        }
        System.out.println("-> updateStudent ->");
        System.out.println(student);
        studentService.updateStudent(student);
//        if (updateStudent != null) {
//            model.addAttribute("student", updateStudent);
//        }
        return "redirect:/waitersPage";
    }

    @RequestMapping(value = "/updateWaiterInfo", method = RequestMethod.POST)
    public String updateStudentInfo(Waiter student, Model model, HttpServletRequest request) {
        System.out.println("-> updateStudent ->");
        System.out.println(student);
        studentService.updateStudent(student);
//        if (updateStudent != null) {
//            model.addAttribute("student", updateStudent);
//        }
        model.addAttribute("student", student);
        request.getSession().setAttribute("id", student.getId());
        request.getSession().setAttribute("realName", student.getRealName());
        request.getSession().setAttribute("role", "student");
        return "student/waiterInfo";
    }

    @RequestMapping("/deleteWaiter")
    public String deleteStudent(String id, HttpServletRequest request) {
        if (request.getSession().getAttribute("role") == null || !request.getSession().getAttribute("role").equals("admin")) {
            return "404";
        }
        if (id != null) {
            String ids[] = id.split(",");
            for (String id1 : ids) {
                studentService.delete(id1);
            }
        }
        return "redirect:/waitersPage";
    }
}
