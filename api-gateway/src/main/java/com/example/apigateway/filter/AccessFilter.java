package com.example.apigateway.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class AccessFilter extends ZuulFilter{

	@Override
	public Object run() throws ZuulException {
		
	    Logger log = LoggerFactory.getLogger(AccessFilter.class);

		// TODO Auto-generated method stub
		RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

      	log.info("send {} request to {}", request.getMethod(), request.getRequestURL().toString());

   /*   	String tokenHeader = request.getHeader("Authorization");
		if (tokenHeader == null) {
			tokenHeader = request.getParameter("accessToken");*/
        Object accessToken = request.getParameter("accessToken");
        if(accessToken == null) {
            log.warn("access token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            ctx.setResponseBody("{\"result\":\"Invalid token!\"}");  
            ctx.set("isSuccess", false);  
            return null;
        }
        log.info("access token ok");
        ctx.setSendZuulResponse(true);  
		ctx.setResponseStatusCode(200);  
		ctx.set("isSuccess", true);  
        return null;
	}

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";
	}

}
