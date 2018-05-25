package cn.qhjys.crm.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author oyr
 * @Description: redis属性文件，相对应redis.properties文件中的值
 * @date 2018/5/25 0025下午 2:11
 */
@Data
@Component
@ConfigurationProperties(prefix = "redis")
public class RedisBean {

    private String hostName;

    private int port;

    private String password;

    private int timeout;

    private int maxIdle;

    private String maxActive;

    private int maxTotal;

    private long maxWaitMillis;

    private long minEvictableIdleTimeMillis;

    private int numTestsPerEvictionRun;

    private long timeBetweenEvictionRunsMillis;

    private Boolean testOnBorrow;

    private Boolean testWhileIdle;

}
