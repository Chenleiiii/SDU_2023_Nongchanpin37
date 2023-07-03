package com.qst.crop.security.filter;

import com.qst.crop.security.util.JwtTokenUtil;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author QST
 * @Description 请求拦截器，根据传过来的token，进行认证
 * @Date 2021-08-24
 */
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    @Resource
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @SneakyThrows
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        /**
         * 此方法，每次前端发起请求，都要去查询数据库，保证用户名密码正确。大垃圾
         */
        String token = request.getHeader(jwtTokenUtil.getHeader());
//        System.out.println("request:"+request);
//        System.out.println("token:"+token);
        if (!StringUtils.isEmpty(token)) {
            String username = jwtTokenUtil.getUsernameFromToken(token);

            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                //从数据库查询用户名、密码等用户信息
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
//                System.out.println("userDetails"+userDetails);
                if (jwtTokenUtil.validateToken(token, userDetails)) {//验证token中的用户名和密码是否正确，与userDetails对比
                    //如果正确的话 将用户信息存入 authentication，方便后续校验
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    // 将 authentication 存入 ThreadLocal，方便后续获取用户信息
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        }
        chain.doFilter(request, response);
    }
}
