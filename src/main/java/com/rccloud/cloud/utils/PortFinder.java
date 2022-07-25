package com.rccloud.cloud.utils;

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

}
