package com.qst.crop.security.handler;

import com.alibaba.fastjson.JSON;
import com.qst.crop.common.Result;
import com.qst.crop.common.StatusCode;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * @author QST
 * @Description 登录失败操作
 * @Date 2021-08-24
 */
@Component
public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {

        ServletOutputStream outputStream = httpServletResponse.getOutputStream();
        String s = JSON.toJSONString(new Result(false, StatusCode.ERROR, "账号或密码错误，请输入正确的的信息"));
        outputStream.write(s.getBytes("UTF-8"));
        outputStream.flush();
        outputStream.close();
    }
}
