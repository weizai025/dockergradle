package com.nju.config;

import javax.websocket.Session;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author maw-b
 * @date 2021/8/24 17:58
 */
public class SessionPool {

    public static Map<String, Session> sessionMap = new ConcurrentHashMap<>();

    public static void close(String sessionId) throws IOException {
        for(String userId:sessionMap.keySet()){
            Session session = sessionMap.get(userId);
            if(session!=null && session.getId().equals(sessionId)){
                sessionMap.remove(userId);
                break;
            }
        }
    }

    public static void sendMessage(String sessionId,String message){
        sessionMap.get(sessionId).getAsyncRemote().sendText(message);
    }

    public static void sendMessage(String message){
        for(String sessionId:sessionMap.keySet()){
            sessionMap.get(sessionId).getAsyncRemote().sendText(message);
        }
    }
}
