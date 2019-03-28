package com.company;

import java.io.IOException;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class SuperSimpleWebClient {

    public static void main(String[] args) {

        String hostName = args[0];
        int portNumber = Integer.parseInt(args[1]);

        try {
            Socket clientSocket = new Socket(hostName, portNumber);

            PrintWriter socketOut = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader socketIn = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));

            String fromServer, fromUser;
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

            while (1==1) {

                fromUser = buffer.readLine();

                if (fromUser != null) {
                    System.out.println("Client: " + fromUser);
                    socketOut.println(fromUser);

                    fromServer = socketIn.readLine();
                    System.out.println("Server: " + fromServer);
                    if (fromServer.equals("BYE"))
                        break;
                }
            }

        } catch (IOException ex) {

        }
    }
}

