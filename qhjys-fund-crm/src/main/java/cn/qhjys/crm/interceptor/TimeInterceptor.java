package cn.qhjys.crm.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * Create by 欧阳荣
 * 2018/5/24 21:38
 */
@Component  //不会自己加入拦截器中，需要配置
public class TimeInterceptor implements HandlerInterceptor{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //前置执行
        System.out.println("Interceptor preHandle");
        HandlerMethod method = (HandlerMethod) handler;
        System.out.println("类：" + method.getBean().getClass().getName());
        System.out.println("方法名："+method.getMethod().getName());
        long startTime = new Date().getTime();
        request.setAttribute("startTime", startTime);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {
        //出现异常不会执行
        System.out.println("Interceptor postHandle");
        System.out.println();
        long startTime = (long) request.getAttribute("startTime");
        long cj = new Date().getTime() - startTime;
        System.out.println("Interceptor 总耗时:"+ cj);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) throws Exception {
        //最后执行，出现异常也会执行
        System.out.println("Interceptor afterCompletion");
        long startTime = (long) request.getAttribute("startTime");
        long cj = new Date().getTime() - startTime;
        System.out.println("Interceptor 总耗时:"+ cj);
    }
}
