package com.luisbilecki.cloudfunction.functions;

import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class Palindrome implements Function<String, Boolean> {

    @Override
    public Boolean apply(String sentence) {
        String clean = sentence.replaceAll("\\s+", "").toLowerCase();
        String reversed = new StringBuilder(clean).reverse().toString();

        return reversed.equals(clean);
    }

}
