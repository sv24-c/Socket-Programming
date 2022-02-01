package OnetoOne_read_write_both;

import java.io.*;
import java.net.Socket;

/**
 * Created by smit on 31/1/22.
 */
public class Client1 {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost",3333);

        DataInputStream datainput = new DataInputStream(socket.getInputStream());
        DataOutputStream dataout = new DataOutputStream(socket.getOutputStream());
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String str="",str1="";

        while (!str.equals("stop"))
        {
            str=reader.readLine();
            dataout.writeUTF(str);
            dataout.flush();

            str1 = datainput.readUTF();
            System.out.println("Server says: "+str1);
        }

        dataout.close();
        socket.close();
    }
}
