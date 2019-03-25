package com.community.online.service;


import com.community.online.domain.Admin;

public interface AdminService {
	Admin login(String userName, String password);
}
