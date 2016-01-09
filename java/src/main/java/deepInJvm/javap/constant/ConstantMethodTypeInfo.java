package deepInJvm.javap.constant;

import learn.java.util.ByteUtil;

/**
 * Created by lcj on 15-6-11.
 */
public class ConstantMethodTypeInfo extends AbstractConstantInfo {
    // 16;

    private short descriptorIndex;

    public short getDescriptorIndex() {
        return descriptorIndex;
    }

    public void setDescriptorIndex(short descriptorIndex) {
        this.descriptorIndex = descriptorIndex;
    }

    @Override
    public ConstantMethodTypeInfo handle(byte[] bytes, int offset) {
        this.setDescriptorIndex(ByteUtil.byteToShort(ByteUtil.getSubBytes(bytes, offset, 2)));
        this.setInfoLength(2);
        return this;
    }
}
