package simpleChatApp;

import javax.print.attribute.standard.PrinterState;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void establishingClientConnection() {
        try (
                /*
                 * You will make the initialization step
                 * */
                Socket socket = new Socket("192.168.1.7", 8888);
                // You need to establish channels uaAlaa
                OutputStream fromClient = socket.getOutputStream();
                InputStream toClient = socket.getInputStream();
                // You need to receive some data to server first
                Reader r = new InputStreamReader(toClient);
                BufferedReader bufferedReader = new BufferedReader(r);
                // You need to send or print some data to the server
                PrintStream fromClientToSeverPrinter = new PrintStream(fromClient);
                Scanner scanner = new Scanner(System.in);

        ) {
            /*
             * Whole process could be put here uaAlaa This is simple task
             * */
            //[1- Input ]


            //[2-Processing ]
            while (true) {

                System.out.println("Enter the message to be sent to Sever ");
                String userInput = scanner.nextLine();
                if (userInput.toLowerCase().trim().equals("bye")) {
                    break;
                }
                fromClientToSeverPrinter.println(userInput);
                System.out.println("Waiting SERVER ... ");
                //we need to receive message from the server
                String serverMessage = bufferedReader.readLine();
                System.out.println(serverMessage);
                //[3- output ]

            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        establishingClientConnection();
    }
}
