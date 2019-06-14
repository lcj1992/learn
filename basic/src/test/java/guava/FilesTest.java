package guava;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.io.Files;
import com.google.common.io.LineProcessor;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 2019/6/1
 * Time: 下午4:37
 */
public class FilesTest {
    @Test
    public void test() {
        String fileName = "/Users/lichuangjian/test.txt";
        String targetFileName = "/Users/lichuangjian/testUpdate.txt";
        String targetFileName2 = "/Users/lichuangjian/testUpdate2.txt";
        File file = new File(fileName);
        File targetFile = new File(targetFileName);
        File targetFile2 = new File(targetFileName2);
        AtomicInteger lineNumber = new AtomicInteger(1);
        try {
            // 逐行读取文件, Files.readLines()
            // List<String> allLines = Files.readLines(file, Charset.defaultCharset());

            // 逐行读取文件, Files.asCharSource().readLines()
            // ImmutableList<String> allLines = Files.asCharSource(file, Charset.defaultCharset()).readLines();

            // 逐行读取文件, LineProcessor
            ImmutableList<String> allLines = Files.asCharSource(file, Charset.defaultCharset()).readLines(new LineProcessor<ImmutableList<String>>() {
                private List<String> bookTitles = Lists.newArrayList();

                @Override
                public boolean processLine(String line) throws IOException {
                    bookTitles.add(lineNumber.getAndAdd(1) + ":" + line.toLowerCase());
                    return true;
                }

                @Override
                public ImmutableList<String> getResult() {
                    return ImmutableList.copyOf(bookTitles);
                }
            });

            // 逐行写入文件, Files.asCharSink().writeLines()、Files.asByteSink()
            List<String> containHelloLines = allLines.stream().filter(each -> each.contains("hello")).collect(Collectors.toList());
            Files.asCharSink(targetFile, Charset.defaultCharset()).writeLines(containHelloLines);
            Files.asByteSink(targetFile2).write(new byte[]{'a', 'b', 'c', 'd', '\n'});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

