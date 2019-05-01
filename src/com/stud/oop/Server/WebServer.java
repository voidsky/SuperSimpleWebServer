package com.stud.oop.Server;

import com.stud.oop.Logger.SingleLogger;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {

    //get the only logger object
    SingleLogger logger = SingleLogger.getInstance();
    
    public void start(int portNumber) {

        try {

            ServerSocket serverSocket = new ServerSocket(portNumber);

            while (true) {

                Socket clientSocket = serverSocket.accept();
                logger.showMessage("New client connected, starting server bot...");
                ServerBot bot = new ServerBot(clientSocket);
                new Thread(bot).start();
            }

        } catch (Exception e) {
            System.out.println("Cannot create server socket");
        }
    }
}
