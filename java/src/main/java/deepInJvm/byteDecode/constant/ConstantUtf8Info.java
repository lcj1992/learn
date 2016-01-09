package deepInJvm.byteDecode.constant;//package com.qunar.flight.java.deepInJvm.byteDecode.constant;
//
//
//import ByteUtil;
//
//import java.io.UnsupportedEncodingException;
//
///**
// * Created by lcj on 15-6-11.
// */
//public class ConstantUtf8Info extends AbstractConstantInfo {
//    // 1;
//    private int length;
//    // 占用length个字节
//    private String bytes;
//
//    public int getLength() {
//        return length;
//    }
//
//    public void setLength(int length) {
//        this.length = length;
//    }
//
//    public String getBytes() {
//        return bytes;
//    }
//
//    public void setBytes(String bytes) {
//        this.bytes = bytes;
//    }
//
//    @Override
//    public ConstantUtf8Info handle(byte[] bytes, int offset) {
//        int utf8Length = ByteUtil.byteToShort(ByteUtil.getSubBytes(bytes, offset, 2));
//        offset += 2;
//        try {
//            this.setBytes(ByteUtil.byteToString(ByteUtil.getSubBytes(bytes, offset, utf8Length)));
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        this.setInfoLength(2 + utf8Length);
//        return this;
//    }
//
//}
