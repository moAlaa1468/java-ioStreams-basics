import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class TryWithResourceTasks {
    /*
       Simple Hint you could try inside another Try [nested Try and and nested Catch statement]
     * The idea is to close any opened resource automatically
     * if you forgot to close it Not more
     * All what you will do is to put your
     * resource in the try( Put your resources here uaAlaa this is the point ) {}
     *
     *   All methods here we used Try with resources uaAlaa
     *
     * We apply some Tasks to make it easy to understand uaAmer
     * */

    public static void writingUsingBufferedWriter(String fileName, String content) throws IOException {
        /*
         * The same line used before uaAmer in the above method This is so simple step uaAlaa Just focus
         * */
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));
        bufferedWriter.write(content);

        /*
         * You need to close everyThing before going out ===> clean them
         * */
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    public static ArrayList<String> readingNumbersFromAFile(String pathName) throws IOException {
        ArrayList<String> allContent = new ArrayList<>();
        try (
                /* simple hint this place only accepts resources
                 * File is not  a resources uaAmer
                 * */
                FileInputStream fileInputStream = new FileInputStream(new File(pathName));
                Reader fileReader = new FileReader(pathName);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
        ) {
            String line;
            while (true) {
                line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                allContent.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return allContent;
    }

    //    Making function to write content to a new file which exists or not exist
    public static void copingFromFileToAnotherFile(String sourceFilePath, String destFilePath) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(destFilePath))) {
            ArrayList<String> comingContent = readingNumbersFromAFile(sourceFilePath);
            System.out.println("The size of the arrayList is : " + comingContent.size());
            for (int i = 0; i < comingContent.size(); i++) {
                for (String singleLine : comingContent) {
                    bufferedWriter.write(singleLine + "\n");

                }
            }
            //we need to display the output to the screen
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public static void readingAllTheContentOfTheFile(String filePath) throws FileNotFoundException, IOException {
        try (FileInputStream fis = new FileInputStream(filePath);
        ) {
            int outCharacter;
            while ((outCharacter = fis.read()) != -1) {
                System.out.println((char) outCharacter);
            }
            fis.close();
        } catch (IOException exception) {
            exception.getMessage();
        }

    }

    public static void main(String[] args) {
        try {
            String content = "12346\n23782\n9238\n28349";
            writingUsingBufferedWriter("numbers.txt", content);
//
            copingFromFileToAnotherFile("numbers.txt", "numbers2.txt");
            System.out.println("***************** The output of File Two is ******************");
            System.out.println(readingNumbersFromAFile("numbers.txt"));

            copingFromFileToAnotherFile("numbers.txt", "numbers2.txt");
            System.out.println(readingNumbersFromAFile("numbers2.txt"));
        } catch (IOException e) {
            e.getMessage();
        }
    }
}
