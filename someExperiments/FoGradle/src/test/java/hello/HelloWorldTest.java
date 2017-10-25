package hello;

import org.junit.Before;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by smurtazin on 24.10.2017.
 */
public class HelloWorldTest {
    HelloWorld hello;

    @Before
    public void init() {
        this.hello = new HelloWorld();
    }

    @org.junit.Test
    public void dateGetTime() throws Exception {
        System.out.println("dateGetTime: " + this.hello.dateGetTime());
        System.out.println("Str date" + new Date("2017-10-24"));
//        assertTrue(this.hello.dateGetTime(), equals(new Date("2017-10-24")));
    }

}