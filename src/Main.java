import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // This will get the default input device
        // The default input for this computer is KeyBoard and you could change this default input
        // In different environments there are different input Streams
        // Every input device has different serial Number

        // [1] Input Process
        System.out.println("Please enter your name : ");
        String name = scanner.nextLine();

        // [2] Processing phase And output
        System.out.println("welcome to our new system your name is  :" + name);

    }
}