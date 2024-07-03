import java.io.*;

public class WritingDataToFile {
    public static void writingDataToFile() throws FileNotFoundException, IOException {
        File file = new File("test.txt");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write("What about the coming mission ".getBytes()); // GetBytes used to convert String to arrayOfBytes uaAmer
//       علشان نفرغ ال سافون من الميه
        fos.flush();
        ReadingDataFromFile.makingThingsMoreDynamicFileReadingContent("test.txt");
        fos.close();
    }

    public static void readingCopyingImage() throws IOException {
        File file = new File("D:\\Java_Complete_course\\java-ioStreams\\score.png ");
        FileInputStream fis = new FileInputStream(file);
        byte[] arrayOfCharacters = new byte[(int) file.length()];
        fis.read(arrayOfCharacters);
        for (int i = 0; i < arrayOfCharacters.length; i++) {
            System.out.print(arrayOfCharacters[i]);
        }
        String convertedBytesToString = new String(arrayOfCharacters);

        FileOutputStream fos = new FileOutputStream("D:\\Java_Complete_course\\java-ioStreams\\new-score.png");
        fos.write(arrayOfCharacters);
        fos.flush();
        fos.close();
        fis.close();
    }


    public static void main(String[] args) {
        System.out.println("===========Don't make main function throws exception to JVM ? because how will handle it  ==============");
        try {
//            writingDataToFile();
            readingCopyingImage();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
