package com.cyn.ws.wsdemo;

import java.io.IOException;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import org.springframework.stereotype.Component;
/**
 * 文件描述
 *
 * @ProjectName: web-socket-demo
 * @Package: com.cyn.websocketdemo
 * @Date 2020/6/11 19:55
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: note
 **/

/**
 * @ServerEndpoint 注解是一个类层次的注解，它的功能主要是将目前的类定义成一个websocket服务器端,
 * 注解的值将被用于监听用户连接的终端访问URL地址,客户端可以通过这个URL来连接到WebSocket服务器端
 */
@ServerEndpoint(value="/websocketTest/{userId}")
@Component
public class WsDemo {

    private static String userId;

    /**
     * 连接时执行
     * @param userId
     * @param session
     * @throws IOException
     */
    @OnOpen
    public void onOpen(@PathParam("userId") String userId,Session session) throws IOException{
        WsDemo.userId = userId;
        System.out.println("新连接："+userId);
    }

    /**
     * 关闭时执行
     */
    @OnClose
    public void onClose(){
        System.out.println("连接：{} 关闭"+WsDemo.userId);
    }

    /**F
     * 收到消息时执行
     * @param message
     * @param session
     * @throws IOException
     */
    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        System.out.println("收到用户{}的消息{}"+WsDemo.userId+message);
        //回复用户
        session.getBasicRemote().sendText("收到 "+WsDemo.userId+" 的消息 ");
    }

    /**
     * 连接错误时执行
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error){
        System.out.println("用户id为：{}的连接发送错误"+WsDemo.userId);
        error.printStackTrace();
    }

}
