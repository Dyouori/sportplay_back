package com.deyunjiaoyu.sportplay.AliPay;

public class testForAliPay {
    /**
     * 用于唯一标识一次支付请求，可以是订单号或与其他业务相关的唯一标识
     */
    private Integer userId;
    private String id;

    /**
     * 支付的总金额
     */
    private String totalAmount;

    /**
     * 支付时显示的商品描述
     */
    private String productDescription;

    /**
     * 支付时显示的商品名称
     */
    private String productName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public String toString() {
        return "testForAliPay{" +
                "id=" + id +
                ", totalAmount='" + totalAmount + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", productName='" + productName + '\'' +
                '}';
    }
}
