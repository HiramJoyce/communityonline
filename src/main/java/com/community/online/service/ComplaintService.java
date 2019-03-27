package com.community.online.service;

import com.community.online.domain.Complaint;
import com.community.online.domain.dto.ComplaintDto;

import java.util.List;

public interface ComplaintService {
    Complaint newComplaint(Complaint complaint);

    List<Complaint> getAllComplaintsByComplaintId(String complaintId);

    Complaint getComplaintByComplaintId(String complaintId);

    int deleteComplaint(String id);

    int deleteComplaintsByComplaintId(String complaintId);

    List<Complaint> getComplaintsByUserId(String id);

    List<Complaint> getAllComplaintsParent();

    List<ComplaintDto> getAllComplaintDtosByComplaintId(String complaintId);
}
