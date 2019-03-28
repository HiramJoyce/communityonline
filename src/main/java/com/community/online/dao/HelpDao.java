package com.community.online.dao;

import com.community.online.domain.Help;
import com.community.online.domain.dto.HelpDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface HelpDao {
    int insertComplaint(Help complaint);
    List<Help> selectComplaintsByComplaintId(String complaintId);
    Help selectComplaintByComplaintId(String id);
    int deleteComplaint(String id);
    int deleteComplaintsByComplaintId(String complaintId);
    List<Help> selectComplaintsByUserId(String userId);
    List<HelpDto> selectComplaintDtosParent();
//    List<ComplaintDTO> selectComplaintDTOsByComplaintId(String complaintId);
    List<HelpDto> selectComplaintDtosByComplaintId(String complaintId);
}
