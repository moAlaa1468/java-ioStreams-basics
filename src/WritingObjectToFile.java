import java.io.*;

import java.util.ArrayList;

public class WritingObjectToFile {

    public static class Person implements Serializable {
        private static final long serialVersionUID = 1L;

        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{name='" + name + "', age=" + age + "}";
        }
    }

    public class SerializeExample {



        public static void main(String[] args) {
            ArrayList<Person> personList = new ArrayList<>();
            personList.add(new Person("Alice", 30));
            personList.add(new Person("Bob", 25));
            personList.add(new Person("Charlie", 35));

            try (FileOutputStream fos = new FileOutputStream("persons.dat");
                 ObjectOutputStream oos = new ObjectOutputStream(fos)) {

                oos.writeObject(personList);

                System.out.println("ArrayList of Persons has been serialized to persons.dat");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }




    public class DeserializeExample {
        public static void main(String[] args) {
            try (FileInputStream fis = new FileInputStream("persons.dat");
                 ObjectInputStream ois = new ObjectInputStream(fis)) {

                // Read the ArrayList of Person objects
                ArrayList<Person> personList = (ArrayList<Person>) ois.readObject();

                System.out.println("Deserialized ArrayList of Persons:");
                for (Person person : personList) {
                    System.out.println(person);
                }

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }



}
