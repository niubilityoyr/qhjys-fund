package cn.qhjys.crm.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * @author oyr
 * @Description: ${todo}
 * @date 2018/5/25 0025下午 2:51
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisUtilTest {

    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void set() {
        redisUtil.set("name", "oyr");
    }

    @Test
    public void get() {
        System.out.println(redisUtil.get("name"));
    }

    @Test
    public void del() {
        redisUtil.del("name");
    }

    @Test
    public void hset() {
        redisUtil.hset("user", "name", "oyr");
        redisUtil.hset("user", "age", "23");
        redisUtil.hset("user", "sex", "男");
    }

    @Test
    public void hget() {
        System.out.println(redisUtil.hget("user", "name"));
    }

    @Test
    public void hdel() {
        redisUtil.hdel("user", "name");
    }

    @Test
    public void hexist() {
        System.out.println(redisUtil.hexist("user", "name"));
    }

    @Test
    public void hkeys() {
        Set user = redisUtil.hkeys("user");
        for (Object o : user) {
            System.out.println(o);
        }
    }

    @Test
    public void values() {
        List user = redisUtil.values("user");
        for (Object o : user) {
            System.out.println(o);
        }
    }

}