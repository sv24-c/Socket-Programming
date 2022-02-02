package One_to_Many;

import javafx.scene.input.DataFormat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by smit on 1/2/22.
 */
public class ClientHandler_ extends Thread{

    DateFormat fordate = new SimpleDateFormat("yyyy/MM/dd");
    DateFormat fortime = new SimpleDateFormat("hh:mm:ss");

    DataInputStream inputStream;
    DataOutputStream outputStream;
    Socket socket;

    ClientHandler_(Socket socket, DataInputStream inputStream, DataOutputStream outputStream)
    {
        this.socket = socket;
        this.inputStream = inputStream;
        this.outputStream = outputStream;
    }
    @Override
    public void run() {

        String received;
        String toreturn;

        while (true)
        {
            try {
                outputStream.writeUTF("What do you want? [Date | Time] \n"+"Type Exit to terminate connection");
                 received = inputStream.readUTF();

                 if (received.equals("Exit"))
                 {
                     System.out.println("Client "+this.socket+" sends exit..");
                     System.out.println("Closing this connection");
                     this.socket.close();
                     System.out.println("Connection Closed");
                     break;
                 }

                Date date = new Date();

                 switch (received)
                 {
                     case "Date":
                         toreturn = fordate.format(date);
                         outputStream.writeUTF(toreturn);
                         break;

                     case "Time":
                         toreturn = fortime.format(date);
                         outputStream.writeUTF(toreturn);
                         break;

                     default:
                         outputStream.writeUTF("Invalid input");
                         break;
                 }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            this.inputStream.close();
            this.outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
