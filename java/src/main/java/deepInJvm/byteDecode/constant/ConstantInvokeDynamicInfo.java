package deepInJvm.byteDecode.constant;


import learn.java.deepInJvm.javap.constant.AbstractConstantInfo;
import learn.java.util.ByteUtil;

/**
 * Created by lcj on 15-6-11.
 */
public class ConstantInvokeDynamicInfo extends AbstractConstantInfo {
    // 18;

    private short bootstrapMethodAttrIndex;

    private short nameAndTypeIndex;

    public short getBootstrapMethodAttrIndex() {
        return bootstrapMethodAttrIndex;
    }

    public void setBootstrapMethodAttrIndex(short bootstrapMethodAttrIndex) {
        this.bootstrapMethodAttrIndex = bootstrapMethodAttrIndex;
    }

    public short getNameAndTypeIndex() {
        return nameAndTypeIndex;
    }

    public void setNameAndTypeIndex(short nameAndTypeIndex) {
        this.nameAndTypeIndex = nameAndTypeIndex;
    }

    @Override
    public ConstantInvokeDynamicInfo handle(byte[] bytes, int offset) {
        this.setBootstrapMethodAttrIndex((ByteUtil.byteToShort(ByteUtil.getSubBytes(bytes, offset, 2))));
        this.setNameAndTypeIndex(ByteUtil.byteToShort(ByteUtil.getSubBytes(bytes, offset + 2, 2)));
        this.setInfoLength(4);
        return this;
    }
}
