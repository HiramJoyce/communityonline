package com.community.online.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.community.online.dao.ShopDao;
import com.community.online.domain.Shop;
import com.community.online.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ShopServiceImpl implements ShopService {

	@Autowired
	private ShopDao shopDao;
	
	public Shop login(String userName, String password) {
		Shop student = shopDao.selectStudentByUserName(userName);
		if (student != null && StringUtils.equals(student.getPassword(), password)) {
			return student;
		}
		return null;
	}

	@Override
	public Shop register(String studentNum, String userName, String realName, String password) {
		Shop student = new Shop();
		student.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		student.setStudentNum(studentNum);
		student.setUserName(userName);
		student.setRealName(realName);
		student.setPassword(password);
		return shopDao.insertStudent(student) > 0 ? student : null;
	}

	@Override
	public Shop getStudentById(String id) {
		return shopDao.selectStudentById(id);
	}

	@Override
	public List<Shop> getAllStudents() {
		return shopDao.selectAllStudents();
	}

	@Override
	public int delete(String id) {
		return shopDao.deleteStudentById(id);
	}

    @Override
    public int updateStudent(Shop student) {
        return shopDao.updateStudent(student);
    }


}
