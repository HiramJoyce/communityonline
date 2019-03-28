package com.community.online.controller.help;

import com.community.online.domain.Help;
import com.community.online.domain.dto.HelpDto;
import com.community.online.service.HelpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("help")
public class HelpController {
    @Autowired
    private HelpService helpService;

    @RequestMapping( value = "create", method = RequestMethod.POST)
    public String create(MultipartFile img, HttpServletRequest request) throws IOException {
        if (request.getSession().getAttribute("id") == null) {
            return "login";
        }
        Help complaint = new Help();
        complaint.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        complaint.setUserId((String) request.getSession().getAttribute("id"));
        complaint.setTitle(request.getParameter("title"));
        complaint.setContent(request.getParameter("content"));
        uploadImg(img, request, complaint);
        complaint.setCreateTime(new Date());
        helpService.newComplaint(complaint);
        return "redirect:/help";
    }

    private void uploadImg(MultipartFile img, HttpServletRequest request, Help complaint) throws IOException {
        if (img != null && !img.isEmpty()) {
            String path = request.getServletContext().getRealPath("/resource/uploadImg/");
            File dir = new File(path);
            boolean dirExist = dir.exists() || dir.mkdirs();
            if (dirExist) {
                String originalFileName = img.getOriginalFilename();
                String newFileName = UUID.randomUUID().toString().replaceAll("-", "") + originalFileName.substring(originalFileName.lastIndexOf("."));
                File newFile = new File(path + "/" + newFileName);
                img.transferTo(newFile);
                complaint.setImg(newFileName);
            }
        }
    }

    @RequestMapping("detail")
    public String detail(String id, Model model) {
        Help complaint = helpService.getComplaintByComplaintId(id);
        List<HelpDto> complaints = helpService.getAllComplaintDtosByComplaintId(id);
        model.addAttribute("complaint", complaint);
        model.addAttribute("complaints", complaints);
        return "help/item";
    }

    @RequestMapping( value = "reply", method = RequestMethod.POST)
    public String reply(MultipartFile img, HttpServletRequest request) throws IOException {
        if (request.getSession().getAttribute("id") == null) {
            return "login";
        }
        Help complaint = new Help();
        complaint.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        complaint.setUserId((String) request.getSession().getAttribute("id"));
        complaint.setContent(request.getParameter("content"));
        uploadImg(img, request, complaint);
        complaint.setParentId(request.getParameter("parentId"));
        complaint.setCreateTime(new Date());
        System.out.println(complaint);
        helpService.newComplaint(complaint);
        return "redirect:/help/detail?id=" + request.getParameter("parentId");
    }
}
