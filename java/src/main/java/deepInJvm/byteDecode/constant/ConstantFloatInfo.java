package deepInJvm.byteDecode.constant;


import learn.java.deepInJvm.javap.constant.AbstractConstantInfo;
import learn.java.util.ByteUtil;

/**
 * Created by lcj on 15-6-11.
 */
public class ConstantFloatInfo extends AbstractConstantInfo {
    //4;

    private float bytes;

    public float getBytes() {
        return bytes;
    }

    public void setBytes(float bytes) {
        this.bytes = bytes;
    }

    @Override
    public ConstantFloatInfo handle(byte[] bytes,int offset) {
        this.setBytes(ByteUtil.byteToFloat(ByteUtil.getSubBytes(bytes, offset, 4)));
        this.setInfoLength(4);
        return this;
    }
}
