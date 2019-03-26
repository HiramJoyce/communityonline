package com.community.online.dao;

import com.community.online.domain.Waiter;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface WaiterDao {

	Waiter selectStudentByUserName(String userName);

	int insertStudent(Waiter student);

	Waiter selectStudentById(String id);

	List<Waiter> selectAllStudents();

	int deleteStudentById(String id);

	int updateStudent(Waiter student);
}
