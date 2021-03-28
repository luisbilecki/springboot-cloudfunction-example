package com.luisbilecki.cloudfunction.functions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.function.context.FunctionCatalog;
import org.springframework.cloud.function.context.test.FunctionalSpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

@FunctionalSpringBootTest
public class PalindromeTest {

    @Autowired
    private FunctionCatalog catalog;

    private Function<String, Boolean> function;

    @BeforeEach
    public void initialize() {
        function = catalog.lookup(Function.class, "palindrome");
    }

    @Test
    public void shouldReturnTrueForSentencesThatArePalindromes() throws Exception {
        List<String> palindromes = Arrays.asList("Racecar", "Anna", "Civic", "Radar", "I did, did I", "No lemon, no melon");
        palindromes.forEach(sentence -> Assertions.assertTrue(function.apply(sentence)));
    }

    @Test
    public void shouldReturnFalseForSentencesThatAreNotPalindromes() throws Exception {
        List<String> nonPalindromes = Arrays.asList("Java", "glass", "water", "do you like surfing?");
        nonPalindromes.forEach(sentence -> Assertions.assertFalse(function.apply(sentence)));
    }

}