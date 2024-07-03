package sockets;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

public class Client {

    public static void establishClientConnection() {

        try (
                Socket mySocket = new Socket("192.168.1.7", 7777);
                // preparing Two channels here one for input and another for output
                InputStream comingStreamFromServer = mySocket.getInputStream();
                OutputStream sendingStreamToServer = mySocket.getOutputStream();
                // ---------- You will need to read and write to this server -------
                // This step for receiving data from the server
                Reader r = new InputStreamReader(comingStreamFromServer);
                BufferedReader readDataFromServer = new BufferedReader(r);
//                we need to send data to the server  ==> This way have some limitations
                Writer w = new OutputStreamWriter(sendingStreamToServer);
                PrintWriter sendDataToServer = new PrintWriter(w);
                // Another way to print data to server ==> This is the best way to send Streams
//                to your server continue
//                USE PRINT STREAM TO PRINT DATA TO SERVER UAALAA
                PrintStream toSeverPrinter = new PrintStream(sendingStreamToServer);

                //Calling the Scanner Class
                Scanner scanner = new Scanner(System.in);
        ) {
            while (true) {
                // [1- INPUT ]
                System.out.println("Please enter you message : ");
                String userInput = scanner.nextLine();
                // [2- PROCESSING]
                toSeverPrinter.println(userInput);
                String serverMessage = readDataFromServer.readLine();
                // [3- OUTPUT ]
                System.out.println(serverMessage);
            }
        } catch (IOException ex) {
            ex.getMessage();
        }
    }


    public static void main(String[] args) {

        establishClientConnection();


//        try (
//                Socket mySocket = new Socket("192.168.1.7", 7777);
//                // preparing Two channels here one for input and another for output
//                InputStream comingStreamFromServer = mySocket.getInputStream();
//                OutputStream sendingStreamFromServer = mySocket.getOutputStream();
//                // ---------- You will need to read and write to this server -------
//                // This step for receiving data from the server
//                Reader r = new InputStreamReader(comingStreamFromServer);
//                BufferedReader readDataFromServer = new BufferedReader(r);
////                we need to send data to the server
//                Writer w = new OutputStreamWriter(sendingStreamFromServer);
//                BufferedWriter sendDataToServer = new BufferedWriter(w);
//                // Another way to send data to the server
//                PrintWriter printDataToServer = new PrintWriter(sendDataToServer);  // You have to use printWriter with while Loop
////                What if you need to take input from the user ==> use the Scanner Class
//                Scanner scanner = new Scanner(System.in);   // The Resource will be keyboard;
//        ) {
//
//            while (true) {
//                // [1- INPUT ]
////                String name = "Mohamed Alaa amer made this connection";
////                String now = new Date().toString();
//
//                String messageToServer = "Mohaemd Alaa amer ";
//                System.out.println("Enter the message that you Want : ");
//                String useInput = scanner.nextLine();
////                // [2- PROCESSING]
//
//                // [3- OUTPUT ]
////            sendDataToServer.write(now);
//                printDataToServer.println(useInput);
//
//            }
//        } catch (IOException ex) {
//            ex.getMessage();
//        }
//    }
    }
}
