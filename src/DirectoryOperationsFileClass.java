import java.io.File;
import java.io.FileOutputStream;

public class DirectoryOperationsFileClass {

    public static void creatingMultipleDirectories(String path) {
      /*
      * You have four constructors for File to create new File in a direcotry
      *
      * */

        File file = new File(path);
        File file1= new File("String parent","StringChild"); // This is another constructor uaAmer
        file.mkdirs();
    }

    /*
    * This is the most important function here
    * */
    public static boolean deleteDirectory(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File element : files) {
                    if (element.isDirectory()) {
                        // repeat the function itself
                        deleteDirectory(element);
                    } else {
                        //Delete the file
                        if (!element.delete()) {
                            System.out.println(" I cannot delete this file " + element.getPath());
                        }
                    }
                }
            }
        }

        return file.delete();
    }

    public static void main(String[] args) {
        // You could create Directory using File Class uaAmer
        File file = new File("AlaaFolder/subFolder");
        file.mkdirs(); // This method will create a folder called AlaaFolder
        file.exists(); // the main point here is pathName uaamer
        File file1 = new File("AlaaFolder/subFolder");
        file1.delete(); // This will delete the last parameter of the path uaAmer
        //what if you need to delete list of Directories inside single Directory  uaAmer
        File file2=new File("AlaaFolder");
        System.out.println(  deleteDirectory(file2)); // Output is True so you could delete any Folder with its subfolders
    }


}
