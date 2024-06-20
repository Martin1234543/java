package org.example;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerHandler {
    Socket socket;
    PrintWriter writer;

    public ServerHandler() throws IOException {
        socket= new Socket("localhost", 6969);
        writer= new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

    }
    public void send(String msg){
        writer.write(msg);
    }

}
