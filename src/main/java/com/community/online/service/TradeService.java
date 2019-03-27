package com.community.online.service;


import com.community.online.domain.Trade;

import java.util.List;

public interface TradeService {
    Trade createTrade(Trade trade);

    int setTradeState(String id, String state);

    List<Trade> getUserTrades(String id);

    Trade getTradeById(String id);

    List<Trade> getAllTrades();
}
