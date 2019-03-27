package com.community.online.controller.trade;

import com.community.online.domain.Trade;
import com.community.online.service.TradeService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.UUID;

@Controller
public class TradeController {

    private final TradeService tradeService;

    @Autowired
    public TradeController(TradeService tradeService) {
        this.tradeService = tradeService;
    }

    @RequestMapping(value = "/createTrade", method = RequestMethod.POST)
    public String createTrade(String place, HttpSession session) {
        Trade trade = new Trade();
        trade.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        trade.setContent((String) session.getAttribute("car"));
        trade.setTotalPrice((String) session.getAttribute("totalPrice"));
        trade.setPlace(place);
        trade.setState("0");    // 0待接单 1已接单设置支付码，待支付 3支付完成派送中 4订单完成
        trade.setCreateTime(new Date());
        return "redirect:/tradeInfo?id=" + trade.getId();
    }

    @RequestMapping( value = "setState", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String setState(String id, String state) {
        return "";
    }

    @RequestMapping("item")
    public String item(String id, HttpServletRequest request) {
        Trade trade = tradeService.getTradeById(id);
        if (trade == null) {
            return "404";
        }
        request.setAttribute("trade", trade);
        return "trade/trade";
    }
}
