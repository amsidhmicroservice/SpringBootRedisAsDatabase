package com.amsidh.mvc.entity;

import java.io.Serializable;

import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@RedisHash(value = "PERSON")
public class Person implements Serializable {
	private static final long serialVersionUID = 6362698960276897633L;
	private Integer id;
	private String name;
	private String address;
}
