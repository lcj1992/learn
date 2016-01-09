package deepInJvm.javap.constant;

import learn.java.util.ByteUtil;

/**
 * Created by lcj on 15-6-11.
 */
public class ConstantIntegerInfo extends AbstractConstantInfo {
    // 3;

    private int bytes;

    public int getBytes() {
        return bytes;
    }

    public void setBytes(int bytes) {
        this.bytes = bytes;
    }

    @Override
    public ConstantIntegerInfo handle(byte[] bytes, int offset) {
        this.setBytes(ByteUtil.byteToInt(ByteUtil.getSubBytes(bytes, offset, 4)));
        this.setInfoLength(4);
        return this;

    }
}
