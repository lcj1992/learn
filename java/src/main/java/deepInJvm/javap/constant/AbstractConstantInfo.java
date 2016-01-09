package deepInJvm.javap.constant;

import learn.java.util.JsonUtil;

/**
 * Created by lcj on 15-6-13.
 */
public abstract class AbstractConstantInfo {

    private int infoLength;

    public int getInfoLength() {
        return infoLength;
    }

    public void setInfoLength(int infoLength) {
        this.infoLength = infoLength;
    }

    public abstract AbstractConstantInfo handle(byte[] bytes, int offset);

    @Override
    public String toString() {
        String result = "";
        result = JsonUtil.writeObjectToJson(this);
        return result;
    }
}
