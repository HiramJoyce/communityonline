package com.community.online.service;

import com.community.online.domain.Shop;

import java.util.List;

public interface ShopService {
	Shop login(String userName, String password);

	Shop register(String studentNum, String userName, String realName, String password);

	Shop getStudentById(String id);

	List<Shop> getAllStudents();

	int delete(String id1);

	int updateStudent(Shop student);
}
