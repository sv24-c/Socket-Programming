package DatagramSimple;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Created by smit on 3/2/22.
 */
public class DReceiver {

    public static void main(String[] args) throws SocketException {

        DatagramSocket ds = new DatagramSocket(3000);

        byte[] buf = new byte[1024];

        DatagramPacket dp = new DatagramPacket(buf, 1024);
        try {
            ds.receive(dp);
            String str = new String(dp.getData(), 0, dp.getLength());
            System.out.println(str);
            ds.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
