package com.deyunjiaoyu.sportplay.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;
//使用Spring框架进行配置的一个例子，它配置了一个名为WebSocketConfig的类，用于设置WebSocket服务端点（Server Endpoint）的导出。
@Configuration

public class WebSocketConfig  {
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }

}
