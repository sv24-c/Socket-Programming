package DatagramSimple;

import java.io.IOException;
import java.net.*;

/**
 * Created by smit on 3/2/22.
 */
public class DSender {

    public static void main(String[] args) throws SocketException {
        DatagramSocket ds = new DatagramSocket();
        String str = "Welcome to Java socket";

        try {
            InetAddress ip = InetAddress.getByName("127.0.0.1");

            DatagramPacket dp = new DatagramPacket(str.getBytes(), str.length(), ip, 3000);
            ds.send(dp);
            ds.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
