package Multithreaded_Client_Server_in_Java;

import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Time;
import java.util.ArrayList;

/**
 * Created by smit on 3/2/22.
 */
public class MultithreadedSocketServer {

    public static void main(String[] args) throws Exception {

         //ConcurrentHashMap<Object, Object> concurrentHashMap =new  ConcurrentHashMap<>();
        //Vector<ServerClientThread> vector = new Vector<>();
        ArrayList<Socket> arrayList = new ArrayList<>();

        Time time;
        try{
            ServerSocket server=new ServerSocket(8888);
            int counter=0;
            System.out.println("Server Started ....");
            while(true){
                counter++;
                Socket serverClient=server.accept();  //server accept the client connection request
                //System.out.println(" >> " + "Client No:" + counter + " started!");

                    if (serverClient.isConnected())
                    {

                        ServerClientThread sct = new ServerClientThread(serverClient,counter); //send  the request to a separate thread

                        //queue.put(sct);
                        Thread t = new Thread(sct);
                        //vector.add(sct);
                        arrayList.add(serverClient);
                        t.start();
                        //concurrentHashMap.put(sct,counter);

                        //sct.start();

                    }



            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
