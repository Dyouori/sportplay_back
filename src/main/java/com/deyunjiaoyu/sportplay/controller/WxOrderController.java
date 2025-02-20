package com.deyunjiaoyu.sportplay.controller;

import com.deyunjiaoyu.sportplay.utils.BarCodeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.math.BigDecimal;

@RestController
@RequestMapping("/api/v1/order")
public class WxOrderController {
    /**
     * 系统内生成支付二维码接口
     */
    /**
     * 系统内生成支付二维码接口
     */
    @GetMapping(value = "/payOrder")
    public Result pay(@RequestParam String orderId) {

        Result result = new Result();
        String orderName = "XXSuperMarketPay";

        BigDecimal orderMoney = new BigDecimal(100);
        System.out.println("订单"+orderId+orderName+"需支付："+orderMoney+"元");
        switch (orderId) {
            case "0":
                orderMoney = BigDecimal.valueOf(50);
                break;
            case "1":
                orderMoney = BigDecimal.valueOf(150);
                break;
            case "2":
                orderMoney = BigDecimal.valueOf(500);
                break;
            default:
                // 处理无效的 orderId
                orderMoney = BigDecimal.ZERO;
                break;
        }
        String wxPayUrl = "http://192.168.101.16:9000/wx/pay/pay?orderId="+orderId+"&orderName="+orderName+"&orderMoney="+orderMoney;
       // System.out.println("生成支付二维码链接："+wxPayUrl);
        result.setData(BarCodeUtils.getImage2Base64String(BarCodeUtils.generateBarcodeWithoutWhite(wxPayUrl, Color.BLACK)));

        return result;

    }

    /**
     * 结果实体类，这里为简化开发写为内部类，且只有一个data属性
     */
    class Result {
        String data;
        public void setData(String data) {
            this.data = data;

        }
        public String getData() {

            return data;
        }
    }

}
