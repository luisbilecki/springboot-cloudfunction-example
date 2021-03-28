package com.luisbilecki.cloudfunction.functions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.function.context.FunctionCatalog;
import org.springframework.cloud.function.context.test.FunctionalSpringBootTest;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

@FunctionalSpringBootTest
public class ReverseTest {

    @Autowired
    private FunctionCatalog catalog;

    private Function<String, String> function;

    @BeforeEach
    public void initialize() {
        function = catalog.lookup(Function.class, "reverse");
    }

    @Test
    public void shouldReverseAString() throws Exception {
        Assertions.assertEquals("erots", function.apply("store"));
    }

}