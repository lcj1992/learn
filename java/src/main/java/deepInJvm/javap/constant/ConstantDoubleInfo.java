package deepInJvm.javap.constant;


import util.ByteUtil;

/**
 * Created by lcj on 15-6-11.
 */
public class ConstantDoubleInfo extends AbstractConstantInfo {
    // 6;

    private double bytes;

    public double getBytes() {
        return bytes;
    }

    public void setBytes(double bytes) {
        this.bytes = bytes;
    }

    @Override
    public ConstantDoubleInfo handle(byte[] bytes, int offset) {
        this.setBytes(ByteUtil.byteToDouble(ByteUtil.getSubBytes(bytes, offset, 8)));
        this.setInfoLength(8);
        return this;

    }
}
