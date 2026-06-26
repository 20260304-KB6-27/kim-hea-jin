package org.scoula.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker  // WebSocket, STOMP 활성화
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

  // client가 WebSocket 최초 연결 시 사용할 endpoint
  // 연결하기 위한 요청 경로 설정
  @Override
  public void registerStompEndpoints(StompEndpointRegistry registry) {
    registry.addEndpoint("/chat-app")  // ws://localhost:8080/chat-app로 연결 요청
            .setAllowedOrigins("*");  // CORS 허용
  }

  // 요청 전달할 주소(경로) 설정
  @Override
  public void configureMessageBroker(MessageBrokerRegistry registry) {

    // /topic으로 시작하는 경로는 브로커가 처라 (server -> client로 전달 시 사용)
    // ex) /topic/chat, /topic/greeting
    registry.enableSimpleBroker("/topic");

    // client -> server 요청 보낼 때 사용
    // /app/chat: 사용자가 message 보내면 서버에서 @MessageMapping("/chat")으로 연결
    registry.setApplicationDestinationPrefixes("/app");
  }


}
