package socketSimpleChatingApp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Server {
    //This is like archiving your Chats uaAlaa
    public static void writingConversationToFile(ArrayList<String> wholeConversation) {
        try (PrintWriter writerToFile = new PrintWriter(new FileWriter("chat.txt", true), true);
             BufferedReader fileReader = new BufferedReader(new FileReader("chat.txt"));
        ) {
            for (String ele : wholeConversation) {
                writerToFile.println(ele);
            }
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public static ArrayList<String> establishServerConnection() {


        ArrayList<String> wholeConversation = new ArrayList<>();
        try (
                /*
                 * You will make the initialization step
                 * */
                ServerSocket serverSocket = new ServerSocket(8888);
                Socket socket = serverSocket.accept(); // For waiting respond from a client
                // establishing channels for getting streams from and to clients
                OutputStream fromServer = socket.getOutputStream(); //outgoing data from server
                InputStream toServer = socket.getInputStream();
                // we need to use controllers
                Reader r = new InputStreamReader(toServer);
                BufferedReader bufferedReader = new BufferedReader(r);
                // we need to write or send or print data to the client uaAlaa
                PrintStream fromSeverToClientPrinter = new PrintStream(fromServer);

                //we need to use Scanner to input some words
                Scanner scanner = new Scanner(System.in);

                //we need to make some resources for the files

        ) {
            /*
             * Whole process could be put here uaAlaa This is simple task
             * */

            //[1- Input ]

            //[2-Processing ]
            SmartReplyEngine smartReplyEngine = new SmartReplyEngine();
            while (true) {
//                System.out.println("Please enter the message to be send to server :");
//                String userInput = scanner.nextLine();
//                if (userInput.toLowerCase().trim().equals("bye")) {
//                    break;
//                }
                //we need to receive some data from the client
                String clientInput = bufferedReader.readLine();
                String message = smartReplyEngine.reply(clientInput.trim().toString());
                if (message.toLowerCase().equals("bye") || message == null) {
                    break;
                }

                //we need to send this message to the client
                fromSeverToClientPrinter.println(message);
                System.out.println("client response is  : ");
                System.out.println(clientInput);
                System.out.println(" I am server I told him That : " + message);
                wholeConversation.add(message + clientInput);
            }
            System.out.println(wholeConversation);

            //[3- output ]
//            fromSeverToClientPrinter.println();


        } catch (IOException | NullPointerException e) {
            System.err.println(e.getMessage());
        }
        return wholeConversation;
    }


    public static void main(String[] args) {
        ArrayList<String> chat = establishServerConnection();
        writingConversationToFile(chat);

    }
}
