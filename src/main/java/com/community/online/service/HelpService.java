package com.community.online.service;

import com.community.online.domain.Help;
import com.community.online.domain.dto.HelpDto;

import java.util.List;

public interface HelpService {
    Help newComplaint(Help complaint);

    List<Help> getAllComplaintsByComplaintId(String complaintId);

    Help getComplaintByComplaintId(String complaintId);

    int deleteComplaint(String id);

    int deleteComplaintsByComplaintId(String complaintId);

    List<Help> getComplaintsByUserId(String id);

    List<HelpDto> getAllComplaintDtosParent();

    List<HelpDto> getAllComplaintDtosByComplaintId(String complaintId);
}
