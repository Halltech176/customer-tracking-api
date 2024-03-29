package com.halltech;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingPongController {
    record PingPong(String result){}
    @GetMapping("/pong")
    public PingPong getPingPong() {
        return new PingPong("Pong");
    }
}
