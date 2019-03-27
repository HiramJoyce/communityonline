package com.community.online.service.impl;

import com.community.online.dao.GoodDao;
import com.community.online.domain.Good;
import com.community.online.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hiram 2019年03月26日 22:09
 */
@Service
public class GoodServiceImpl implements GoodService {

    @Autowired
    private GoodDao goodDao;

    @Override
    public Good createGood(Good good) {
        return goodDao.insertGood(good) > 0 ? good : null;
    }

    @Override
    public int deleteGood(String id) {
        return goodDao.deleteGood(id);
    }

    @Override
    public List<Good> getAllGoods() {
        return goodDao.selectAllGoods();
    }

    @Override
    public Good getGoodById(String id) {
        return goodDao.selectGoodById(id);
    }

    @Override
    public int updateGood(Good good) {
        return goodDao.updateGood(good);
    }
}
