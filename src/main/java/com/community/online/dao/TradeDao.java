package com.community.online.dao;

import com.community.online.domain.Trade;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TradeDao {
    int insertTrade(Trade trade);

    int deleteTrade(String id);

    int updateTradeState(@Param("id") String id, @Param("state") String state);

    Trade selectTrade(String id);

    List<Trade> selectTrades();

    List<Trade> selectTradesByUserId(String userId);

    List<Trade> selectTradesByState(String state);

    int updateTrade(Trade trade);
}
