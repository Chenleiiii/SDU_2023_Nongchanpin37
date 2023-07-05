package com.qst.crop.security.handler;

import com.alibaba.fastjson.JSON;
import com.qst.crop.common.Result;
import com.qst.crop.common.StatusCode;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * @author QST
 * @Description 权限校验处理器
 * @Date 2021-08-24
 */
@Component
public class RestAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {

        System.out.println("权限校验处理器");
        ServletOutputStream outputStream = response.getOutputStream();
        String s = JSON.toJSONString(new Result(false, StatusCode.ERROR, "您没有权限"));
        outputStream.write(s.getBytes("UTF-8"));
        outputStream.flush();
        outputStream.close();
    }
}
