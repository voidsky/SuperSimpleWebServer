package com.stud.oop.Server;

import com.stud.oop.Protocol.PingPongProtocol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerBot implements Runnable {

    private Socket clientSocket;

    public ServerBot(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {

            PrintWriter outWriter =
                        new PrintWriter(clientSocket.getOutputStream(), true);

                BufferedReader inReader = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));


            String outString;
            String inString;

            PingPongProtocol protocol = new PingPongProtocol();

            while ((inString = inReader.readLine()) != null) {

                System.out.println(inString);

                outString = protocol.processInput(inString.toUpperCase());
                outWriter.println(outString);

                if (outString.equals("BYE")) {
                    break;
                }
            }

        } catch (IOException ex) {
            System.out.println("Exception in ServerBot " + ex);
        }
    }
}
