package mdc;


import com.caucho.hessian.io.HessianInput;
import com.caucho.hessian.io.HessianOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by lcj on 15-9-16.
 */
public class MdcTest {
    private static final Logger logger = LoggerFactory.getLogger(MdcTest.class);


    private static ThreadLocal<String> site = new ThreadLocal<String>();

    public static void main(String[] args) {
        try {
            for (int i = 0; i < 10; i++) {
                MDC.put("site", "CA" + i);
                MDC.put("orderId", "1234" + i);
                MDC.put("sessionId", "1213212" + i);
                logger.info("heheda");
            }
        } finally {
            MDC.clear();
        }


    }

    public byte[] serialize(Object obj) throws IOException {
        if(obj==null) throw new NullPointerException();

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        HessianOutput ho = new HessianOutput(os);
        ho.writeObject(obj);
        return os.toByteArray();
    }

    public Object deserialize(byte[] by) throws IOException{
        if(by==null) throw new NullPointerException();

        ByteArrayInputStream is = new ByteArrayInputStream(by);
        HessianInput hi = new HessianInput(is);
        return hi.readObject();
    }
}