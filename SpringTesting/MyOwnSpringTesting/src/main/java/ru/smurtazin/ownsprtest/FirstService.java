package ru.smurtazin.ownsprtest;

import org.springframework.stereotype.Service;

@Service("firstService")
public class FirstService {

    String backString(String requestStr) {
        return "Hello, " + requestStr;
    }

}

