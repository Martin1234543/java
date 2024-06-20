package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler implements Runnable{
    Socket socket;
    Server server;
    Scanner input;
    String name;
    private int nelectrode;

    public ClientHandler( Server server) throws IOException {
        this.socket = new Socket("localhost", 6969);
        this.server = server;
        input= new Scanner(socket.getInputStream());

    }
    public void run(){
        join();
    }
    public void join(){
        server.addClient(name,this);
    }
    public int getAndIncrease(){
        int i = this.nelectrode;
        nelectrode++;
        return i;
    }
    private void disconnect() throws IOException {
        server.removeClient(name);
        socket.close();

    }
}
