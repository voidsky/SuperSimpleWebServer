package com.stud.oop.Protocol;

interface VerbTest {
    boolean computeTest(String verb);
}

public class PingPongProtocol extends GenericProtocol {

    public void initialise() {
        this.addVerbAndAnswer("PING", "PONG");
        this.addVerbAndAnswer("TIK", "TAK");
        this.addVerbAndAnswer("KNOCK", "KNOCK");
        this.addVerbAndAnswer("EXIT", "BYE");
    }

    public String processInput(String input) {

        String reply;

        VerbTest isThisIsGetRequest = (s) -> s.length()>=3 && s.substring(0, 3).equals("GET");
        
        if (isThisIsGetRequest.computeTest(input)) {

            reply = "<html>\n" +
                    "<head>\n" +
                    "  <title>An Example Page</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "  Hello World, this is a very simple HTML document.\n" +
                    "</body>\n" +
                    "</html>";

            reply = String.format("HTTP/1.1 200 OK\n" +
                    "Content-Type: text/html; charset=UTF-8\n" +
                    "Content-Length: %d\n\n%s",reply.length(),reply);

        } else {
            reply = super.processInput(input.toUpperCase());
        }

        if (reply == null) return "Protocol failed to execute.";

        return reply;
    }
}
