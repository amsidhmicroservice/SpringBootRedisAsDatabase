package com.amsidh.mvc.entity;

import lombok.*;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RedisHash("Person")
public class Person implements Serializable {
    private static final long serialVersionUID = 6362698960276897633L;
    private Integer id;
    private String name;
    private String address;
}
