package com.bbnl.handler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

@Configuration
public class LoginSuccessHandler extends  SimpleUrlAuthenticationSuccessHandler{

	@Override
	protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		
		String targetUrl = determineTargetUrl(authentication);
		
		if (response.isCommitted()) {
			return;
		}
		RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
		redirectStrategy.sendRedirect(request, response, targetUrl);
	}

	//Fetch the roles from Authentication object
	protected String determineTargetUrl(Authentication authentication) {
		String url = "signin/?error=true";
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		List<String> roles = new ArrayList<String>();
		for (GrantedAuthority a : authorities) {
			roles.add(a.getAuthority());
		}
		
		//Check user role and decide the redirect URL
		if (roles.contains("ROLE_CUSTOMER")) {
			url = "/customer";
		}
		if (roles.contains("ROLE_USER")) {
			url = "/user";
		}
		if (roles.contains("ROLE_PROVIDER")) {
			url = "/provider";
		}
		if (roles.contains("ROLE_MINISTERIAL")) {
			url = "/ministerial";
		}
		return url;
	}

	
}
