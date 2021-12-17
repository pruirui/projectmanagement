package com.xiao.interceptor;

import com.xiao.constant.MessageConstant;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        System.out.println(session.getId());
        if(session.getAttribute(MessageConstant.LOGIN_USER)==null){
            String s = request.getHeader("Origin");
            if(s == null){
                s = request.getRequestURL().toString();
                int cnt = 0;
                for(int i =0;i<s.length();i++){
                    char c = s.charAt(i);
                    if(c == '/'){
                        cnt++;
                        if(cnt == 3){
                            cnt=i;
                            break;
                        }
                    }
                }
                String url = s.substring(0,cnt)+"/login.html";
                response.sendRedirect(url);
            }else{
                String url = s+"/login.html";
                response.sendRedirect(url);
            }
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
