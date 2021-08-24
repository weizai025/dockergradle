package com.nju.config;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author maw-b
 * @date 2021/8/24 17:50
 */
@ServerEndpoint(value = "/websocket/{userId}")
@Component
public class WebSocketConfig {

    /**
     * 成功建立连接调用方法
     * @param session
     * @param userId
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("userId")String userId){
        SessionPool.sessionMap.put(userId,session);
    }

    /**
     * 连接关闭调用方法
     * @param session
     */
    @OnClose
    public void onClose(Session session) throws IOException {
        SessionPool.close(session.getId());
        session.close();
    }

    /**
     * 收到客户端消息后调用方法
     * @param message
     * @param session
     */
    @OnMessage
    public void onMessage(String message,Session session){
        if (message.equalsIgnoreCase("ping")) {
            try {
                Map<String, Object> params = new HashMap<String, Object>();
                params.put("type", "pong");
                session.getBasicRemote().sendText(JSON.toJSONString(params));
                System.out.println("应答客户端的消息:" + JSON.toJSONString(params));
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        } else {
            SessionPool.sendMessage(message);
        }
    }
}
