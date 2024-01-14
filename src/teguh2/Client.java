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

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 12345);

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            out.println("permintaan");

            String serverResponse = in.readLine();
            System.out.println("Server: " + serverResponse);

            if (serverResponse.startsWith("3#")) {
                String question = serverResponse.substring(3).trim();
                System.out.print("Jawab pertanyaan: " + question + " ");
                BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
                String answer = userInput.readLine();
                out.println("3# " + answer);

                String serverFeedback = in.readLine();
                System.out.println("Server: " + serverFeedback);
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

