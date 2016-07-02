package jdk.classLoader;

import com.google.common.io.Resources;

import java.io.IOException;
import java.net.URL;

/**
 * Created by lcj on 15-5-16.
 */
public class NetWorkClassLoader extends AbstractUserDefinedClassLoader {
    public NetWorkClassLoader(String classPath) {
        super(classPath);
    }

    @Override
    public byte[] getClassData(String name) throws IOException {
        String pathAndName = getPathAndName(name);
        return Resources.toByteArray(new URL(pathAndName));
    }
}
