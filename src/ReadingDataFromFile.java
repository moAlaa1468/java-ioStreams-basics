import java.io.*;
import java.util.Scanner;


/*
 *  steps for reading from a file [file could be text or binary [images , audio , video ] ]
 * step 1 :
 *   - create a stream or a pipe
 * step 2 :
 *  - locate the file
 * step 3:
 * -  you could use File class and send it to FileInputStream()
 *
 * step 4:
 *  - You must use close() function to close the stream unless you used the Try WithResource
 *
 * */
public class ReadingDataFromFile {
    public static void welcome() {
        Reader keyboardReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(keyboardReader);
        String line;
        try {

            int character = keyboardReader.read();
            line = bufferedReader.readLine();
            System.out.println(line);
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }

    public static void printNameUsingScanner() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter you name ");
        String name = scanner.nextLine();

        System.out.println("Your name is : " + name);
        System.out.println("Scanner Class throws unchecked exception so you Don't have " +
                "to use Try and catch blocks uaAlaa");

    }

    public static void readingSingleCharacterFromAFile() throws FileNotFoundException, IOException {
        FileInputStream fis = new FileInputStream("test.txt");
        fis.read(); // You need to make casting because the read() will return int value
        System.out.println((char) fis.read());
        fis.close();
    }

    public static void readingAllTheContentOfTheFile() throws FileNotFoundException, IOException {
        FileInputStream fis = new FileInputStream("test.txt");
        int outCharacter;
        while ((outCharacter = fis.read()) != -1) {
            System.out.println((char) outCharacter);
        }
        fis.close();
    }

    public static void readingAllTheContentOfTheFileWithString() throws FileNotFoundException, IOException {
        FileInputStream fis = new FileInputStream("test.txt");
//        عندك دالة ال read() بتقبل منك array of bytes ممكن انك تخزن كل حرف في Byte
//       وبعدين تباصي ال اري الي String
        byte[] arrayOfCharacters = new byte[4];
        fis.read(arrayOfCharacters);
//      read function will store each character in the byte array
//       then we need to convert the arrayOfBytes to String
        String arrayOfBytesToString = new String(arrayOfCharacters);
        System.out.println(arrayOfBytesToString);
        fis.close();
    }

    public static void makingThingsMoreDynamicFileReadingContent(String fileName) throws FileNotFoundException, IOException {
//       You need to use the file class
        File file = new File(fileName);
        FileInputStream fis = new FileInputStream(file);
        byte[] b = new byte[(int) file.length()];  // Just we will make simple casting to make the value integer
        fis.read(b);  // This methods will modify the value of the object Array because you will pass the reference of the Object Array of Bytes
        String allContent = new String(b);  // Then you pass the reference to the String to modify it
        System.out.println(allContent);
        fis.close();
    }


    public static void main(String[] args) throws IOException, FileNotFoundException {
//        welcome();
//        printNameUsingScanner();
//        System.out.println("What is the size oof single character : "+ Character.SIZE );
//        System.out.println("The single character in java is 2 bytes .");
//        readingSingleCharacterFromAFile();
//        readingAllTheContentOfTheFile();
//        readingAllTheContentOfTheFileWithString();
        makingThingsMoreDynamicFileReadingContent("test.txt");
    }


}
