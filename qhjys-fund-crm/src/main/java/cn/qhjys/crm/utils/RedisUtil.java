package cn.qhjys.crm.utils;

import lombok.Data;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author oyr
 * @Description: ${todo}
 * @date 2018/5/25 0025上午 11:58
 */
@Setter
public class RedisUtil {


    /**
         redisTemplate.opsForValue();//操作字符串
         redisTemplate.opsForHash();//操作hash
         redisTemplate.opsForList();//操作list
         redisTemplate.opsForSet();//操作set
         redisTemplate.opsForZSet();//操作有序set
     */


    /**
        TimeUnit.DAYS //天
        TimeUnit.HOURS //小时
        TimeUnit.MINUTES //分钟
        TimeUnit.SECONDS //秒
        TimeUnit.MILLISECONDS //毫秒
     */


    private RedisTemplate redisTemplate;

    private StringRedisTemplate stringRedisTemplate;

    /*操作string时推荐使用StringRedisTemplate*/


    /**
    * ======================================对string类型操作
    */

    public void set(String key, String json, Long time){
        stringRedisTemplate.opsForValue().set(key, json, time, TimeUnit.SECONDS);
    }

    public void set(String key, String json){
        stringRedisTemplate.opsForValue().set(key, json);
    }

    public String get(String key) {
        String json = stringRedisTemplate.opsForValue().get(key);
        return json;
    }

    public void del(String key){
        stringRedisTemplate.delete(key);
    }



    /**
     * ======================================对hash类型操作
     */

    public void hset(String prefixKey, String key, String json){
        redisTemplate.opsForHash().put(prefixKey, key, json);
    }

    public String hget(String prefixKey, String key){
        return (String) redisTemplate.opsForHash().get(prefixKey, key);
    }

    public void hdel(String prefixKey, String key){
        redisTemplate.opsForHash().delete(prefixKey, key);
    }

    /*判断是否存在，返回true和false*/
    public Boolean hexist(String prefixKey, String key){
        return redisTemplate.opsForHash().hasKey(prefixKey, key);
    }

    /*获取key所对应的散列表的key*/
    public Set hkeys(String prefixKey){
        Set keys = redisTemplate.opsForHash().keys(prefixKey);
        return keys;
    }

    /*获取key所对应的散列表的value*/
    public List values(String prefixKey){
        List values = redisTemplate.opsForHash().values(prefixKey);
        return values;
    }
}
