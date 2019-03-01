package com.wsf.interceptor;

import com.wsf.model.TUser;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author: WangShangfei
 * @date: 2019 -上午 9:56
 * @tel:18738322951
 */
public class UserInterceptor implements HandlerInterceptor{
    @Override
    public boolean preHandle(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, Object o) throws Exception {
        TUser user = (TUser) request.getSession().getAttribute("user");
        if(user==null){
            String path = request.getContextPath();
            response.sendRedirect(path+"/user/toLogin.do");
        }
        return true;
    }

    @Override
    public void postHandle(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
