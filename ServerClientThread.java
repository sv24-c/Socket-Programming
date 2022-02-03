package Multithreaded_Client_Server_in_Java;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by smit on 3/2/22.
 */
public class ServerClientThread extends Thread {

    ConcurrentHashMap<String, Integer> concurrentHashMap =new  ConcurrentHashMap<>();

    Socket serverClient;
    int clientNo;
    int squre;
    ServerClientThread(Socket inSocket,int counter){
        serverClient = inSocket;
        clientNo=counter;
    }

    public void run(){
        try{



            DataInputStream inStream = new DataInputStream(serverClient.getInputStream());
            DataOutputStream outStream = new DataOutputStream(serverClient.getOutputStream());
            String clientMessage="", serverMessage="";
            while(!clientMessage.equals("bye")){
                clientMessage=inStream.readUTF();
                System.out.println("From Client-" +clientNo+ ": Message is :"+clientMessage);
                //squre = Integer.parseInt(clientMessage) * Integer.parseInt(clientMessage);
                //serverMessage="From Server to Client-" + clientNo + " Square of " + clientMessage + " is " +squre;
                Scanner scanner = new Scanner(System.in);
                String str = scanner.nextLine();
                serverMessage="From Server to Client-" + clientNo + " Message is: " + str;
                outStream.writeUTF(serverMessage);
                outStream.flush();
            }
            inStream.close();
            outStream.close();
            serverClient.close();
        }catch(Exception ex){
            System.out.println(ex);
        }finally{
            System.out.println("Client -" + clientNo + " exit!! ");
        }
    }
}
