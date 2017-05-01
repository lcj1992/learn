package com.demo;

/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 2017/1/19
 * Time: 下午6:12
 */
public class Test {

    private static class LocalSenderSingletonHolder {
        private static ISender LOCAL_SENDER = new LocalSenderImpl();
    }

    private static class RemoteSenderSingletonHolder {

        private static ISender REMOTE_SENDER = createRemoteSenderInstance();

        private static ISender createRemoteSenderInstance() {
            RemoteSenderImpl remoteSenderInstance = new RemoteSenderImpl();
            return remoteSenderInstance;
        }
    }

    public static void main(String[] args) {
        System.out.println(LocalSenderSingletonHolder.LOCAL_SENDER);
        System.out.println(RemoteSenderSingletonHolder.REMOTE_SENDER);
    }
}
