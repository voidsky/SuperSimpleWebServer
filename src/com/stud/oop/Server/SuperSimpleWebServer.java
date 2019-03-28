package com.stud.oop.Server;

import com.stud.oop.Server.WebServer;

public class SuperSimpleWebServer {

    public static void main(String[] args) {

        int portNumber = Integer.parseInt(args[0]);

        WebServer ws = new WebServer();
        ws.start(portNumber);
        while (1 == 1) {
        }
    }
}
