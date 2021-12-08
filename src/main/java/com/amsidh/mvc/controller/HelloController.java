package com.amsidh.mvc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping
    @Cacheable(value = "helloCache", keyGenerator = "customKeyGenerator")
    public String sayHello() {
        log.info("HelloController's sayHello Method called");
        return "{\"message\":\"Hello World\"}";
    }
}
