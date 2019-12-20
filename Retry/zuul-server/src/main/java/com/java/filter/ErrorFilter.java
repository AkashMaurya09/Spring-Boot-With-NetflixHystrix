package com.java.filter;

import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class ErrorFilter extends ZuulFilter {
private static Logger log = LoggerFactory.getLogger(PreFilter.class);
	
	@Override
	public String filterType() {
		return "error";
	}
	
	@Override
	public int filterOrder() {
		return 1;
	}
	
	@Override
	public boolean shouldFilter() {
		return true;
	}
	
	@Override
	public Object run() {
		HttpServletResponse response = RequestContext.getCurrentContext().getResponse();
		
		log.info("Errorfilter : " +String.format("Response content type is %d", response .getStatus()));
		
		return null;
	}

}
