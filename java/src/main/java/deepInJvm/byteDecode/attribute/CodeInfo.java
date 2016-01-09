package deepInJvm.byteDecode.attribute;

import java.util.List;

/**
 * Created by lcj on 15-6-14.
 */
public class CodeInfo {
    private short attributeNameIndex;

    private int attrbuteLength;

    private short maxStack;

    private short maxLocal;

    private int codeLength;

    private List<Byte> codeList;

    private short exceptionTableLength;

    private List<ExceptionInfo> exceptionInfoList;

    private short attributeCount;

    private List<AttributeInfo> attributeInfoList;
}
