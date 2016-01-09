package deepInJvm.byteDecode.constant;//package com.qunar.flight.java.deepInJvm.byteDecode.constant;
//
//
//import JsonUtil;
//
//import java.io.IOException;
//
///**
// * Created by lcj on 15-6-13.
// */
//public abstract class AbstractConstantInfo {
//
//    private int infoLength;
//
//    public int getInfoLength() {
//        return infoLength;
//    }
//
//    public void setInfoLength(int infoLength) {
//        this.infoLength = infoLength;
//    }
//
//    public abstract AbstractConstantInfo handle(byte[] bytes, int offset);
//
//    @Override
//    public String toString() {
//        String result = "";
//        try {
//            result = JsonUtil.writeObjectToJson(this);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return result;
//    }
//}
