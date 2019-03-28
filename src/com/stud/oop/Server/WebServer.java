package com.stud.oop.Server;

import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {


    public void start(int portNumber) {

        try {

            ServerSocket serverSocket = new ServerSocket(portNumber);

            while (true) {

                Socket clientSocket = serverSocket.accept();
                ServerBot bot = new ServerBot(clientSocket);
                new Thread(bot).start();
            }

        } catch (Exception e) {
            System.out.println("Cannot create server socket");
        }
    }
}
