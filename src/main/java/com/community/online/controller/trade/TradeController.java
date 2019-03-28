package com.community.online.controller.trade;

import com.community.online.domain.Good;
import com.community.online.domain.Trade;
import com.community.online.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
public class TradeController {

    private final TradeService tradeService;

    @Autowired
    public TradeController(TradeService tradeService) {
        this.tradeService = tradeService;
    }

    @RequestMapping(value = "/createTrade", method = RequestMethod.POST)
    public String createTrade(String place, String totalPrice, HttpSession session) {
        Trade trade = new Trade();
        trade.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        trade.setContent((String) session.getAttribute("car"));
        trade.setTotalPrice(Double.valueOf(totalPrice));
        trade.setPlace(place);
        trade.setUserId((String) session.getAttribute("id"));
        trade.setState("0");    // 0待接单 1已接单设置支付码，待支付 3支付完成派送中 4订单完成
        trade.setCreateTime(new Date());
        tradeService.createTrade(trade);
        session.setAttribute("car", null);
        System.out.println(trade);
        return "redirect:/tradeInfo?id=" + trade.getId();
    }

    @RequestMapping( value = "/setState", method = RequestMethod.POST)
    public String setState(String id, @RequestParam(value = "img", required = false) MultipartFile img, HttpServletRequest request) throws IOException {
        String newFileName = null;
        if (!img.isEmpty()) {
            String path = request.getServletContext().getRealPath("/resource/uploadImg/");
            File dir = new File(path);
            boolean dirExist = dir.exists() || dir.mkdirs();
            if (dirExist) {
                String originalFileName = img.getOriginalFilename();
                newFileName = UUID.randomUUID().toString().replaceAll("-", "") + originalFileName.substring(originalFileName.lastIndexOf("."));
                File newFile = new File(path + "/" + newFileName);
                img.transferTo(newFile);
            }
        }
        Trade trade = tradeService.getTradeById(id);
        trade.setState("1");
        trade.setPayImg(newFileName);
        tradeService.updateTrade(trade);
        return "redirect:/tradesPage";
    }

    @RequestMapping("/payTrade")
    public String payTrade(String id) {
        Trade trade = tradeService.getTradeById(id);
        if (trade == null) {
            return "404";
        }
        trade.setState("2");
        tradeService.updateTrade(trade);
        return "redirect:/";
    }

    @RequestMapping("/sendTrade")
    public String sendTrade(String id) {
        Trade trade = tradeService.getTradeById(id);
        if (trade == null) {
            return "404";
        }
        trade.setState("3");
        tradeService.updateTrade(trade);
        return "redirect:/tradesPage";
    }

    @RequestMapping("/finishTrade")
    public String finishTrade(String id) {
        Trade trade = tradeService.getTradeById(id);
        if (trade == null) {
            return "404";
        }
        trade.setState("4");
        tradeService.updateTrade(trade);
        return "redirect:/";
    }

    @RequestMapping("/tradeInfo")
    public String item(String id, Model model) {
        Trade trade = tradeService.getTradeById(id);
        if (trade == null) {
            return "404";
        }
        model.addAttribute("trade", trade);
        return "trade/trade";
    }

    @RequestMapping("tradesPage")
    public String goodsPage(Model model) {
        List<Trade> trades = tradeService.getAllTrades();
        model.addAttribute("trades", trades);
        return "trade/trades";
    }

    @RequestMapping("passTrade")
    public String passTrade(String id, Model model) {
        Trade trade = tradeService.getTradeById(id);
        model.addAttribute("trade", trade);
        return "trade/passTrade";
    }

    @RequestMapping("/deleteTrade")
    public String deleteTrade(String id) {
        if (id != null) {
            String ids[] = id.split(",");
            for (String id1 : ids) {
                tradeService.delete(id1);
            }
        }
        return "redirect:/";
    }
}
