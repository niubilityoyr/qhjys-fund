package cn.qhjys.crm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author oyr
 * @Description: swagger配置文件
 * @date 2018/5/24 0024下午 6:02
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("cn.qhjys.crm.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("金钥匙新项目API")
                .description("rest ful风格API https://www.jysp2p.com/")
                .termsOfServiceUrl("http://blog.csdn.net/saytime")
                .contact("ouyangrong")  //这是创建人
                .version("1.0.0")
                .build();
    }

}
