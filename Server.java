package One_to_Many;

import Multiple_Clients_Chat.ClientHandler;
import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by smit on 1/2/22.
 */
public class Server {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(5000);
        Socket socket = null;

        while (true)
        {
            try {
                socket = serverSocket.accept();

                System.out.println("A new Client is connected: "+socket);

                DataInputStream inputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

                System.out.println("Assiging new thread for client");

                Thread thread = new ClientHandler_(socket, inputStream, outputStream);
                thread.start();
            }
            catch (IOException e)
            {
                socket.close();
                System.out.println(e);
            }

        }

    }
}
