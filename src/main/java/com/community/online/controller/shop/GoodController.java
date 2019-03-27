package com.community.online.controller.shop;

import com.community.online.domain.Good;
import com.community.online.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * @author hiram 2019年03月26日 22:05
 */
@Controller
public class GoodController {

    @Autowired
    private GoodService goodService;

    @RequestMapping("goodsPage")
    public String goodsPage(Model model) {
        List<Good> allGoods = goodService.getAllGoods();
        model.addAttribute("goods", allGoods);
        return "shop/goods";
    }

    @RequestMapping("updateGood")
    public String addGood(String id, Model model) {
        Good good;
        if (id == null || (good = goodService.getGoodById(id)) == null) {
            good = new Good();
        }
        model.addAttribute("good", good);
        return "shop/goodUpd";
    }

    @RequestMapping(value = "updateGood", method = RequestMethod.POST)
    public String addGood(String id, String name, String price, @RequestParam(value = "img", required = false) MultipartFile img, Model model, HttpServletRequest request) throws IOException {
        String newFileName = null;
        if (!img.isEmpty()) {
            String path = request.getServletContext().getRealPath("/resource/upload/");
            File dir = new File(path);
            boolean dirExist = dir.exists() || dir.mkdirs();
            if (dirExist) {
                String originalFileName = img.getOriginalFilename();
                newFileName = UUID.randomUUID().toString().replaceAll("-", "") + originalFileName.substring(originalFileName.lastIndexOf("."));
                File newFile = new File(path + "/" + newFileName);
                img.transferTo(newFile);
            }
        }
        Good good;
        if (id != null && (good = goodService.getGoodById(id)) != null) {
            good.setName(name);
            good.setPrice(Double.valueOf(price));
            if (newFileName != null) {
                good.setImg(newFileName);
            }
            System.out.println("update -> " + good.toString());
            goodService.updateGood(good);
        } else {
            good = new Good();
            good.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            good.setName(name);
            good.setPrice(Double.valueOf(price));
            good.setImg(newFileName);
            System.out.println("create -> " + good.toString());
            goodService.createGood(good);
        }
        return "redirect:/goodsPage";
    }

    @RequestMapping("/deleteGood")
    public String deleteGood(String id, HttpServletRequest request) {
        if (request.getSession().getAttribute("role") == null || !request.getSession().getAttribute("role").equals("shop")) {
            return "404";
        }
        if (id != null) {
            String ids[] = id.split(",");
            for (String id1 : ids) {
                goodService.deleteGood(id1);
            }
        }
        return "redirect:/goodsPage";
    }
}
