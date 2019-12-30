package com.study.web.rest;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("rest")
public class ApplicationConfig extends ResourceConfig {

    public ApplicationConfig() {// 在此路徑或其子路徑下的資源都被管理
        packages("com.web.rest");
    }
}
