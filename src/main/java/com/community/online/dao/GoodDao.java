package com.community.online.dao;

import com.community.online.domain.Good;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface GoodDao {
    int insertGood(Good good);
    int deleteGood(String id);
    List<Good> selectAllGoods();
    Good selectGoodById(String id);
    int updateGood(Good good);
}
