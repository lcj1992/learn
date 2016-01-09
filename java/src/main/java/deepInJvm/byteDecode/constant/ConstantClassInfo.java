package deepInJvm.byteDecode.constant;


import learn.java.deepInJvm.javap.constant.AbstractConstantInfo;
import learn.java.util.ByteUtil;

/**
 * Created by lcj on 15-6-11.
 */
public class ConstantClassInfo extends AbstractConstantInfo {
    // 7;

    private short index;

    public short getIndex() {
        return index;
    }

    public void setIndex(short index) {
        this.index = index;
    }

    @Override
    public ConstantClassInfo handle(byte[] bytes, int offset) {
        this.setIndex(ByteUtil.byteToShort(ByteUtil.getSubBytes(bytes, offset, 2)));
        this.setInfoLength(2);
        return this;
    }
}
