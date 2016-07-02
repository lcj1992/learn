package com.demo;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;



public class HelloWorldClient {
    public static void main(String[] args) {
        JaxWsProxyFactoryBean svr = new JaxWsProxyFactoryBean();
        svr.setServiceClass(HelloWorld.class);
        svr.setAddress("http://localhost:8080/helloWorld");
        HelloWorld hw = (HelloWorld) svr.create();
        User user = new User();
        user.setName("Tony");
        user.setDescription("test");
        System.out.println(hw.sayHiToUser(user));
    }
}