import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 实现TCP的网络编程
 * 例题2：客户端
 *
 * @author Yi-27
 * @create 2020-10-05 21:47
 */
public class TCPTest2 {

    @Test
    public void client() throws IOException {
        // 创建套接字
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 12345);
        // 套接字中的输出流
        OutputStream os = socket.getOutputStream();

        // 读取本地文件的 缓冲流（文件流（文件））
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("gakki.png"));

        // 读写操作
        byte[] buffer = new byte[1024];
        int len;
        while((len = bis.read(buffer)) != -1){
            os.write(buffer, 0, len);
        }

        bis.close();
        os.close();
        socket.close();

    }


    @Test
    public void server(){



    }


}
