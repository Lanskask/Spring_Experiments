package javavalues;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class ValuesTest {
    public static void main(String[] args) {
        ValuesTest valuesTest = new ValuesTest();
        valuesTest.run();

        System.out.println();
    }

    void run() {
//        this.printIntMax();
        this.fun2();
    }

    void printIntMax() {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Math.pow(2, 31));
    }

    void fun2() {
        Cl1 cl1 = new Cl1();
//        cl1.field1 = null;
        cl1.setLongf(Long.parseLong("-1"));
        System.out.println(cl1.toString());
    }

    @Setter @Getter
    @ToString
    class Cl1 {
        int field1;
        Long longf;
        public Integer getField1() {
            return field1;
        }

        public void setField1(Integer field1) {
            this.field1 = field1;
        }
    }
}
