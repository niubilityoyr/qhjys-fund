package cn.qhjys.crm.config;

import cn.qhjys.crm.interceptor.TimeInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.Resource;

/**
 * @author oyr
 * @Description: ${todo}
 * @date 2018/5/24 0024上午 10:19
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Resource
    private TimeInterceptor timeInterceptor;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /*让swagger能正常的访问页面*/
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("swagger-ui.html")
            .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
            .addResourceLocations("classpath:/META-INF/resources/webjars/");
        super.addResourceHandlers(registry);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //添加拦截器并指定拦截路径
        registry.addInterceptor(timeInterceptor).addPathPatterns("/*");
    }
}
