package com.community.online.dao;

import com.community.online.domain.Service;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceDao {

	int insertService(Service service);

	List<Service> selectServiceByState(String state);

    Service selectServiceById(String id);

    int deleteServiceById(String id);

    int updateService(Service service);

    List<Service> selectServiceByWaiterIdState(@Param("waiterId") String waiterId, @Param("state") String state);

    List<Service> selectServicesByStudentId(String studentId);
}
