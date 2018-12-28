package com.sunny.myframedemo;

import java.net.Socket;

/**
 * Created by Sunny on 18-11-29.
 */

public class ServerThread extends Thread {

    private Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public String toString() {
        return "ServerThread{" +
                "socket=" + socket +
                '}';
    }

}
