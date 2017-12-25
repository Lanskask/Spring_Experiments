package hello;

import java.util.ArrayList;
import java.util.List;

public class LittleMains {
    static {
        System.out.println("init");
    }
    public static void main(String[] args) {

        LittleMains littleMains = new LittleMains();
        littleMains.run();
//        littleMains.meth1();

/*        System.out.println(null - null);
        System.out.println(null * null);*/
        System.out.println("line.separator: " + System.getProperty("line.separator"));

        System.out.println("!false && 16 != 0: " + (!false && 16 != 0));
        System.out.println( 12 & 1 );
    }

    void run() {
//        this.repl1();
//        this.repl2();
        this.arrPrTest();
    }

    void repl1() {
        String inputText = "пл. Правды";
        inputText = inputText.replace(".", "");
        System.out.println(inputText);
    }

    void repl2() {
        System.out.println(8 ^ 4);
    }

    void arrPrTest() {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice"));
        people.add(new Person("Bob"));
        System.out.println(people);
    }

    class Person {
        String name;
        Person(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return this.name;
        }
    }
}
