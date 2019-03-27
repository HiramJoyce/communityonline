package com.community.online.service;


import com.community.online.domain.Service;

import java.util.List;

public interface ServiceService {
	Service createService(Service service);

	List<Service> getServices(String state);

	List<Service> getServices(String waiterId, String state);

	Service getServiceById(String id);

	Service updateService(Service service);

	void deleteService(String id1);

    List<Service> getServiceByStudentId(String studentId);
}
