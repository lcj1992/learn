package deepInJvm.javap;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.io.Files;
import learn.java.deepInJvm.javap.constant.*;
import learn.java.util.ByteUtil;
import learn.java.util.JsonUtil;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by lcj on 15-6-11.
 */
public class JavapVerbose {

    private static final int MAGIC_NUM_LENGTH = 4;

    private static final int MINOR_VER_LENGTH = 2;

    private static final int MAJOR_VER_LENGTH = 2;
    public static final int CONSTANT_POOL_COUNT = 2;

    private String fileName;

    private static Map<Integer, String> constantTagMap = Maps.newHashMap();

    static {
        constantTagMap.put(1, ConstantUtf8Info.class.getName());
        constantTagMap.put(3, ConstantIntegerInfo.class.getName());
        constantTagMap.put(4, ConstantFloatInfo.class.getName());
        constantTagMap.put(5, ConstantLongInfo.class.getName());
        constantTagMap.put(6, ConstantDoubleInfo.class.getName());
        constantTagMap.put(7, ConstantClassInfo.class.getName());
        constantTagMap.put(8, ConstantStringInfo.class.getName());
        constantTagMap.put(9, ConstantFieldrefInfo.class.getName());
        constantTagMap.put(10, ConstantMethodrefInfo.class.getName());
        constantTagMap.put(11, ConstantInterfaceMethodrefInfo.class.getName());
        constantTagMap.put(12, ConstantNameAndTypeInfo.class.getName());
        constantTagMap.put(15, ConstantMethodHandleInfo.class.getName());
        constantTagMap.put(16, ConstantMethodTypeInfo.class.getName());
        constantTagMap.put(18, ConstantInvokeDynamicInfo.class.getName());
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public JavapVerbose(String fileName) {
        this.fileName = fileName;
    }

    public ClassInfo conduct() throws IOException, IllegalAccessException, InstantiationException,
            ClassNotFoundException {
        ClassInfo classInfo = new ClassInfo();
        int offset = 0;
        // class文件的字节数组
        byte[] bytes = Files.toByteArray(new File(this.fileName));
        // magic num
        String magic = ByteUtil.byteToHexString(ByteUtil.getSubBytes(bytes, offset, MAGIC_NUM_LENGTH));
        if (!isClassFile(magic)) {
            throw new RuntimeException("the file " + this.fileName + "is not a class file!");
        }
        classInfo.setMagicNum(magic);
        offset = MAGIC_NUM_LENGTH;

        // 最小版本，最大版本
        classInfo.setMinorVer(ByteUtil.byteToShort(ByteUtil.getSubBytes(bytes, offset, MINOR_VER_LENGTH)));
        offset += MINOR_VER_LENGTH;
        classInfo.setMajorVer(ByteUtil.byteToShort(ByteUtil.getSubBytes(bytes, offset, MAJOR_VER_LENGTH)));
        offset += MAJOR_VER_LENGTH;

        // 常量池中常量数量
        classInfo.setConstantCount(ByteUtil.byteToShort(ByteUtil.getSubBytes(bytes, offset, CONSTANT_POOL_COUNT)));
        // 常量
        offset += CONSTANT_POOL_COUNT;
        int constantLength = handleConstant(classInfo, bytes, offset);

        // 访问标志
        offset += constantLength;
        handleAccessFlag(classInfo, bytes, offset);
        // 类索引
        offset += 2;
        classInfo.setThisClass(ByteUtil.byteToShort(ByteUtil.getSubBytes(bytes, offset, 2)));
        // 父类索引
        offset += 2;
        classInfo.setSuperClass(ByteUtil.byteToShort(ByteUtil.getSubBytes(bytes, offset, 2)));
        // 接口数
        offset += 2;
        classInfo.setInterfaceCount(ByteUtil.byteToShort(ByteUtil.getSubBytes(bytes, offset, 2)));
        // 接口
        offset += 2;
        handleInterface(classInfo, bytes, offset);
        // 域数
        offset += classInfo.getInterfaceCount() * 2;
        classInfo.setFiledCount(ByteUtil.byteToShort(ByteUtil.getSubBytes(bytes, offset, 2)));
        // 域
        offset += 2;
        int fieldOffset = handleField(classInfo, bytes, offset);

        //
        offset += fieldOffset;
        System.out.println(JsonUtil.writeObjectToJson(classInfo));
        return classInfo;
    }

    private int handleField(ClassInfo classInfo, byte[] bytes, int offset) {
        Preconditions.checkNotNull(classInfo);
        int fieldCount = classInfo.getConstantCount();
        int offsetOrigin = offset;
        List<FieldInfo> fieldInfoList = Lists.newArrayList();
        for (int i = 0; i < fieldCount; i++) {
            FieldInfo fieldInfo = new FieldInfo();
            short fieldAccessFlag = ByteUtil.byteToShort(ByteUtil.getSubBytes(bytes, offset, 2));
            handleFieldAccessFlag(fieldInfo, fieldAccessFlag);
            offset += 2;
            short nameIndex = ByteUtil.byteToShort(ByteUtil.getSubBytes(bytes, offset, 2));
            fieldInfo.setNameIndex(nameIndex);
            offset += 2;
            short descriptorIndex = ByteUtil.byteToShort(ByteUtil.getSubBytes(bytes, offset, 2));
            fieldInfo.setDescriptorIndex(descriptorIndex);
            short attributeCount = ByteUtil.byteToShort(ByteUtil.getSubBytes(bytes, offset, 2));
            fieldInfo.setAttributeCount(attributeCount);
            int fieldAttributeOffset = handleFieldAttribute(fieldInfo, bytes, offset);
            offset += fieldAttributeOffset;
            fieldInfoList.add(fieldInfo);
        }
        classInfo.setFiledList(fieldInfoList);
        return offset - offsetOrigin;
    }

    private int handleFieldAttribute(FieldInfo fieldInfo, byte[] bytes, int offset) {
        int attributeCount = fieldInfo.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            // todo
        }
        return 0;
    }

    private void handleFieldAccessFlag(FieldInfo fieldInfo, short filedAccessFlag) {
        Preconditions.checkNotNull(fieldInfo);
        int _3P = filedAccessFlag & 0x07;
        int isStatic = filedAccessFlag & 0x08;
        int isFinalOrVolatile = filedAccessFlag & 0x50;
        int isTransient = filedAccessFlag & 0x80;
        int isSynthetic = filedAccessFlag & 0x1000;
        int isEnum = filedAccessFlag & 0x4000;
        List<String> accessFlag = Lists.newArrayList();
        if (0x01 == _3P) {
            accessFlag.add("ACC_PUBLIC");
        } else if (0x02 == _3P) {
            accessFlag.add("ACC_PRIVATE");
        } else if (0x04 == _3P) {
            accessFlag.add("ACC_PROTECTED");
        } else {

        }
        if (0x08 == isStatic) {
            accessFlag.add("ACC_STATIC");
        }
        if (0x10 == isFinalOrVolatile) {
            accessFlag.add("ACC_FINAL");
        } else if (0x40 == isFinalOrVolatile) {
            accessFlag.add("ACC_VOLATILE");
        }
        if (0x80 == isTransient) {
            accessFlag.add("ACC_TRANSIENT");
        }
        if (0x1000 == isSynthetic) {
            accessFlag.add("ACC_SYNTHETIC");
        }
        if (0x4000 == isEnum) {
            accessFlag.add("ACC_ENUM");
        }
        fieldInfo.setAccessFlagList(accessFlag);
    }

    private void handleInterface(ClassInfo classInfo, byte[] bytes, int offset) {
        int interfaceCount = classInfo.getInterfaceCount();
        short tmp;
        List<Short> interfaceList = Lists.newArrayList();
        for (int i = 0; i < interfaceCount; i++) {
            tmp = ByteUtil.byteToShort(ByteUtil.getSubBytes(bytes, offset, 2));
            interfaceList.add(tmp);
        }
        classInfo.setInterfaceList(interfaceList);
    }

    private void handleAccessFlag(ClassInfo classInfo, byte[] bytes, int offset) {
        byte[] accessFlags = ByteUtil.getSubBytes(bytes, offset, 2);
        byte firstHigh = ByteUtil.getHighFourBit(accessFlags[0]);
        byte firstLow = ByteUtil.getLowFourBit(accessFlags[0]);
        byte secondHigh = ByteUtil.getHighFourBit(accessFlags[1]);
        byte secondLow = ByteUtil.getLowFourBit(accessFlags[1]);
        List<String> accessFlagList = Lists.newArrayList();
        // 第一个字节的高四位
        if (4 == firstHigh) {
            accessFlagList.add("ACC_ENUM");
        } else if (2 == firstHigh) {
            accessFlagList.add("ACC_ANNOTATION");
        } else if (1 == firstHigh) {
            accessFlagList.add("ACC_SYNTHETIC");
        }
        // 第一个字节的低四位
        if (4 == firstLow) {
            accessFlagList.add("ACC_ABSTRACT");
        } else if (2 == firstLow) {
            accessFlagList.add("ACC_INTERFACE");
        }
        // 第二个字节的高四位
        if (2 == secondHigh) {
            accessFlagList.add("ACC_SUPER");
        } else if (1 == secondHigh) {
            accessFlagList.add("ACC_FINAL");
        }
        // 第二个字节的低四位
        if (1 == secondLow) {
            accessFlagList.add("ACC_PUBLIC");
        }
        classInfo.setAccessFlagList(accessFlagList);
    }

    private int handleConstant(ClassInfo classInfo, byte[] bytes, int offset) throws ClassNotFoundException,
            IllegalAccessException, InstantiationException {
        int constantCount = classInfo.getConstantCount();
        Integer tag;
        int offsetOrigin = offset;
        List<AbstractConstantInfo> constantInfoList = Lists.newArrayList();
        for (int i = 0; i < constantCount - 1; i++) {
            tag = (int) ByteUtil.getSubBytes(bytes, offset, 1)[0];
            offset += 1;
            String constantType = constantTagMap.get(tag);
            AbstractConstantInfo constantInfo = (AbstractConstantInfo) Class.forName(constantType).newInstance();
            constantInfo = constantInfo.handle(bytes, offset);
            constantInfoList.add(constantInfo);
            offset += constantInfo.getInfoLength();
        }
        classInfo.setAbstractConstantInfoList(constantInfoList);
        return offset - offsetOrigin;
    }

    private boolean isClassFile(String magicNum) {
        return "CAFEBABE".equals(magicNum);
    }
}
