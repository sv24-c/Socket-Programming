package One_to_Many;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by smit on 1/2/22.
 */
public class Client {

    public static void main(String[] args) {

        try {

            Scanner sc = new Scanner(System.in);

            InetAddress ip = InetAddress.getByName("localhost");
            Socket socket = new Socket(ip , 5000);

            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

            while (true)
            {
                System.out.println(inputStream.readUTF());
                String tosend = sc.nextLine();
                outputStream.writeUTF(tosend);

                if (tosend.equals("Exit"))
                {
                    System.out.println("Closing this connection "+ socket);
                    socket.close();
                    System.out.println("Connection Closed");
                    break;
                }
                String received = inputStream.readUTF();
                System.out.println(received);
            }

            sc.close();
            inputStream.close();
            outputStream.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
