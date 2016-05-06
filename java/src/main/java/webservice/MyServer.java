package webservice;

import javax.xml.ws.Endpoint;

/**
 * Created by chuangjian.li
 * 16/5/7
 */

public class MyServer {

    public static void main(String[] args) {
        String address = "http://localhost:7777/fuck";
        Endpoint.publish(address, new MyService());
    }
}
