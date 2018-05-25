package cn.qhjys.crm.controller;

import cn.qhjys.crm.properties.RedisBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author oyr
 * @Description: ${todo}
 * @date 2018/5/25 0025下午 2:14
 */
@RequestMapping("/redis")
@RestController
public class RedisController {

    @Resource
    private RedisBean redisBean;

    @RequestMapping
    public RedisBean show() {
        return redisBean;
    }
}
