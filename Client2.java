package Client_to_Client;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * Created by smit on 4/2/22.
 */
public class Client2 {

    public static void main(String[] args) throws SocketException, UnknownHostException {

        DatagramSocket datagramSocket = new DatagramSocket(1234);

        byte[] receive = new byte[65535];
       // byte[] send = new byte[65535];
        InetAddress ip = InetAddress.getLocalHost();

        DatagramPacket datagramPacket = null;

        Scanner sc = new Scanner(System.in);
        String str="";

        while (true)
        {
            datagramPacket = new DatagramPacket(receive, receive.length);

            try {
                datagramSocket.receive(datagramPacket);
                System.out.println("Client1 1 send: "+data(receive));

                /*while (!datagramPacket.equals(null))
                {
                    str = sc.nextLine();
                    send = str.getBytes();
                    datagramPacket = new DatagramPacket(send, send.length, ip, 5000);

                    try {
                        datagramSocket.send(datagramPacket);
                        System.out.println("Message sent to Client1 : 1 ");
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }

                    if (str.equals("stop"))
                    {
                        break;
                    }
                }
                */
            } catch (IOException e) {
                e.printStackTrace();
            }



            if (data(receive).toString().equals("stop"))
            {
                break;
            }
        }

    }

    public static StringBuilder data(byte[] arr)
    {
        if (arr == null)
        {
            return null;
        }

        StringBuilder string = new StringBuilder();

        int i=0;
        while (arr[i]!=0)
        {
            string.append((char)arr[i]);
            i++;
        }
        return string;
    }

}
