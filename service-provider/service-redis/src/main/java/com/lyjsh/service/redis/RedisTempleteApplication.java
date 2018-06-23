
package com.lyjsh.service.redis;

import com.lyjsh.service.redis.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author wl
 * @Date 2018/6/23 21:19
 * @Todo redis连接工具服务
 */

@SpringBootApplication
@EnableEurekaClient
public class RedisTempleteApplication {

    @Autowired
    private RedisUtil redisUtil;

    public static void main(String[] args) {
        SpringApplication.run(RedisTempleteApplication.class);
    }
}
