package io.zerocopy;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

public class MMapTest {
    private static final String FILE_NAME = "send_file";
    private static final long FILE_SIZE = 1024; // 文件大小为1KB，仅为示例

    public static void main(String[] args) {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(FILE_NAME, "rw"); FileChannel fileChannel = randomAccessFile.getChannel()) {
            // 将文件映射到内存中
            MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, FILE_SIZE);
            // 准备要写入的字符串
            String message = "Hello, World!";
            // 将字符串转换为字节数组
            byte[] messageBytes = message.getBytes(StandardCharsets.UTF_8);
            // 清空buffer（如果之前有数据）
            mappedByteBuffer.clear();
            // 写入数据到内存映射的缓冲区
            mappedByteBuffer.put(messageBytes);
            // 刷新缓冲区，确保数据被写入
            mappedByteBuffer.flip();
            // 读取数据
            byte[] bytesRead = new byte[mappedByteBuffer.limit()];
            mappedByteBuffer.get(bytesRead);
            System.out.println(new String(bytesRead, StandardCharsets.UTF_8)); // 输出：Hello, World!
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
