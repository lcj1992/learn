package deepInJvm.javap.constant;

import learn.java.util.ByteUtil;

/**
 * Created by lcj on 15-6-11.
 */
public class ConstantMethodHandleInfo extends AbstractConstantInfo {
    // 15;

    private byte referenceKind;

    private short referenceIndex;

    public byte getReferenceKind() {
        return referenceKind;
    }

    public void setReferenceKind(byte referenceKind) {
        this.referenceKind = referenceKind;
    }

    public short getReferenceIndex() {
        return referenceIndex;
    }

    public void setReferenceIndex(short referenceIndex) {
        this.referenceIndex = referenceIndex;
    }

    @Override
    public ConstantMethodHandleInfo handle(byte[] bytes, int offset) {
        this.setReferenceKind(ByteUtil.getSubBytes(bytes, offset, 1)[0]);
        this.setReferenceIndex(ByteUtil.byteToShort(ByteUtil.getSubBytes(bytes, offset + 1, 2)));
        this.setInfoLength(3);
        return this;
    }
}
