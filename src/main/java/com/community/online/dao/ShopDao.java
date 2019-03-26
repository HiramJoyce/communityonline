package com.community.online.dao;

import com.community.online.domain.Shop;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ShopDao {

	Shop selectStudentByUserName(String userName);

	int insertStudent(Shop student);

	Shop selectStudentById(String id);

	List<Shop> selectAllStudents();

	int deleteStudentById(String id);

	int updateStudent(Shop student);
}
