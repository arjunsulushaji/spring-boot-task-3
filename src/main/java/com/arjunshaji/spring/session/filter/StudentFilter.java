package com.arjunshaji.spring.session.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import java.io.IOException;

@Component
public class StudentFilter implements Filter {
    private static final String REDIS_HOST = "localhost";
    private static final int REDIS_PORT = 6379;

    public String Key(String keyName){
        try(Jedis jedis = new Jedis(REDIS_HOST,REDIS_PORT)){
            return jedis.get(keyName);
        } catch (Exception e){
            return null;
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        String sessionId = Key("sessionId");

        String requestUrl = servletRequest.getRequestURI();

        if(requestUrl.startsWith("/student/")){
            if(sessionId != null){
                filterChain.doFilter(request,response);
            } else {
                httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
                response.getWriter().write("REDIRECTING TO LOGIN PAGE || ADMIN LOGIN REQUIRED.........");
            }
        } else {
            filterChain.doFilter(request,response);
        }
    }
}
