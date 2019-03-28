package com.community.online.service.impl;

import com.community.online.dao.ComplaintDao;
import com.community.online.domain.Complaint;
import com.community.online.domain.dto.ComplaintDto;
import com.community.online.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplaintServiceImpl implements ComplaintService {

    @Autowired
    private ComplaintDao complaintDao;

    public Complaint newComplaint(Complaint complaint) {
        return complaintDao.insertComplaint(complaint) > 0 ? complaint : null;
    }


    public List<Complaint> getAllComplaintsByComplaintId(String complaintId) {
        return complaintDao.selectComplaintsByComplaintId(complaintId);
    }


    public Complaint getComplaintByComplaintId(String complaintId) {
        return complaintDao.selectComplaintByComplaintId(complaintId);
    }


    public int deleteComplaint(String id) {
        return complaintDao.deleteComplaint(id);
    }


    public int deleteComplaintsByComplaintId(String complaintId) {
        return complaintDao.deleteComplaintsByComplaintId(complaintId);
    }

    public List<Complaint> getComplaintsByUserId(String userId) {
        return complaintDao.selectComplaintsByUserId(userId);
    }


    public List<Complaint> getAllComplaintsParent() {
        return complaintDao.selectComplaintsParent();
    }

    @Override
    public List<ComplaintDto> getAllComplaintDtosByComplaintId(String complaintId) {
        return complaintDao.selectComplaintDtosByComplaintId(complaintId);
    }
}
