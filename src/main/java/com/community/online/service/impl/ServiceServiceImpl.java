package com.community.online.service.impl;

import com.community.online.dao.ServiceDao;
import com.community.online.domain.Service;
import com.community.online.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService {

    @Autowired
    private ServiceDao serviceDao;
    @Override
    public Service createService(Service service) {
        return serviceDao.insertService(service) > 0? service : null;
    }

    @Override
    public List<Service> getServices(String state) {
        return serviceDao.selectServiceByState(state);
    }

    @Override
    public List<Service> getServices(String waiterId, String state) {
        return serviceDao.selectServiceByWaiterIdState(waiterId, state);
    }

    @Override
    public Service getServiceById(String id) {
        return serviceDao.selectServiceById(id);
    }

    @Override
    public Service updateService(Service service) {
        return serviceDao.updateService(service) > 0 ? service : null;
    }

    @Override
    public void deleteService(String id) {
        serviceDao.deleteServiceById(id);
    }

    @Override
    public List<Service> getServiceByStudentId(String studentId) {
        return serviceDao.selectServicesByStudentId(studentId);
    }
}
