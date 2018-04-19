package com.mercury.SpringBootRestDemo.security.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.mercury.SpringBootRestDemo.security.SecurityUtils;

@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		// when user try to access api without logged in.
		SecurityUtils.sendResponse(response, HttpServletResponse.SC_OK, "You must login first!", authException);
	}

}
