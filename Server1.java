package OnetoOne_read_write_both;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by smit on 31/1/22.
 */
public class Server1 {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(3333);

        Socket socket = serverSocket.accept();

        DataInputStream datainput = new DataInputStream(socket.getInputStream());
        DataOutputStream dataout = new DataOutputStream(socket.getOutputStream());
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String str="", str1="";

        while (!str.equals("stop"))
        {
            str = datainput.readUTF();

            System.out.println("Client says: "+str);
            str1 = reader.readLine();
            dataout.writeUTF(str1);
            dataout.flush();
        }

        datainput.close();
        socket.close();
        serverSocket.close();
    }
}
