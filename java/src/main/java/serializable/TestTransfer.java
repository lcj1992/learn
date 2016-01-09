package serializable;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * serialization 允许你将实现了Serializable接口的对象转换为字节序列，这些字节序列可以被完全存储以备以后重新生成原来的对象。 serialization不但可以在本机做，而且可以经由网络操作(RMI).
 * 这个好处是很大的----因为它自动屏蔽了操作系统的差异，字节顺序等。比如，在Window平台生成一个对象并序列化之，然后通过网络传到一台Unix机器上，然后可以在这台Unix机器上正确地重构这个对象。 Object
 * serialization主要用来支持2种主要的特性： 1.Java的RMI(remote method
 * invocation).RMI允许象在本机上一样操作远程机器上的对象。当发送消息给远程对象时，就需要用到serializaiton机制来发送参数和接收返回直。
 * 2.Java的JavaBeans.Bean的状态信息通常是在设计时配置的。Bean的状态信息必须被存起来，以便当程序运行时能恢复这些状态信息。这也需要serializaiton机制。
 * 总之如果在网络的环境下做类传输，应该还是implements Serializable。
 */

// 定义序列化(object)
class Student implements Serializable {

    private static final long serialVersionUID = 980204602374616315L;
    private int sno;
    private String sname;

    public Student(int sno, String sname) {
        this.sno = sno;
        this.sname = sname;
    }

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    @Override
    public String toString() {
        return "学号:" + sno + ";姓名:" + sname;
    }

}

// (object)的反序列化过程
class MyClient extends Thread {
    @Override
    public void run() {
        try {
            Socket s = new Socket("localhost", 9999);
            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
            Student stu = (Student) ois.readObject();
            System.out.println("客户端程序收到服务器端程序传输过来的学生对象>> " + stu);
            ois.close();
            s.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

// (object)的序列化过程
class MyServer extends Thread {

    @Override
    public void run() {
        try {
            ServerSocket ss = new ServerSocket(9999);
            Socket s = ss.accept();
            ObjectOutputStream ops = new ObjectOutputStream(s.getOutputStream());
            Student stu = new Student(1, "赵本山");
            ops.writeObject(stu);
            ops.close();
            s.close();
            ss.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}

// 测试
public class TestTransfer {
    public static void main(String[] args) {
        new MyServer().start();
        new MyClient().start();
    }
}