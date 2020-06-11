package com.cyn.ws.wsdemo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;
/**
 * 文件描述
 *
 * @ProjectName: ws-demo
 * @Package: com.cyn.ws.wsdemo
 * @Date 2020/6/11 20:31
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: note
 **/

@Configuration
public class WebSocketConfigOne {

    /**
     * 这个bean会自动注册使用了@ServerEndpoint注解声明的对象
     * 没有的话会报404
     *
     * @return
     */
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {

        return new ServerEndpointExporter();
    }
}