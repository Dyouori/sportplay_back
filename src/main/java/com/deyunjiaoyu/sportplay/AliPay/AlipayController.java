    package com.deyunjiaoyu.sportplay.AliPay;
    import com.alibaba.fastjson2.JSONObject;
    import com.alipay.api.AlipayApiException;
    import com.alipay.api.AlipayClient;
    import com.alipay.api.DefaultAlipayClient;
    import com.alipay.api.diagnosis.DiagnosisUtils;
    import com.alipay.api.domain.AlipayTradeRefundModel;
    import com.alipay.api.request.AlipayTradePagePayRequest;
    import com.alipay.api.request.AlipayTradeRefundRequest;
    import com.alipay.api.response.AlipayTradeRefundResponse;

    import java.io.UnsupportedEncodingException;

    import java.util.UUID;


    import com.deyunjiaoyu.sportplay.service.OrderService;
    import com.deyunjiaoyu.sportplay.service.UserService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Controller;
    import org.springframework.web.bind.annotation.*;


    import javax.servlet.http.HttpServletRequest;
    import javax.servlet.http.HttpServletResponse;
    import java.io.IOException;
    import java.math.BigDecimal;
    import java.util.ArrayList;
    import java.util.Arrays;
    import java.util.List;
    import java.util.Map;

    import static com.alipay.api.AlipayConstants.*;
    @Controller
    @RequestMapping("/alipay")
    public class AlipayController {
        @Autowired
        private UserService userService;
        @Autowired
        private OrderService orderService;

        private final AlipayConfiguration alipayConfiguration;

        public AlipayController(AlipayConfiguration alipayConfiguration) {
            this.alipayConfiguration = alipayConfiguration;
        }

        @GetMapping("/pay")
        public void pay(@RequestParam String totalAmount, @RequestParam Integer userId, HttpServletResponse httpResponse) throws IOException {

            // 创建默认的支付宝客户端实例
            AlipayClient alipayClient = new DefaultAlipayClient(
                    alipayConfiguration.getGatewayUrl(),
                    alipayConfiguration.getAppId(),
                    alipayConfiguration.getPrivateKey(),
                    FORMAT_JSON,
                    CHARSET_UTF8,
                    alipayConfiguration.getAlipayPublicKey(),
                    SIGN_TYPE_RSA2
            );

            AlipayTradePagePayRequest alipayTradePagePayRequest = new AlipayTradePagePayRequest();
            // 设置异步通知地址
            alipayTradePagePayRequest.setNotifyUrl(alipayConfiguration.getNotifyUrl());
            // 设置重定向地址
            alipayTradePagePayRequest.setReturnUrl(alipayConfiguration.getReturnUrl());
            // 生成随机订单号
            String outTradeNo = UUID.randomUUID().toString().replaceAll("-", "");
            testForAliPay order = new testForAliPay();
            order.setId(outTradeNo); // 商户订单号
            order.setProductName("充值"); // 商品名称
            order.setProductDescription("keep healthy！！"); // 商品描述
            order.setTotalAmount(totalAmount); // 付款金额，必填
            order.setUserId(userId);

            // 构造业务请求参数（如果是电脑网页支付，product_code是必传参数）
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("out_trade_no", order.getId());
            jsonObject.put("subject", order.getProductName());
            jsonObject.put("body", order.getProductDescription());
            jsonObject.put("total_amount", order.getTotalAmount());
            jsonObject.put("product_code", "FAST_INSTANT_TRADE_PAY");

            alipayTradePagePayRequest.setBizContent(jsonObject.toJSONString());
            alipayTradePagePayRequest.setBizContent(jsonObject.toJSONString());

            // 请求支付宝接口
            String alipayForm;
            try {

                alipayForm = alipayClient.pageExecute(alipayTradePagePayRequest).getBody();
            } catch (AlipayApiException e) {
                throw new RuntimeException(e);
            }

            // 将表单直接输出到页面，用户点击后会跳转到支付宝支付页面
            httpResponse.setContentType("text/html;charset=" + CHARSET_UTF8);
            int curMoney;
            curMoney = orderService.getMoney(userId)+ Integer.parseInt(totalAmount);
//            curMoney =+ Integer.parseInt(totalAmount);
            System.out.println("啊啊啊啊啊啊啊"+userId);
            System.out.println("金额："+curMoney);
            userService.addMoney(curMoney,userId);
            System.out.println("咋回事");
            httpResponse.getWriter().write(alipayForm);
            httpResponse.getWriter().flush();
            httpResponse.getWriter().close();

        }

        /**
         * 处理支付宝异步通知的接口（注意这里必须是POST接口）
         *
         * @param request HTTP请求对象，包含支付宝返回的通知信息
         * @return 返回给支付宝的确认信息
         */
        @PostMapping("/notify")
        @ResponseBody
        public String payNotify(HttpServletRequest request) throws UnsupportedEncodingException {
            System.err.println("====================payNotify====================");

            // 获取支付宝返回的各个参数
            Map<String, String[]> requestParameterMap = request.getParameterMap();
            requestParameterMap.forEach((key, value) -> System.err.println(key + " = " + Arrays.toString(value)));

            // 检查交易状态是否为成功
            if ("TRADE_SUCCESS".equals(request.getParameter("trade_status"))) {
                System.err.println("交易成功");
    //

                // 执行更新数据库中的订单状态等操作
            }

            System.err.println("====================payNotify====================");
            System.err.println();

            // 告诉支付宝，已经成功收到异步通知
            return "success";
        }

        @GetMapping("/return")
        public void payReturn(HttpServletRequest request, HttpServletResponse response) throws Exception {
            System.out.println("====================payReturn====================");
            String totalAmount = request.getParameter("total_amount"); // 获取付款金额
            String passbackParams = request.getParameter("passback_params");

            // 使用 userIdStr 进行后续操作
            // 获取支付宝返回的各个参数
            Map<String, String[]> requestParameterMap = request.getParameterMap();
            System.out.println("支付宝返回的参数：");
            requestParameterMap.forEach((key, value) -> System.out.println(key + " = " + Arrays.toString(value)));

            System.out.println("====================payReturn====================");
            System.out.println();

            // 设置响应的字符编码为UTF-8，防止中文乱码
            response.setCharacterEncoding("UTF-8");

            // 设置响应的内容类型为HTML，并指定字符编码为UTF-8
            response.setContentType("text/html; charset=UTF-8");
            response.getWriter().write("<html><body>支付成功，请关闭此页面。</body></html>");
            response.getWriter().flush();
            response.getWriter().close();


        }

    //    @GetMapping("/refund")
    //    @ResponseBody
    //    public String refund(@RequestParam(required = false) Long id, @RequestParam(required = false) String tradeNo) {
    //        System.out.println("====================refund====================");
    //
    //        // 创建默认的支付宝客户端实例
    //        AlipayClient alipayClient = new DefaultAlipayClient(
    //                alipayConfiguration.getGatewayUrl(),
    //                alipayConfiguration.getAppId(),
    //                alipayConfiguration.getPrivateKey(),
    //                FORMAT_JSON,
    //                CHARSET_UTF8,
    //                alipayConfiguration.getAlipayPublicKey(),
    //                SIGN_TYPE_RSA2
    //        );
    //
    //        testForAliPay order = new testForAliPay();
    //        order.setId(id);
    //        order.setProductName("爱国者键盘");
    //        order.setProductDescription("键盘中的战斗机");
    //        order.setTotalAmount("0.01");
    //
    //        AlipayTradeRefundRequest alipayTradeRefundRequest = new AlipayTradeRefundRequest();
    //        AlipayTradeRefundModel alipayTradeRefundModel = new AlipayTradeRefundModel();
    //
    //        // 设置商户订单号
    //        if (id != null) {
    //            alipayTradeRefundModel.setOutTradeNo(String.valueOf(order.getId()));
    //        }
    //
    //        // 设置查询选项
    //        List<String> queryOptions = new ArrayList<>();
    //        queryOptions.add("refund_detail_item_list");
    //        alipayTradeRefundModel.setQueryOptions(queryOptions);
    //        // 设置退款金额
    //        alipayTradeRefundModel.setRefundAmount("0.01");
    //        // 设置退款原因说明
    //        alipayTradeRefundModel.setRefundReason("正常退款");
    //        // 设置流水订单号
    //        if (tradeNo != null && !tradeNo.isEmpty()) {
    //            alipayTradeRefundModel.setTradeNo(tradeNo);
    //        }
    //
    //        alipayTradeRefundRequest.setBizModel(alipayTradeRefundModel);
    //        // 执行请求
    //        AlipayTradeRefundResponse alipayTradeRefundResponse = null;
    //
    //        int count = 1;
    //        int limit = 3;
    //        while (count <= limit) { // 最多重试3次
    //            try {
    //                alipayTradeRefundResponse = alipayClient.execute(alipayTradeRefundRequest);
    //                break;
    //            } catch (AlipayApiException e) {
    //                System.out.println("第" + count + "次重试");
    //                e.printStackTrace();
    //                count++;
    //            }
    //        }
    //
    //        if (count > limit || alipayTradeRefundResponse == null) {
    //            return "退款失败，请联系客服人员";
    //        }
    //
    //        System.out.println("alipayTradeRefundResponse.getBody() = " + alipayTradeRefundResponse.getBody());
    //        System.out.println("====================refund====================");
    //        System.out.println();
    //
    //        if (!alipayTradeRefundResponse.isSuccess()) {
    //            // SDK版本是"4.38.0.ALL"及以上,可以参考下面的示例获取诊断链接
    //            String diagnosisUrl = DiagnosisUtils.getDiagnosisUrl(alipayTradeRefundResponse);
    //            System.out.println("diagnosisUrl = " + diagnosisUrl);
    //
    //            return "退款失败，请联系客服人员";
    //        }
    //
    //        if ("N".equals(alipayTradeRefundResponse.getFundChange())) {
    //            return "该订单已经退款，请勿重复操作";
    //        }
    //
    //        return "退款成功";
    //    }

    }
