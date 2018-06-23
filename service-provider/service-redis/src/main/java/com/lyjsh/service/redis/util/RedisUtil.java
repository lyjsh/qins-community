package com.lyjsh.service.redis.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lyjsh.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;
import java.util.concurrent.TimeUnit;
import java.util.List;
/**
 * @Author wl
 * @Date 2018/6/23 21:44
 * @Todo redis操作工具类
 */

@Service
public class RedisUtil {
    @Autowired//通过Spring依赖注入 redisTemlpate
    private RedisTemplate<String, ?> redisTemplate;

    //往Redis设置值
    public boolean set(final String key, final String value) {
        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {

            public Boolean doInRedis(RedisConnection connection)
                    throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                connection.set(serializer.serialize(key), serializer.serialize(value));
                return true;
            }
        });
        return result;
    }

    //从Redis获取值
    public String get(final String key) {
        String result = redisTemplate.execute(new RedisCallback<String>() {
            public String doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                byte[] value = connection.get(serializer.serialize(key));
                return serializer.deserialize(value);
            }
        });
        return result;
    }

    public boolean expire(final String key, long expire) {
        return redisTemplate.expire(key, expire, TimeUnit.SECONDS);
    }

    //往Redis设置list类型值
    public <T> boolean setList(String key, List<T> list) {
        Gson gson = new Gson();
        String value = gson.toJson(list);
        return set(key, value);
    }

    //从Redis获取list类型值
    public <T> List<T> getList(String key) {
        String json = get(key);
        if (json != null) {
            List<T> list = JsonUtil.fromJson(json, new TypeToken<List<T>>(){}.getType());
            return list;
        }
        return null;
    }

    //往list头添加元素
    public long lpush(final String key, Object obj) {
        final String value = JsonUtil.toJson(obj);
        long result = redisTemplate.execute(new RedisCallback<Long>() {
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                long count = connection.lPush(serializer.serialize(key), serializer.serialize(value));
                return count;
            }
        });
        return result;
    }

    //往list尾添加元素
    public long rpush(final String key, Object obj) {
        final String value = JsonUtil.toJson(obj);
        long result = redisTemplate.execute(new RedisCallback<Long>() {
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                long count = connection.rPush(serializer.serialize(key), serializer.serialize(value));
                return count;
            }
        });
        return result;
    }

    //往list头删除元素
    public String lpop(final String key) {
        String result = redisTemplate.execute(new RedisCallback<String>() {
            public String doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                byte[] res = connection.lPop(serializer.serialize(key));
                return serializer.deserialize(res);
            }
        });
        return result;
    }
}
