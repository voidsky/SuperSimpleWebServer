package com.company;

import java.util.Arrays;

public class PingPongProtocol {

    private String[] knownVerbs = {"PING", "PONG", "EXIT"};
    private String[] answers = {"PONG", "PING", "BYE"};

    public String processInput(String input) {

        int index = Arrays.asList(knownVerbs).indexOf(input);

        if (input == null) {
            return "Hi, lets start conversation!";
        } else if (input.length() >= 3 && input.substring(0, 3).equals("GET")) {

            String content = "<html>\n" +
                    "<head>\n" +
                    "  <title>An Example Page</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "  Hello World, this is a very simple HTML document.\n" +
                    "</body>\n" +
                    "</html>";

            return String.format("HTTP/1.1 200 OK\n" +
                    "Content-Type: text/html; charset=UTF-8\n" +
                    "Content-Length: %d\n\n%s",content.length(),content);

        } else if (index > -1) {
            return answers[index];
        } else {
            return "I have no idea what are you talking about!?";
        }
    }
}
