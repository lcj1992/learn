package deepInJvm.byteDecode.constant;


import learn.java.deepInJvm.javap.constant.AbstractConstantInfo;
import learn.java.util.ByteUtil;

/**
 * Created by lcj on 15-6-11.
 */
public class ConstantLongInfo extends AbstractConstantInfo {
    // 5;

    private long bytes;

    public long getBytes() {
        return bytes;
    }

    public void setBytes(long bytes) {
        this.bytes = bytes;
    }

    @Override
    public ConstantLongInfo handle(byte[] bytes, int offset) {
        this.setBytes(ByteUtil.byteToLong(ByteUtil.getSubBytes(bytes, offset, 8)));
        this.setInfoLength(8);
        return this;

    }
}
