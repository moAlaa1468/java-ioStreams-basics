import java.io.*;
import java.nio.Buffer;

public class BufferedReaderAndWriter {

    /*
     * WE need to read some data using Buffered Writer and
     * then we need to write data to a file using FileWriter
     * */
    public static void readingUsingBufferedReader() throws IOException {
        File file = new File("test.txt");
        Reader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        System.out.println(bufferedReader.readLine());

        /*
         * Clean or close them before you Go uaAlaa
         * */
        bufferedReader.close();

    }

    public static void readingAllContentUsingBufferedReader() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("test.txt"));
//  You could loop to the all the file content
        String line = bufferedReader.readLine();
        while (line != null) {
            System.out.println(line);
            line = bufferedReader.readLine();
        }
        bufferedReader.close();
    }

    public static void writingUsingBufferedWriter() throws IOException {
        /*
         * The same line used before uaAmer in the above method This is so simple step uaAlaa Just focus
         * */
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("test.txt", true));
        bufferedWriter.newLine();
        bufferedWriter.write("We are used BufferedWriter to write some " +
                "Data to this file Mohamed Alaa amer implemented This code Thanks very much ");
        bufferedWriter.write("You are about to End everyThing related to file handling uaAlaa " +
                "Good Luck with java Spring and Spring Boot  ");
        bufferedWriter.newLine(); // To insert new line uaAmer

        /*
         * You need to close everyThing before going out ===> clean them
         * */
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    public static void main(String[] args) {
        try {
//            readingUsingBufferedReader();
//            writingUsingBufferedWriter();
            readingAllContentUsingBufferedReader();
        } catch (IOException e) {
            e.getMessage();
        }
    }
}
