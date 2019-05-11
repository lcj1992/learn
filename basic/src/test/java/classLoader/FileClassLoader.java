package classLoader;

import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;

/**
 * Created by lcj on 15-5-16.
 */
public class FileClassLoader extends AbstractUserDefinedClassLoader {

    public FileClassLoader(String classPath) {
        super(classPath);
    }

    @Override
    public byte[] getClassData(String name) throws IOException {
        String pathAndName = getPathAndName(name);
        System.out.println(pathAndName);
        return Files.toByteArray(new File(pathAndName));
    }
}
