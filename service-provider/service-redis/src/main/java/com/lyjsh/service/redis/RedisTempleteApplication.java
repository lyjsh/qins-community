
package com.lyjsh.service.redis;

import com.lyjsh.service.redis.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author wl
 * @Date 2018/6/23 21:19
 * @Todo redis连接工具服务
 */

@RestController
@SpringBootApplication
@EnableEurekaClient
public class RedisTempleteApplication {

    @Autowired
    private RedisUtil redisUtil;

    public static void main(String[] args) {
        SpringApplication.run(RedisTempleteApplication.class);
    }

    @GetMapping("/redis/{id}")
    public String test(@PathVariable String id) {
        return id;
    }

}
