package com.roger.config;

import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ServerList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class DefaultRibbonConfig {

    @Value("${ribbon.client.name}")
    private String clientName;

    @Bean
    public ServerList<Server> dbServerList(){


        return new ServerList<Server>() {
            @Override
            public List<Server> getInitialListOfServers() {
                System.out.println("clientName:" + clientName);
                return new ArrayList<Server>(){{add(new Server("www.baidu.com", 80));}};
            }

            @Override
            public List<Server> getUpdatedListOfServers() {
                System.out.println("clientName:" + clientName);
                System.out.println("enter update");
                //do your db fetch operation
                return new ArrayList<Server>(){{add(new Server("www.163.com", 80));add(new Server("www.baidu.com", 80));}};
            }
        };
    }
}
