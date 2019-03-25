package com.community.online.dao;

import com.community.online.domain.Admin;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDao {

	Admin selectAdminByUserName(String userName);
}
