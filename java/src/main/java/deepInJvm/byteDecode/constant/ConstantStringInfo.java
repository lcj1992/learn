package deepInJvm.byteDecode.constant;

import learn.java.deepInJvm.javap.constant.AbstractConstantInfo;
import learn.java.util.ByteUtil;

/**
 * Created by lcj on 15-6-11.
 */
public class ConstantStringInfo extends AbstractConstantInfo {
    // 8;

    private int index;

    public int getIndex() {

        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public ConstantStringInfo handle(byte[] bytes, int offset) {
        this.setIndex(ByteUtil.byteToShort(ByteUtil.getSubBytes(bytes, offset, 2)));
        this.setInfoLength(2);
        return this;
    }
}
