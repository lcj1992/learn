package deepInJvm.javap;

import java.util.List;

/**
 * Created by lcj on 15-6-14.
 *
 */
public class MethodInfo {
    private List<String> accessFlagList;

    private short nameIndex;

    private short descriptorIndex;

    private short attributeCount;

    private List<AttributeInfo> attributeInfoList;

    public List<String> getAccessFlagList() {
        return accessFlagList;
    }

    public void setAccessFlagList(List<String> accessFlagList) {
        this.accessFlagList = accessFlagList;
    }

    public short getNameIndex() {
        return nameIndex;
    }

    public void setNameIndex(short nameIndex) {
        this.nameIndex = nameIndex;
    }

    public short getDescriptorIndex() {
        return descriptorIndex;
    }

    public void setDescriptorIndex(short descriptorIndex) {
        this.descriptorIndex = descriptorIndex;
    }

    public short getAttributeCount() {
        return attributeCount;
    }

    public void setAttributeCount(short attributeCount) {
        this.attributeCount = attributeCount;
    }

    public List<AttributeInfo> getAttributeInfoList() {
        return attributeInfoList;
    }

    public void setAttributeInfoList(List<AttributeInfo> attributeInfoList) {
        this.attributeInfoList = attributeInfoList;
    }
}
