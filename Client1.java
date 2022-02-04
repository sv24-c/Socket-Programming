package Client_to_Client;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * Created by smit on 4/2/22.
 */
public class Client1 {

    public static void main(String[] args) throws SocketException, UnknownHostException {

        DatagramSocket datagramSocket = new DatagramSocket();
        byte[] buf = null;
       // byte[] receive = new byte[65535];

        InetAddress ip = InetAddress.getLocalHost();
        Scanner sc = new Scanner(System.in);
        String str = "";

        while (true) {
            str = sc.nextLine();
            buf = str.getBytes();

            DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length, ip, 1234);
            //DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length, ip, 1234);
            try {
                datagramSocket.send(datagramPacket);
                System.out.println("Message sent");

                /*while (true)
                {
                    DatagramPacket datagramPacket1 = new DatagramPacket(receive, receive.length);

                    try {
                        datagramSocket.receive(datagramPacket1);
                        System.out.println("Client1 2 send: "+data(receive)+" message");
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }

                    if (str.equals("stop"))
                    {
                        break;
                    }
                }*/

            } catch (IOException e) {
                e.printStackTrace();
            }

            if (str.equals("stop")) {
                break;
            }
        }


    }

}
  /*  public static StringBuilder data(byte[] arr)
    {
        if (arr == null)
        {
            return null;
        }

        StringBuilder stringBuilder = new StringBuilder();
        int i=0;
        while (arr[i] !=0)
        {
            stringBuilder.append((char)arr[i]);
            i++;
        }
        return stringBuilder;
    }
}
*/