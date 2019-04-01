package com.derun.jczb;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
//import javax.websocket.server.ServerEndpoint;

//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.PathVariable;

//@Component
//@ServerEndpoint("/websocket/{sid}")
public class WebsocketServer {

//    private String sid="";
    private Session session;
    @OnOpen
    public void onOpen(Session session) throws IOException, InterruptedException {    
    	this.session=session;
        try {
        	 sendMessage("连接成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
        while(true) {
        	sendMessage(LocalDateTime.now().toString());
        	Thread.sleep(1000);
        }
    }
    @OnMessage
    public void onMessage(String message) throws IOException {
//    	log.info("收到来自窗口"+sid+"的信息:"+message);
        //群发消息
//        for (WebsocketServer item : webSocketSet) {
//            try {
//                item.sendMessage(message);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    	sendMessage(LocalDateTime.now().toString());
    }

	/**
	 * 
	 * @param session
	 * @param error
	 */
    @OnError
    public void onError( Throwable error) {

        error.printStackTrace();
    }
	/**
	 * 实现服务器主动推送
	 */
    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }
}
