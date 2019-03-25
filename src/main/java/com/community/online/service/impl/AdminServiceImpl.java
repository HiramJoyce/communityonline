package com.community.online.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.community.online.dao.AdminDao;
import com.community.online.domain.Admin;
import com.community.online.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao adminDao;
	
	public Admin login(String userName, String password) {
		Admin admin = adminDao.selectAdminByUserName(userName);
		if (admin != null && StringUtils.equals(admin.getPassword(), password)) {
			return admin;
		}
		return null;
	}
	
}
