package com.amsidh.mvc.publisher;

import com.amsidh.mvc.entity.Person;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/person")
@Slf4j
public class PersonController {

    private final RedisTemplate redisTemplate;
    private final ChannelTopic channelTopic;

    @PostMapping("/publish")
    public String publishPerson(@RequestBody Person person) {
        redisTemplate.convertAndSend(channelTopic.getTopic(), person.toString());
        return "Person published successfully on topic " + channelTopic.getTopic();
    }

}
