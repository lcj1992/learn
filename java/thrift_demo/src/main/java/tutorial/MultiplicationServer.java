package tutorial;

import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TServer.Args;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;

public class MultiplicationServer {

    public static MultiplicationServiceImpl service;

    public static MultiplicationService.Processor processor;

    public static void main(String [] args) {
        try {
            service = new MultiplicationServiceImpl();
            processor = new MultiplicationService.Processor(service);
            TServerTransport serverTransport = new TServerSocket(9090);
            TServer server = new TSimpleServer(new Args(serverTransport).processor(processor));
            server.serve();
            System.out.println("start");
        } catch (Exception x) {
            x.printStackTrace();
        }
    }

}