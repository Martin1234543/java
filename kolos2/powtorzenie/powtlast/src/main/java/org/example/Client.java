package org.example;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket("localhost", 6969);
        PrintWriter writer;
        Client client = new Client();
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj name:");
        String name=reader.readLine();
        System.out.println("Podaj sciezke:");
        String path= reader.readLine();
        //writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        client.sendData(name, path);

    }
    public void sendData(String name, String filepath) throws IOException, InterruptedException {
        ServerHandler serverHandler= new ServerHandler();
        serverHandler.send(name);
        //writer.flush();
        //writer.write(filepath);
        String line;
        BufferedReader reader= new BufferedReader(new FileReader(filepath));
        while ((line = reader.readLine())!=null){
            serverHandler.send(line);
            //writer.flush();
            Thread.sleep(2000);
        }
        serverHandler.send("elooooo");
        //writer.flush();
    }

}
