package com.community.online.service;

import com.community.online.domain.Good;

import java.util.List;

public interface GoodService {
    Good createGood(Good good);
    int deleteGood(String id);
    List<Good> getAllGoods();
    Good getGoodById(String id);

    int updateGood(Good good);
}
