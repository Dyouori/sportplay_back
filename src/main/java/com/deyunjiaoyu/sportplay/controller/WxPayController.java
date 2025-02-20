package com.deyunjiaoyu.sportplay.controller;

import com.deyunjiaoyu.sportplay.utils.WebSocketServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/** 假设这是微信支付的接口
 * @author: WangZhiJun
 * @create: 2019-09-21 12:31
 **/
@RestController
@RequestMapping("/wx/pay")
public class WxPayController {
    /**
     * 模仿微信支付API
     */
    @GetMapping(value = "/pay")
    public void paySuccess(@RequestParam String orderId,
                           @RequestParam String orderMoney,
                           @RequestParam String orderName) {
       // System.out.println("订单"+orderId+orderName+"支付："+orderMoney+"元");
      //  System.out.println("支付成功");
        //通知页面支付成功，实际是微信调用系统回调接口，在系统回调接口中进行通知
        try {
            WebSocketServer.sendInfo("支付成功",orderId);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
