package ru.smurtazin.springexperiments.basic;

import org.junit.Test;

import static org.junit.Assert.*;

public class HelloWorldTest {
    @Test
    public void main() throws Exception {
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.main(new String[]{"a", "b"});
    }

}