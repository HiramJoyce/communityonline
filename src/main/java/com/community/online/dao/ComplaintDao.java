package com.community.online.dao;

import com.community.online.domain.dto.ComplaintDto;
import com.community.online.domain.Complaint;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ComplaintDao {
    int insertComplaint(Complaint complaint);
    List<Complaint> selectComplaintsByComplaintId(String complaintId);
    Complaint selectComplaintByComplaintId(String id);
    int deleteComplaint(String id);
    int deleteComplaintsByComplaintId(String complaintId);
    List<Complaint> selectComplaintsByUserId(String userId);
    List<Complaint> selectComplaintsParent();
//    List<ComplaintDTO> selectComplaintDTOsByComplaintId(String complaintId);
    List<ComplaintDto> selectComplaintDtosByComplaintId(String complaintId);
}
