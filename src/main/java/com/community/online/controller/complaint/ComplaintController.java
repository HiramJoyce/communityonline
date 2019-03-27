package com.community.online.controller.complaint;

import com.community.online.domain.Complaint;
import com.community.online.domain.dto.ComplaintDto;
import com.community.online.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("complaint")
public class ComplaintController {
    @Autowired
    private ComplaintService complaintService;

    @RequestMapping( value = "create", method = RequestMethod.POST)
    public String create(MultipartFile img, HttpServletRequest request) throws IOException {
        if (request.getSession().getAttribute("id") == null) {
            return "login";
        }
        Complaint complaint = new Complaint();
        complaint.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        complaint.setUserId((String) request.getSession().getAttribute("id"));
        complaint.setContent(request.getParameter("content"));
        uploadImg(img, request, complaint);
        complaint.setCreateTime(new Date());
        complaintService.newComplaint(complaint);
        return "redirect:/advice";
    }

    private void uploadImg(MultipartFile img, HttpServletRequest request, Complaint complaint) throws IOException {
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
        Complaint complaint = complaintService.getComplaintByComplaintId(id);
        List<ComplaintDto> complaints = complaintService.getAllComplaintDtosByComplaintId(id);
        model.addAttribute("complaint", complaint);
        model.addAttribute("complaints", complaints);
        return "complaint/item";
    }

    @RequestMapping( value = "reply", method = RequestMethod.POST)
    public String reply(MultipartFile img, HttpServletRequest request) throws IOException {
        if (request.getSession().getAttribute("id") == null) {
            return "login";
        }
        Complaint complaint = new Complaint();
        complaint.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        complaint.setUserId((String) request.getSession().getAttribute("id"));
        complaint.setContent(request.getParameter("content"));
        uploadImg(img, request, complaint);
        complaint.setParentId(request.getParameter("parentId"));
        complaint.setCreateTime(new Date());
        System.out.println(complaint);
        complaintService.newComplaint(complaint);
        return "redirect:/complaint/detail?id=" + request.getParameter("parentId");
    }
}
