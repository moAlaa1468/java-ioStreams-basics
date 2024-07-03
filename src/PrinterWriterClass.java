import java.io.*;

public class PrinterWriterClass {

    public static class Person {
        private String name;
        private String address;

        public Person(String name, String address) {
            this.name = name;
            this.address = address;
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }

    public static void writingUsingPrintReader() throws IOException {
        /*
         * This is the best one to write data to  Textual(Characters) files uaAmer
         * */


        PrintWriter printWriter = new PrintWriter(new FileWriter("test.txt", true), true);
        printWriter.println(99);
        printWriter.println("This line is Written using Print Writer class via methods called println() this methods overload many \n Times to accept different kinds of data");
        printWriter.print(true);
        printWriter.print("o");
        printWriter.print(23);
        printWriter.print(23.2);
        printWriter.print(new Person("mohamed Amer Name ", "cairo ").name);
        printWriter.print(new Person("MostafaAmer", "cairo ,Egypt").address);
        printWriter.print(new Person("PottterAmer", "Aswan ,Egypt").name);
        printWriter.print(new Person("Samir", "Alex ,Egypt"));
        printWriter.print("o");
        printWriter.println();
        printWriter.println();
        printWriter.print(true);
        printWriter.print(99238823);

        printWriter.flush();
        printWriter.close();
    }


    public static void readingUsingPrintReader() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("test.txt"));
        String line = bufferedReader.readLine();
        while (line != null) {
            System.out.println(line);
            line = bufferedReader.readLine();  // here you need to update the value of line
            // because you will get inside infinite loop uaAlaa
        }

        bufferedReader.close();
    }


    public static void main(String[] args) {
        try {
//            writingUsingPrintReader();
            readingUsingPrintReader();
        } catch (IOException e) {
            e.getMessage();
        }
    }
}
