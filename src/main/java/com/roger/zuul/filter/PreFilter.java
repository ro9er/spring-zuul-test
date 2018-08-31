package com.roger.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.SERVICE_ID_KEY;

@Component
@RefreshScope
public class PreFilter extends ZuulFilter implements EnvironmentAware {

    @Value("${roger.test.name}")
    private String test;

    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    private Environment environment;

    @Override
    public Object run() throws ZuulException {
        //do db fetch in external resource and store mapping here to set router service id.
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String  uri = request.getRequestURI();
        System.out.println("enter uri:" + uri);
        String serviceId = uri.substring(uri.indexOf("open-api/")+ "open-api/".length());
        ctx.set(SERVICE_ID_KEY, serviceId);
        System.out.println(test);
        System.out.println(environment.getProperty("roger.test.name"));
        return null;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
