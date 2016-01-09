package deepInJvm.javap;

import learn.java.deepInJvm.javap.constant.AbstractConstantInfo;

import java.util.List;

/**
 * Created by lcj on 15-6-12.
 *
 */
public class ClassInfo {
    private String magicNum;

    private short minorVer;

    private short majorVer;

    private short constantCount;

    private List<AbstractConstantInfo> abstractConstantInfoList;

    private List<String> accessFlagList;

    private short thisClass;

    private short superClass;

    private short interfaceCount;

    private List<Short> interfaceList;

    private short filedCount;

    private List<FieldInfo> filedList;

    private short methodCount;

    private List<MethodInfo> methodList;

    private short attributeCount;

    private List<AttributeInfo> attributeList;

    public String getMagicNum() {
        return magicNum;
    }

    public void setMagicNum(String magicNum) {
        this.magicNum = magicNum;
    }

    public short getMinorVer() {
        return minorVer;
    }

    public void setMinorVer(short minorVer) {
        this.minorVer = minorVer;
    }

    public short getMajorVer() {
        return majorVer;
    }

    public void setMajorVer(short majorVer) {
        this.majorVer = majorVer;
    }

    public short getConstantCount() {
        return constantCount;
    }

    public void setConstantCount(short constantCount) {
        this.constantCount = constantCount;
    }

    public List<AbstractConstantInfo> getAbstractConstantInfoList() {
        return abstractConstantInfoList;
    }

    public void setAbstractConstantInfoList(List<AbstractConstantInfo> abstractConstantInfoList) {
        this.abstractConstantInfoList = abstractConstantInfoList;
    }

    public List<String> getAccessFlagList() {
        return accessFlagList;
    }

    public void setAccessFlagList(List<String> accessFlagList) {
        this.accessFlagList = accessFlagList;
    }

    public short getThisClass() {
        return thisClass;
    }

    public void setThisClass(short thisClass) {
        this.thisClass = thisClass;
    }

    public short getSuperClass() {
        return superClass;
    }

    public void setSuperClass(short superClass) {
        this.superClass = superClass;
    }

    public short getInterfaceCount() {
        return interfaceCount;
    }

    public void setInterfaceCount(short interfaceCount) {
        this.interfaceCount = interfaceCount;
    }

    public List<Short> getInterfaceList() {
        return interfaceList;
    }

    public void setInterfaceList(List<Short> interfaceList) {
        this.interfaceList = interfaceList;
    }

    public short getFiledCount() {
        return filedCount;
    }

    public void setFiledCount(short filedCount) {
        this.filedCount = filedCount;
    }

    public List<FieldInfo> getFiledList() {
        return filedList;
    }

    public void setFiledList(List<FieldInfo> filedList) {
        this.filedList = filedList;
    }

    public short getMethodCount() {
        return methodCount;
    }

    public void setMethodCount(short methodCount) {
        this.methodCount = methodCount;
    }

    public List<MethodInfo> getMethodList() {
        return methodList;
    }

    public void setMethodList(List<MethodInfo> methodList) {
        this.methodList = methodList;
    }

    public short getAttributeCount() {
        return attributeCount;
    }

    public void setAttributeCount(short attributeCount) {
        this.attributeCount = attributeCount;
    }

    public List<AttributeInfo> getAttributeList() {
        return attributeList;
    }

    public void setAttributeList(List<AttributeInfo> attributeList) {
        this.attributeList = attributeList;
    }
}
