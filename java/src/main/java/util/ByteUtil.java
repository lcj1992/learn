package util;

import com.google.common.base.Preconditions;

import java.io.UnsupportedEncodingException;

/**
 * Created by lcj on 15-6-12.
 *
 */
public class ByteUtil {

    public static short byteToShort(byte[] bytes) {
        Preconditions.checkArgument(2 == bytes.length, "bytes数组长度必须为2");
        return (short) ((bytes[0] << 8) + (bytes[1]));
    }

    public static int byteToInt(byte[] bytes) {
        Preconditions.checkArgument(4 == bytes.length, "bytes数组长度必须为4");
        return (bytes[0] << 24) + (bytes[1] << 16) + (bytes[2] << 8) + (int) (bytes[3]);
    }

    public static long byteToLong(byte[] bytes) {
        Preconditions.checkArgument(8 == bytes.length, "bytes数组长度必须为8");
        return (((bytes[0] << 24) + (bytes[1] << 16) + (bytes[2] << 8) + (bytes[3])) * 4294967296L) + (bytes[4] << 24)
                + (bytes[5] << 16) + (bytes[6] << 8) + (bytes[7]);
    }

    public static float byteToFloat(byte[] bytes) {
        Preconditions.checkArgument(4 == bytes.length, "bytes数组长度必须为4");
        int sign = (0 == (bytes[0] >> 7) ? 1 : -1);
        int exponent = (bytes[0] << 1) + (bytes[1] >> 7) - 127;
        float fraction = (1 << 23) + (float) ((bytes[1] << 16) & 0x007fffff + (bytes[2] << 8) + (bytes[3]));
        return (float) (sign * fraction * Math.pow(2, exponent - 23));
    }

    public static double byteToDouble(byte[] bytes) {
        Preconditions.checkArgument(8 == bytes.length, "bytes数组长度必须为8");
        int sign = (0 == (bytes[0] >> 7) ? 1 : -1);
        int exponent = (bytes[0] & 0x7f) * 16 + ((bytes[1] >> 4) & 0x0f) - 1023;
        double fraction = 1
                + ((((bytes[1] << 16) & 0x000f0000) + (bytes[2] << 8) + (bytes[3])) * 4294967296L + (bytes[4] << 24)
                        + (bytes[5] << 16) + (bytes[6] << 8) + bytes[7]) * Math.pow(2, -52);
        return sign * fraction * Math.pow(2, exponent);
    }

    public static String byteToString(byte[] bytes) throws UnsupportedEncodingException {
        return new String(bytes, "utf-8");
    }

    public static byte[] getSubBytes(byte[] bytes, int offset, int count) {
        byte[] subBytes = new byte[count];
        System.arraycopy(bytes, offset, subBytes, 0, count);
        return subBytes;
    }

    public static byte getHighFourBit(byte b) {
        return (byte) ((b >> 4) & 0x0f);
    }

    public static byte getLowFourBit(byte b) {
        return (byte) (b & 0x0f);
    }

    public static String byteToHexString(byte[] bytes) {
        String ret = "";
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(bytes[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            ret += hex.toUpperCase();
        }
        return ret;
    }

    public static void printHex(byte[] allBytes) {
        String hexString = ByteUtil.byteToHexString(allBytes);
        for (int i = 0; i < hexString.length(); i++) {
            if (i % 32 == 0) {
                System.out.println("");
            }
            String isSpace = i % 2 == 1 ? " " : "";
            System.out.printf(String.valueOf(hexString.charAt(i)) + isSpace);
        }
        System.out.println("");
        System.out.println("");
    }

    public static void testInt() {
        byte[] bytes = new byte[4];
        bytes[0] = 65;
        bytes[1] = 54;
        bytes[2] = 0;
        bytes[3] = 0;
        System.out.println(byteToInt(bytes));
    }

    public static void testLong() {
        byte[] bytes = new byte[8];
        bytes[0] = 63;
        bytes[1] = -43;
        bytes[2] = 85;
        bytes[3] = 85;
        bytes[4] = 85;
        bytes[5] = 85;
        bytes[6] = 85;
        bytes[7] = 85;
        System.out.println(byteToLong(bytes));
    }

    public static void testFloat() {
        byte[] bytes = new byte[4];
        bytes[0] = 65;
        bytes[1] = 54;
        bytes[2] = 0;
        bytes[3] = 0;
        System.out.println(byteToFloat(bytes));
        assert byteToFloat(bytes) == 11.375;
    }

    public static void testDoluble() {
        byte[] bytes = new byte[8];
        bytes[0] = 63;
        bytes[1] = -43;
        bytes[2] = 85;
        bytes[3] = 85;
        bytes[4] = 85;
        bytes[5] = 85;
        bytes[6] = 85;
        bytes[7] = 85;
        System.out.println(byteToDouble(bytes));
    }

    public static void main(String[] args) {
        testInt();
        testLong();
        testFloat();
        testDoluble();
    }
}