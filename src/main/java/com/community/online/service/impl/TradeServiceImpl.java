package com.community.online.service.impl;

import com.community.online.dao.TradeDao;
import com.community.online.domain.Trade;
import com.community.online.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TradeServiceImpl implements TradeService {

    private final TradeDao tradeDao;

    @Autowired
    public TradeServiceImpl(TradeDao tradeDao) {
        this.tradeDao = tradeDao;
    }

    @Override
    public Trade createTrade(Trade trade) {
        return tradeDao.insertTrade(trade) > 0 ? trade : null;
    }

    @Override
    public int setTradeState(String id, String state) {
        return tradeDao.updateTradeState(id, state);
    }

    @Override
    public List<Trade> getUserTrades(String id) {
        return tradeDao.selectTradesByUserId(id);
    }

    @Override
    public Trade getTradeById(String id) {
        return tradeDao.selectTrade(id);
    }

    @Override
    public List<Trade> getAllTrades() {
        return tradeDao.selectTrades();
    }
}
