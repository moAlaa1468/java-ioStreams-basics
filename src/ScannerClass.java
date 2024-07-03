import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ScannerClass {
    public static void readingDataUsingScanner() throws IOException {
        /*
         * You could receive Where is the location that
         * the file will receive data From is it System.in
         * or a file ===> Here you could make it a file ===> Simple Task
         *
         * */
        // So That the Scanner will read data From this file
        Scanner scanner = new Scanner(new FileReader("test.txt"));
        String result = scanner.nextLine();
        while (scanner.hasNextLine()) {
            System.out.println(result);
            result = scanner.nextLine();
        }

//        String singleWord=scanner.next();
//        while (scanner.hasNext()) {
//            System.out.println(singleWord);
//            singleWord = scanner.next();
//        }

        scanner.close();
    }


    public static void readingDataFormattedByScanner(String pattern)throws IOException{
        Scanner scanner=new Scanner(new FileReader("test.txt"));
        scanner.useDelimiter(pattern);
        while(scanner.hasNext()){
            System.out.println(scanner.next());
        }
    }



    public static void main(String[] args) {
        try {
//            readingDataUsingScanner();
//            readingDataFormattedByScanner("\\z");
            readingDataFormattedByScanner("\\s+");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
