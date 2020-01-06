package com.study.web.websocket.clinet;

import java.net.URI;
import javax.websocket.ClientEndpoint;
import javax.websocket.ContainerProvider;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

@ClientEndpoint
public class SimpleClient {
    public static void main(String[] args) throws Exception{
        URI uri = new URI("ws://localhost:8080/JavaWeb1122/websocket/server");
        WebSocketContainer container = ContainerProvider.getWebSocketContainer();
        Session session = container.connectToServer(new SimpleClient(), uri);
        
        Thread.sleep(10000);
        session.close();
    }
    @OnOpen
    public void onOpen(Session session) {
        System.out.printf("Client say: %s 已進入\n", session.getId());
    }

    
    @OnClose
    public void onClose(Session session) {
    }

    @OnMessage
    public void onMessage(String msg,Session session)throws Exception{
    }
    
}
