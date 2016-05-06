package webservice;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by chuangjian.li
 * 16/5/7
 */
public class MyClient {

    public static void main(String[] args) {
        try {
            URL url = new URL("http://localhost:7777/fuck?wsdl");
            QName qName = new QName("http://webservice/", "MyServiceService");
            Service service = Service.create(url, qName);
            IMyService ms = service.getPort(IMyService.class);
            ms.add(1,2);
            ms.minus(1,2);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
