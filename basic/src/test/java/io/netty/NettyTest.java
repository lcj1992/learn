package io.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NettyTest {

    public static final int INET_PORT = 8082;
    public static final ExecutorService EXECUTOR = Executors.newSingleThreadExecutor();

    @Test
    public void test() throws Exception {

        EXECUTOR.submit(() -> {
            EchoServer echoServer = new EchoServer();
            try {
                echoServer.init();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        EchoClient client = new EchoClient();
        client.init();

    }


    public static class EchoClient {

        public void init() throws Exception {
            EventLoopGroup group = new NioEventLoopGroup();
            try {
                Bootstrap b = new Bootstrap();
                b.group(group)
                        .channel(NioSocketChannel.class)
                        .handler(new ChannelInitializer<SocketChannel>() {
                            @Override
                            public void initChannel(SocketChannel ch) throws Exception {
                                ch.pipeline().addLast(new StringDecoder());
                                ch.pipeline().addLast(new StringEncoder());
                                ch.pipeline().addLast(new EchoClientHandler());
                            }
                        });

                ChannelFuture f = b.connect("localhost", INET_PORT).sync(); // 连接到服务器
                f.channel().writeAndFlush("Hello, Netty!"); // 发送消息
                f.channel().closeFuture().sync(); // 等待通道关闭
            } finally {
                group.shutdownGracefully();
            }
        }

        public static class EchoClientHandler extends ChannelInboundHandlerAdapter {

            @Override
            public void channelRead(ChannelHandlerContext ctx, Object msg) { // 当有数据可读时调用
                System.out.println("Server receive: " + msg); // 打印服务器的回应
            }

            @Override
            public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) { // 捕获异常时调用
                cause.printStackTrace();
                ctx.close(); // 关闭通道
            }
        }
    }

    public static class EchoServer {

        public void init() throws Exception {
            EventLoopGroup bossGroup = new NioEventLoopGroup(); // 主线程组，用于接受新的连接
            EventLoopGroup workerGroup = new NioEventLoopGroup(); // 工作线程组，用于处理网络I/O

            try {
                ServerBootstrap b = new ServerBootstrap();
                b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class).childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    public void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new StringDecoder()); // 添加字符串解码器
                        ch.pipeline().addLast(new StringEncoder()); // 添加字符串编码器
                        ch.pipeline().addLast(new EchoServerHandler()); // 添加自定义的处理器
                    }
                });

                ChannelFuture f = b.bind(INET_PORT).sync(); // 绑定服务器并开始监听
                f.channel().closeFuture().sync(); // 等待服务器关闭
            } finally {
                bossGroup.shutdownGracefully();
                workerGroup.shutdownGracefully();
            }
        }

        public static class EchoServerHandler extends ChannelInboundHandlerAdapter {

            @Override
            public void channelRead(ChannelHandlerContext ctx, Object msg) { // 当有数据可读时调用
                ctx.write(msg); // 将接收到的消息写回客户端
            }

            @Override
            public void channelReadComplete(ChannelHandlerContext ctx) { // 当数据读取完成后调用
                ctx.flush(); // 刷新消息，确保数据被发送出去
            }

            @Override
            public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) { // 捕获异常时调用
                cause.printStackTrace();
                ctx.close(); // 关闭通道
            }
        }
    }
}
