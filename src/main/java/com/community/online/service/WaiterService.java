package com.community.online.service;

import com.community.online.domain.Waiter;

import java.util.List;

public interface WaiterService {
	Waiter login(String userName, String password);

	Waiter register(String studentNum, String userName, String realName, String password);

	Waiter getStudentById(String id);

	List<Waiter> getAllStudents();

	int delete(String id1);

	int updateStudent(Waiter student);
}
