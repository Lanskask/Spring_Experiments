package hello;

import java.util.ArrayList;
import java.util.List;

public class Lambda8 {

    public static void main(String[] args) {
        Lambda8 lambda8 = new Lambda8();
        lambda8.run();
    }

    void run() {
        this.trylambd1();
    }

    void trylambd1() {
        List<String> items = new ArrayList<>();
        items.add("A");
        items.add("B");
        items.add("C");
        items.add("D");
        items.add("E");

        //lambda Output : A,B,C,D,E
        System.out.println("lambda");
        items.forEach(item->System.out.print(item + ", "));
        System.out.println();

        //Output : C
        System.out.println("Output : C");
        items.forEach(item->{
            if("C".equals(item)){
                System.out.print(item);
            }
        });
        System.out.println();

        //method reference Output : A,B,C,D,E
        System.out.println("method reference");
        items.forEach(System.out::print);
        System.out.println();

        //Stream and filter Output : B
        System.out.println("Stream and filter");
        items.stream()
                .filter(s->s.contains("B"))
                .forEach(System.out::print);
        System.out.println();
    }
}
