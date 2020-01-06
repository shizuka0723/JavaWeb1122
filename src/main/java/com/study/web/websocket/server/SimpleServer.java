package com.study.web.websocket.server;

import java.util.concurrent.CopyOnWriteArraySet;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/websocket/server")
public class SimpleServer {
    static CopyOnWriteArraySet<Session> sessions = new CopyOnWriteArraySet<>();
    //    static HashMap<String, List<Session>> map = new HashMap<>();
    //    static {
    //        map.put("101", new CopyOnWriteArrayList());
    //        map.put("102", new CopyOnWriteArrayList());
    //        map.put("103", new CopyOnWriteArrayList());
    //            }
    @OnOpen
    public void onOpen(Session session) {
        System.out.println("接到連線,sessionID:"+session.getId());
        sessions.add(session);
        sendAll("歡迎 sessionID: "+session.getId()+" 加入");
    }

    @OnMessage
    public void onMessage(String msg,Session session)throws Exception{
        String str = "sessionID: "+session.getId()+", msg: "+msg;
        System.out.println(str);
        sendAll(str);
    }
    
    @OnClose
    public void onClose(Session session) {
        System.out.println("關閉連線,sessionID: "+session.getId());
        sessions.remove(session);
        sendAll("sessionID: "+session.getId()+" 離開了");
    }
       
    public void sendAll(String msg){
        for(Session s : sessions){ //對每個連接的Client傳送訊息
            if(s.isOpen()){
                s.getAsyncRemote().sendText(msg);
            }
        }
    }
}
