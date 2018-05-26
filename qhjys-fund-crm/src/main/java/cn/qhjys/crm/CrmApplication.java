package cn.qhjys.crm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableAutoConfiguration
@PropertySource(value={"classpath:/properties/redis.properties", "classpath:/aaa.properties"}, ignoreResourceNotFound=true)	//配置扫描属性文件
@EnableSwagger2	//开启Swagger
@MapperScan("cn.qhjys.crm.mapper")	//扫描到mapper
@SpringBootApplication
public class CrmApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrmApplication.class, args);
	}

}
