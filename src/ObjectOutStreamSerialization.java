import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ObjectOutStreamSerialization {

    /*
     * What if you need to write Object to a file
     * First you need to make this class implements Serializable interface
     * to Give a permissions to this file to be written in a file
     *
     * And the opposite you need to make deserialization This is so Great Task uaAlaa
     * */

    //    Man class must implement the Serializable interface uaAlaa to Give it permission to
//    be written to a file uaAlaa Thanks very much ==> Good Luck
    public static class Man implements Serializable {
        private static final long serialVersionUID = 1L;
        private String name;
        private String address;

        Man(String name, String address) {
            this.name = name;
            this.address = address;
        }

        @Override
        public String toString() {
            return "Man{" +
                    "name='" + name + '\'' +
                    ", address='" + address + '\'' +
                    '}';
        }
    }

    public static void writingClassToFileSerialization() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(new File("test2.txt"));
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        Man man1 = new Man("The name is : Mohamed Alaa amer ", "The Address is :  Cairo Egypt ");
        Man man2 = new Man("The name is : potter Amer ", "The Address is :  Cairo Egypt ");
        objectOutputStream.writeObject(man1);
        objectOutputStream.writeObject(man2);


        fileOutputStream.close();
    }

    public static void readingObjectFromFileDeSerialization() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("test2.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        Man man1 = (Man) objectInputStream.readObject();
        Man man2 = (Man) objectInputStream.readObject();

        System.out.println(man1);
        System.out.println(man2);

        objectInputStream.close();
    }


    public static void writingArrayOfObjectsToFile(ArrayList<Man> manArrayList) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(new File("test2.txt"), true);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(manArrayList);

        objectOutputStream.close();
    }

    public static void readingArrayOfObjectsToFile() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("test2.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        ArrayList<Man> result;
        result = (ArrayList<Man>) objectInputStream.readObject();
        for (Man ele : result) {
            System.out.println(ele.name);

            objectInputStream.close();


//        return result;

        }
    }

    public static void main(String[] args) {
        try {
//            writingClassToFileSerialization();
//            readingObjectFromFileDeSerialization();
            ArrayList<Man> mans = new ArrayList<>();
            mans.add(new Man("first man", "cairo , Egypt 2"));
            mans.add(new Man("second man", "cairo , Egypt 2"));
            mans.add(new Man("third man", "cairo , Egypt 2"));
            mans.add(new Man("fourth man", "cairo , Egypt 2"));
            mans.add(new Man("fifth man", "cairo , Egypt 2"));
            mans.add(new Man("sixth man", "cairo , Egypt 2"));
            //This is the writing operation
            writingArrayOfObjectsToFile(mans);

            // and we need to read them again from a file
            readingArrayOfObjectsToFile();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException ex) {
            ex.getMessage();
        }
    }
}

