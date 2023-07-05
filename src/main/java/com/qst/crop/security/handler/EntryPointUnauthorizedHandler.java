package com.qst.crop.security.handler;

import com.alibaba.fastjson.JSON;
import com.qst.crop.common.Result;
import com.qst.crop.common.StatusCode;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * @author QST
 * @Description 身份校验失败处理器，如 token 错误
 * @Date 2021-08-24
 */
@Component
public class EntryPointUnauthorizedHandler implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {

        ServletOutputStream outputStream = response.getOutputStream();
        String s = JSON.toJSONString(new Result(false, StatusCode.ERROR, "您未登录，请先登录"));
        outputStream.write(s.getBytes("UTF-8"));
        outputStream.flush();
        outputStream.close();
    }
}
