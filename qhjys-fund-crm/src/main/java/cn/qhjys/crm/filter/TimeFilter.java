package cn.qhjys.crm.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

/**
 * Create by 欧阳荣
 * 2018/5/24 21:34
 */
@Component  //让spring扫描到就可以直接加入到spirng容器中了
public class TimeFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("filter：init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        //业务处理
        System.out.println("filter doFilter");
        long time = new Date().getTime();
        filterChain.doFilter(request, response);
        long i = new Date().getTime()-time;
        System.out.println("filter 总耗时：" + i);
    }

    @Override
    public void destroy() {
        System.out.println("filter:destroy");
    }
}
