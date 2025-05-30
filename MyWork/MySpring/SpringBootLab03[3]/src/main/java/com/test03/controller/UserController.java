package com.test03.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections; // Map.of()는 Java 9+에서 사용 가능하므로, 이전 버전을 위해 Collections.singletonMap() 사용
import java.util.Map;

@RestController
public class UserController {
   
    @GetMapping("/v1/users/me") 
    public Map<String, String> getMyInfo() {       
        return Collections.singletonMap("nickname", "홍길동");
        
    }
}