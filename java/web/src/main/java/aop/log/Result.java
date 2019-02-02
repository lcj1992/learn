package aop.log;

import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.SimpleFormatter;

/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 2017/6/22
 * Time: 上午11:27
 */
public class Result {
    private String name = "fuck you";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void TestUnicodeDigits() {
//        char[] zeros = {
//                0x0030, // ISO-LATIN-1 digits ('0' through '9')
//                0x0660, // Arabic-Indic digits
//                0x06F0, // Extended Arabic-Indic digits
//                0x0966, // Devanagari digits
//                0x09E6, // Bengali digits
//                0x0A66, // Gurmukhi digits
//                0x0AE6, // Gujarati digits
//                0x0B66, // Oriya digits
//                0x0BE6, // Tamil digits
//                0x0C66, // Telugu digits
//                0x0CE6, // Kannada digits
//                0x0D66, // Malayalam digits
//                0x0E50, // Thai digits
//                0x0ED0, // Lao digits
//                0x0F20, // Tibetan digits
//                0xFF10, // Fullwidth digits
//        };
        String date = "༢༠༡༧-༠༨-༢༥";
        char zerooo = '༠';
        System.out.println(zerooo);
        byte[] zeros = date.getBytes();
        Arrays.asList(zeros).forEach(each -> System.out.println(each));
        NumberFormat format = NumberFormat.getInstance();
        for (int i=0; i<zeros.length; ++i) {
            byte zero = zeros[i];
            System.out.println(zero);
            StringBuffer buf = new StringBuffer();
            buf.append((char)(zero+3));
            buf.append((char)(zero+1));
            buf.append((char)(zero+4));
            int n = -1;
            try {
                System.out.println(buf);
                n = format.parse(buf.toString()).intValue();
            }
            catch (ParseException e) { n = -2; }
            if (n != 314)
                System.out.println("Can't parse Unicode " + Integer.toHexString(zero) + " as digit (" + n + ")");
            else
                System.out.println("Parse digit " + Integer.toHexString(zero) + " ok");
        }
    }

    public static void main(String[] args) throws ParseException {
        char zerooo = '༠';
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = simpleDateFormat.parse("༢༠༡༧-༠༨-༢༥");

        System.out.println(date);
//        "༢༠༡༧-༠༨-༢༥";
    }
}
