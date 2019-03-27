package com.community.online.service.impl;

import com.community.online.dao.HelpDao;
import com.community.online.domain.Help;
import com.community.online.domain.dto.HelpDto;
import com.community.online.service.HelpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HelpServiceImpl implements HelpService {

    @Autowired
    private HelpDao helpDao;

    public Help newComplaint(Help complaint) {
        return helpDao.insertComplaint(complaint) > 0 ? complaint : null;
    }


    public List<Help> getAllComplaintsByComplaintId(String complaintId) {
        return helpDao.selectComplaintsByComplaintId(complaintId);
    }


    public Help getComplaintByComplaintId(String complaintId) {
        return helpDao.selectComplaintByComplaintId(complaintId);
    }


    public int deleteComplaint(String id) {
        return helpDao.deleteComplaint(id);
    }


    public int deleteComplaintsByComplaintId(String complaintId) {
        return helpDao.deleteComplaintsByComplaintId(complaintId);
    }

    public List<Help> getComplaintsByUserId(String userId) {
        return helpDao.selectComplaintsByUserId(userId);
    }


    public List<HelpDto> getAllComplaintDtosParent() {
        return helpDao.selectComplaintDtosParent();
    }

    @Override
    public List<HelpDto> getAllComplaintDtosByComplaintId(String complaintId) {
        return helpDao.selectComplaintDtosByComplaintId(complaintId);
    }
}
