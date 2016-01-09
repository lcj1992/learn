package serializable.decode;

import com.google.common.io.Files;
import learn.java.util.ByteUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by test on 2015/7/8.
 */
public class DecodeSerialByte {

    private static final Logger LOGGER = LoggerFactory.getLogger(DecodeSerialByte.class);

    public static void main(String[] args) throws Exception {
        String fileName = "temp.out";
        // read file
        byte[] allBytes = DecodeSerialByte.readFile(fileName);
        // print bytes
        ByteUtil.printHex(allBytes);
        // parse bytes
        int offset = 0;
        byte[] bytes;
        offset = parsePublic(allBytes, offset);

        // -----------------------------------------------
        // 上述公共的解析完成，下边开始逐个解析一个一个域
        offset = parseField(allBytes, offset);
        String type;

        bytes = ByteUtil.getSubBytes(allBytes, offset, 1);
        type = ByteUtil.byteToString(bytes);
        LOGGER.info(type);
        if ("t".equals(type)) {
            LOGGER.info("这代表一个新String");
        }
        offset += 1;
        bytes = ByteUtil.getSubBytes(allBytes, offset, 2);
        short length = ByteUtil.byteToShort(bytes);
        LOGGER.info("String 的长度为" + length);
        offset += 2;
        bytes = ByteUtil.getSubBytes(allBytes, offset, length);
        String newString = ByteUtil.byteToString(bytes);
        LOGGER.info(newString);
        offset += length;
        bytes = ByteUtil.getSubBytes(allBytes, offset, 1);
        type = ByteUtil.byteToString(bytes);
        LOGGER.info(type);
        if ("x".equals(type)) {
            LOGGER.info(" the end of the optional block data for an object");
        }
        offset += 1;
        bytes = ByteUtil.getSubBytes(allBytes, offset, 1);
        type = ByteUtil.byteToString(bytes);
        if ("r".equals(type)) {
            LOGGER.info("这是一个新类");
        }
        offset += 1;
        bytes = ByteUtil.getSubBytes(allBytes, offset, 2);
        length = ByteUtil.byteToShort(bytes);
        LOGGER.info("类名长度为" + length);
        offset += 2;
        bytes = ByteUtil.getSubBytes(allBytes, offset, length);
        String className = ByteUtil.byteToString(bytes);
        LOGGER.info("类名为" + className);
        offset += length;
        bytes = ByteUtil.getSubBytes(allBytes, offset, 8);
        long serialId = ByteUtil.byteToLong(bytes);
        LOGGER.info("{}", serialId);
        offset += 8;
        bytes = ByteUtil.getSubBytes(allBytes, offset, 1);
        String flag = ByteUtil.byteToHexString(bytes);
        canSerial(flag);
        offset += 1;
        bytes = ByteUtil.getSubBytes(allBytes, offset, 2);
        short fieldCount = ByteUtil.byteToShort(bytes);
        LOGGER.info("这个类有" + fieldCount + "个域");
        offset += 2;
        bytes = ByteUtil.getSubBytes(allBytes, offset, 1);
        type = ByteUtil.byteToString(bytes);
        if ("I".equals(type)) {
            LOGGER.info("int");
        }
        offset += 1;
        bytes = ByteUtil.getSubBytes(allBytes, offset, 2);
        length = ByteUtil.byteToShort(bytes);
        LOGGER.info("域的长度为" + length);
        offset += 2;
        bytes = ByteUtil.getSubBytes(allBytes, offset, length);
        fileName = ByteUtil.byteToString(bytes);
        LOGGER.info(fileName);
        offset += length;
        bytes = ByteUtil.getSubBytes(allBytes, offset, 1);
        type = ByteUtil.byteToHexString(bytes);
        LOGGER.info(type);
        if ("78".equals(type)) {
            LOGGER.info(" the end of the optional block data for an object");
        }
        offset += 1;
        bytes = ByteUtil.getSubBytes(allBytes, offset, 1);
        type = ByteUtil.byteToHexString(bytes);
        LOGGER.info(type);
        if ("70".equals(type)) {
            LOGGER.info("这个类没有父类啦");
        }
        offset += 1;
        bytes = ByteUtil.getSubBytes(allBytes, offset, 4);
        int value = ByteUtil.byteToInt(bytes);
        LOGGER.info("parentVersion的值" + value);
        offset += 4;
        bytes = ByteUtil.getSubBytes(allBytes, offset, 4);
        value = ByteUtil.byteToInt(bytes);
        LOGGER.info("version的值" + value);
        offset += 4;
        bytes = ByteUtil.getSubBytes(allBytes, offset, 1);
        type = ByteUtil.byteToHexString(bytes);
        if ("73".equals(type)) {
            LOGGER.info("new Object");
        }
        offset += 1;
        bytes = ByteUtil.getSubBytes(allBytes, offset, 1);
        type = ByteUtil.byteToHexString(bytes);
        if ("72".equals(type)) {
            LOGGER.info("new Class");
        }
        offset += 1;
        bytes = ByteUtil.getSubBytes(allBytes, offset, 2);
        length = ByteUtil.byteToShort(bytes);
        LOGGER.info("class length is " + length);
        offset += 2;
        bytes = ByteUtil.getSubBytes(allBytes, offset, length);
        className = ByteUtil.byteToString(bytes);
        LOGGER.info(className);
        offset += length;
        bytes = ByteUtil.getSubBytes(allBytes, offset, 8);
        serialId = ByteUtil.byteToLong(bytes);
        LOGGER.info("{}", serialId);
        offset += 8;
        bytes = ByteUtil.getSubBytes(allBytes, offset, 1);
        flag = ByteUtil.byteToHexString(bytes);
        if ("02".equals(flag)) {
            LOGGER.info("the class serialization");
        }
        offset += 1;
        bytes = ByteUtil.getSubBytes(allBytes, offset, 2);
        fieldCount = ByteUtil.byteToShort(bytes);
        LOGGER.info("the class contains " + fieldCount);
        offset += 2;
        bytes = ByteUtil.getSubBytes(allBytes, offset, 1);
        type = ByteUtil.byteToHexString(bytes);
        if ("49".equals(type)) {
            LOGGER.info("int");
        }
        offset += 1;
        bytes = ByteUtil.getSubBytes(allBytes, offset, 2);
        length = ByteUtil.byteToShort(bytes);
        LOGGER.info("域的长度为" + length);
        offset += 2;
        bytes = ByteUtil.getSubBytes(allBytes, offset, length);
        fileName = ByteUtil.byteToString(bytes);
        LOGGER.info(fileName);
        offset += length;
        bytes = ByteUtil.getSubBytes(allBytes, offset, 1);
        type = ByteUtil.byteToHexString(bytes);
        if ("78".equals(type)) {
            LOGGER.info(" the end of the optional block data for an object");
        }
        offset += 1;
        bytes = ByteUtil.getSubBytes(allBytes, offset, 1);
        flag = ByteUtil.byteToHexString(bytes);
        if ("70".equals(flag)) {
            LOGGER.info("这个类没有父类啦");
        }
        offset += 1;
        bytes = ByteUtil.getSubBytes(allBytes, offset, 4);
        int fieldValue = ByteUtil.byteToInt(bytes);
        LOGGER.info("{}", fieldValue);

        LOGGER.info(ByteUtil.byteToHexString("s".getBytes()));
        LOGGER.info(ByteUtil.byteToHexString("r".getBytes()));
        LOGGER.info(ByteUtil.byteToHexString("I".getBytes()));

    }

    private static int parsePublic(byte[] allBytes, int offset) throws Exception {
        byte[] bytes;
        bytes = ByteUtil.getSubBytes(allBytes, offset, 2);
        isSerialFile(bytes);
        offset += 2;
        bytes = ByteUtil.getSubBytes(allBytes, offset, 2);
        int streamVersion = ByteUtil.byteToShort(bytes);
        LOGGER.info("此序列化文件使用的是版本" + streamVersion + "协议");
        offset += 2;
        bytes = ByteUtil.getSubBytes(allBytes, offset, 1);
        isObject(bytes);
        offset += 1;
        bytes = ByteUtil.getSubBytes(allBytes, offset, 1);
        isClass(bytes);
        offset += 1;
        bytes = ByteUtil.getSubBytes(allBytes, offset, 2);
        short classNameLength = ByteUtil.byteToShort(bytes);
        LOGGER.info("类名的长度为" + classNameLength);
        offset += 2;
        bytes = ByteUtil.getSubBytes(allBytes, offset, classNameLength);
        String className = ByteUtil.byteToString(bytes);
        LOGGER.info("类名为" + className);
        offset += classNameLength;
        bytes = ByteUtil.getSubBytes(allBytes, offset, 8);
        long serialId = ByteUtil.byteToLong(bytes);
        LOGGER.info("{}", serialId);
        offset += 8;
        bytes = ByteUtil.getSubBytes(allBytes, offset, 1);
        String flag = ByteUtil.byteToHexString(bytes);
        canSerial(flag);
        offset += 1;
        return offset;
    }

    private static void canSerial(String flag) throws Exception {
        if (!"02".equals(flag)) {
            LOGGER.info("这个类不能串行化啊");
            throw new Exception("这个类不能串行化啊");
        }
    }

    private static int parseField(byte[] allBytes, int offset) throws UnsupportedEncodingException {
        byte[] bytes;
        bytes = ByteUtil.getSubBytes(allBytes, offset, 2);

        short fieldCount = ByteUtil.byteToShort(bytes);
        LOGGER.info("这个类有" + fieldCount + "个域");
        offset += 2;
        for (int i = 0; i < fieldCount; i++) {
            bytes = ByteUtil.getSubBytes(allBytes, offset, 1);
            String type = ByteUtil.byteToHexString(bytes);
            if ("49".equals(type)) {
                LOGGER.info("这个类还有一个int型数据");
            } else if ("42".equals(type)) {
                LOGGER.info("这个类还有一个byte型数据");
            } else if ("4C".equals(type)) {
                LOGGER.info("这个类还有一个引用类型数据");
            }
            offset += 1;
            bytes = ByteUtil.getSubBytes(allBytes, offset, 2);
            short fieldLength = ByteUtil.byteToShort(bytes);
            LOGGER.info("域的名长度为" + fieldLength);
            offset += 2;
            bytes = ByteUtil.getSubBytes(allBytes, offset, fieldLength);
            String fieldName1 = ByteUtil.byteToString(bytes);
            LOGGER.info(fieldName1);
            offset += fieldLength;
        }
        return offset;
    }

    private static boolean isClass(byte[] bytes) throws Exception {
        String isNewClass = ByteUtil.byteToHexString(bytes);
        if (!"72".equals(isNewClass)) {
            LOGGER.info("这不是一个类啊");
            throw new Exception("这不是一个类啊");
        }
        return false;
    }

    private static void isObject(byte[] bytes) throws Exception {
        String isNewObject = ByteUtil.byteToHexString(bytes);
        if (!"73".equals(isNewObject)) {
            LOGGER.info("这不是一个类的实例啊");
            throw new Exception("这不是一个类的实例啊");
        }
    }

    private static void isSerialFile(byte[] bytes) throws Exception {
        String magic = ByteUtil.byteToHexString(bytes);
        if (!"ACED".equals(magic)) {
            LOGGER.info("这不是个序列化文件");
            throw new Exception("这不是一个类的实例啊");
        }
    }

    private static byte[] readFile(String fileName) throws IOException {
        return Files.toByteArray(new File(fileName));
    }

}
