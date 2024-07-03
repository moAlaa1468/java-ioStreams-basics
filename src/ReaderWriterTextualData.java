import java.io.*;

public class ReaderWriterTextualData {

    public static void writingDataToFileUsingWriter() throws IOException {
        File file = new File("readerWriterFile.txt");
        FileWriter fileWriter = new FileWriter(file);
        String s = " I need to write all these values to my newly created file under name Mohamed Alaa amer ";
        fileWriter.write(s);
        fileWriter.close();
    }

    public static void appendingNewContentToFile(String fileName, String newContent) throws IOException {
        File file = new File(fileName);
        Writer fileWriter = new FileWriter(fileName, true);
        fileWriter.write(newContent);
        fileWriter.close();
    }

    public static void readingDataFromFileUsingReader() throws IOException {
        File file = new File("readerWriterFile.txt");
        Reader fileReader = new FileReader(file);
        int characters;
        while ((characters = fileReader.read()) != -1) {
            System.out.print((char) characters); // You have to make Casting uaAlaa
        }
    }

    public static void readingDataFromFileUsingReaderWithForLoop() throws IOException {
        File file = new File("readerWriterFile.txt");
        Reader fileReader = new FileReader(file);
        char[] allCharacters = new char[(int) file.length()];
        fileReader.read(allCharacters); // You always forget about this point uaAlaa
        for (char singleCharacter : allCharacters) {
            System.out.print(singleCharacter);
        }
        fileReader.close();
    }


    public static void main(String[] args) {
        try {
//            writingDataToFileUsingWriter();
//            readingDataFromFileUsingReader();
//            appendingNewContentToFile("readerWriterFile.txt", "\nThis is my new content to be added to the file ");
            readingDataFromFileUsingReaderWithForLoop();
        } catch (IOException e) {
            e.getMessage();
        }
    }
}


