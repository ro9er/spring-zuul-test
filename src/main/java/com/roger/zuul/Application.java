package com.roger.zuul;

import com.roger.config.DefaultRibbonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
@RibbonClients(defaultConfiguration = DefaultRibbonConfig.class)
public class Application {

    public static void main(String[] args){
        SpringApplication.run(Application.class);
    }
}
