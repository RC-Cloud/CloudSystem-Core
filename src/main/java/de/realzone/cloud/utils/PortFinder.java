package de.realzone.cloud.utils;

import de.realzone.cloud.service.ServiceType;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class PortFinder {

    private static boolean available(int port){
        try(Socket socket = new Socket("localhost", port)) {
            return false;
        }catch (IOException e){
            return true;
        }
    }

    public static Integer getFreePort(ServiceType type){
        if(available(25565) && type.equals(ServiceType.PROXY)){
            return 25565;
        }
        try {
            ServerSocket socket = new ServerSocket(0);
            int port = socket.getLocalPort();
            socket.close();
            return port;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
