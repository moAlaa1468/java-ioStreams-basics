import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileClassOperation {


    public static void main(String[] args) {
        File file = new File("abc.txt");
        System.out.println(file.exists()); //So the file doesn't not exist
        System.out.println("we need to create this file ");
        try {
            file.createNewFile();
            System.out.println(file.exists());
            System.out.println(file.getName());
            System.out.println(file.getParent());
            System.out.println(file.getAbsoluteFile());
            System.out.println(file.getCanonicalFile());
            System.out.println(file.length()); // the output is 0
            // we need to add some content to this file uaamer
            FileOutputStream fos = new FileOutputStream(file);
            fos.write("We are going to write  some data to this file uaAmer ".getBytes(StandardCharsets.UTF_8));
            fos.close();
            // we need to check if the file contains any data or not
            System.out.println(file.length());  // output is 53
            //Now we need to list the content of the file
            FileInputStream fis = new FileInputStream(file);
            byte[] b = new byte[(char) file.length()];
            fis.read(b);
            String fileContent = new String(b);
            System.out.println(fileContent);
            fis.close();
            // we need to check the last modification to this file
            Date date = new Date(file.lastModified());
            SimpleDateFormat std = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String formatedDate = std.format(date);
            System.out.println("The last modified file date is : "+ formatedDate);
            // we  need to check if you could write or not to this file
            System.out.println(file.canWrite());
            System.out.println(file.canRead());
        } catch (
                IOException e) {
            e.getMessage();
        }
    }
}
