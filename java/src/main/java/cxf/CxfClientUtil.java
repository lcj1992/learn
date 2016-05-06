package cxf;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;

/**
 * Created by chuangjian.li
 * 16/5/7
 */
public class CxfClientUtil {
    public static final long DEFAULT_CONN_TIMEOUT = 10000;

    public static final long DEFAULT_RECEIVE_TIMEOUT = 30000;

    /**
     *
     * @param service 客户端service
     * @param connTimeout 连接超时 ms
     * @param receiveTimeout 接收超时 ms
     */
    public static void setTimeout(Object service, long connTimeout, long receiveTimeout) {
        Client proxy = ClientProxy.getClient(service);
        HTTPConduit conduit = (HTTPConduit) proxy.getConduit();
        HTTPClientPolicy policy = new HTTPClientPolicy();
        policy.setConnectionTimeout(connTimeout);
        policy.setReceiveTimeout(receiveTimeout);
        conduit.setClient(policy);
    }

    public static void setTimeout(Object service) {
        setTimeout(service, DEFAULT_CONN_TIMEOUT, DEFAULT_RECEIVE_TIMEOUT);
    }
}
