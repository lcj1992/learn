package deepInJvm.javap.constant;

import learn.java.util.ByteUtil;

/**
 * Created by lcj on 15-6-11.
 */
public class ConstantMethodrefInfo extends AbstractConstantInfo {
    // 10;

    private int classIndex;

    private int nameAndTypeIndex;

    public int getClassIndex() {
        return classIndex;
    }

    public void setClassIndex(int classIndex) {
        this.classIndex = classIndex;
    }

    public int getNameAndTypeIndex() {
        return nameAndTypeIndex;
    }

    public void setNameAndTypeIndex(int nameAndTypeIndex) {
        this.nameAndTypeIndex = nameAndTypeIndex;
    }

    @Override
    public ConstantMethodrefInfo handle(byte[] bytes, int offset) {
        this.setClassIndex(ByteUtil.byteToShort(ByteUtil.getSubBytes(bytes, offset, 2)));
        this.setNameAndTypeIndex(ByteUtil.byteToShort(ByteUtil.getSubBytes(bytes, offset + 2, 2)));
        this.setInfoLength(4);
        return this;
    }
}
