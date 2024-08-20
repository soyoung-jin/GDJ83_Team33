package com.team3.tamagochi.friend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.team3.tamagochi.users.UsersDTO;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;


public class FriendChatHandler extends TextWebSocketHandler{


	private List<WebSocketSession> sessionList = new ArrayList<WebSocketSession>();

    private static Logger logger = LoggerFactory.getLogger(FriendChatHandler.class);
    
    private Map<String, Object> usersMap = new HashMap<String, Object>();
    
    
    //id가 키인 맵 만들기 -> 아이디
    //1:1 이면 두 사람의 세션만 꺼내서 통신 
    
  //클라이언트가 연결 되었을 때 실행
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
    	//세션에서 아이디를 꺼내서 웹소켓 세션아이디에 넣어줌
    	Map map = (Map)session.getAttributes();
    	UsersDTO usersDTO = (UsersDTO) map.get(("users_info"));
    	String id = usersDTO.getUser_id();
        //id: key , session: value 인 MAP을 만들어서 
    	sessionList.add(session);
        logger.info("{} 연결됨", id);
        
        // model.addAttribute("connectedId", id);
    }
    

    //클라이언트가 웹소켓 서버로 메시지를 전송했을 때 실행
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage chatContent) throws Exception {
    	Map map = (Map)session.getAttributes();
    	UsersDTO usersDTO = (UsersDTO) map.get(("users_info"));
    	String id = usersDTO.getUser_id();
    	
    	logger.info("{}: {} ", id, chatContent.getPayload());
        //모든 유저에게 메세지 출력
        for(WebSocketSession sess : sessionList){
            sess.sendMessage(new TextMessage(chatContent.getPayload()));
        }
    }

    //클라이언트 연결을 끊었을 때 실행
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
    	Map map = (Map)session.getAttributes();
    	UsersDTO usersDTO = (UsersDTO) map.get(("users_info"));
    	String id = usersDTO.getUser_id();
    	sessionList.remove(session);
        logger.info("{} 연결 끊김.", id);
    }
    
    
    
}
