package com.luisbilecki.cloudfunction.functions;

import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class Reverse implements Function<String, String> {

    @Override
    public String apply(String sentence) {
        return new StringBuilder(sentence).reverse().toString();
    }

}
