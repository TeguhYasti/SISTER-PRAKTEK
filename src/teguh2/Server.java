/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package anshar270923;

/**
 *
 * @author ansha
 */
import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Server berjalan. Menunggu koneksi...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Klien terhubung!");

                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                String clientMessage = in.readLine();
                System.out.println("Client: " + clientMessage);

                if (clientMessage.equals("permintaan")) {
                    out.println("3# Siapa pembuat Java?");
                    clientMessage = in.readLine();
                    System.out.println("Client: " + clientMessage);

                    if (clientMessage.startsWith("3#")) {
                        String answer = clientMessage.substring(3).trim();
                        if (answer.equalsIgnoreCase("James Gosling")) {
                            out.println("Kerja yang bagus!");
                        } else {
                            out.println("Jawaban salah!");
                        }
                    } else {
                        out.println("Format jawaban salah!");
                    }
                }
                clientSocket.close();
                System.out.println("Koneksi dengan klien ditutup.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
