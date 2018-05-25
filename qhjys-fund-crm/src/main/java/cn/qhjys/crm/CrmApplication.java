package cn.qhjys.crm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@PropertySource(value={"classpath:/redis.properties"}, ignoreResourceNotFound=true)	//配置扫描属性文件
@EnableSwagger2	//开启Swagger
@MapperScan("cn.qhjys.crm.dao")	//扫描到mapper
@SpringBootApplication
public class CrmApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrmApplication.class, args);
	}
}
