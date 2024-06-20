package org.example;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;

public class Server {
    private String URL = "jdbc:sqlite:C:\\Users\\luke\\Documents\\usereeg.db";
    public HashMap<String, ClientHandler>clientHandlers= new HashMap<>();
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(6969);
    }
    public void start() throws IOException {
        ServerSocket socket = new ServerSocket(6969);
        while (true){
            Socket socket1= socket.accept();
            ClientHandler clientHandler= new ClientHandler(this);
            new Thread(clientHandler).start();
        }



    }
    public void addClient(String name, ClientHandler clientHandler){
        clientHandlers.put(name, clientHandler);

    }
    public void proccess(String name, String msg){
        int electrode= clientHandlers.get(name).getAndIncrease();
        saveToDataBase(name, msg, electrode);
    }
    public void removeClient(String name){
        clientHandlers.remove(name);
    }
    public void saveToDataBase(String message, String username, int electrode) {
        String chart = drawChart(message);
        String insertSQL = "INSERT INTO user_eeg(username, electrode_number, image) VALUES(?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
            pstmt.setString(1, username);
            pstmt.setInt(2, electrode);
            pstmt.setString(3, chart);
            pstmt.executeUpdate();
            System.out.println("Data saved.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    private String drawChart(String msg){
        int height = 100;
        int width=200;
        BufferedImage img= new BufferedImage( width,height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics2D= img.createGraphics();
        graphics2D.setColor(Color.WHITE);
        graphics2D.fillRect(0,0,width, height);
        graphics2D.setColor(Color.RED);
        String[] datas= msg.split(",");
        double[] data = Arrays.stream(datas).mapToDouble(Double::parseDouble).toArray();
        for (int i = 0; i < data.length; i++) {
            int y = height/2-(int)(data[i]);
            graphics2D.drawRect(i, y, 1,1);
        }
        return encodeImageToBase64(img);
    }
    private static String encodeImageToBase64(BufferedImage image) {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            ImageIO.write(image, "png", baos);
            byte[] imageBytes = baos.toByteArray();
            return Base64.getEncoder().encodeToString(imageBytes);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


}


