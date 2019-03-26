package com.community.online.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.community.online.dao.WaiterDao;
import com.community.online.domain.Waiter;
import com.community.online.service.WaiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class WaiterServiceImpl implements WaiterService {

	@Autowired
	private WaiterDao waiterDao;
	
	public Waiter login(String userName, String password) {
		Waiter student = waiterDao.selectStudentByUserName(userName);
		if (student != null && StringUtils.equals(student.getPassword(), password)) {
			return student;
		}
		return null;
	}

	@Override
	public Waiter register(String studentNum, String userName, String realName, String password) {
		Waiter student = new Waiter();
		student.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		student.setStudentNum(studentNum);
		student.setUserName(userName);
		student.setRealName(realName);
		student.setPassword(password);
		return waiterDao.insertStudent(student) > 0 ? student : null;
	}

	@Override
	public Waiter getStudentById(String id) {
		return waiterDao.selectStudentById(id);
	}

	@Override
	public List<Waiter> getAllStudents() {
		return waiterDao.selectAllStudents();
	}

	@Override
	public int delete(String id) {
		return waiterDao.deleteStudentById(id);
	}

    @Override
    public int updateStudent(Waiter student) {
        return waiterDao.updateStudent(student);
    }


}
