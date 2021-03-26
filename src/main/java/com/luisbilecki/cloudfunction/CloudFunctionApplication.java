package com.luisbilecki.cloudfunction;

import com.luisbilecki.cloudfunction.functions.Reverse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.function.context.FunctionRegistration;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.support.GenericApplicationContext;

@SpringBootApplication
public class CloudFunctionApplication implements ApplicationContextInitializer<GenericApplicationContext> {

	public static void main(String[] args) {
		SpringApplication.run(CloudFunctionApplication.class, args);
	}

	@Override
	public void initialize(GenericApplicationContext context) {
		context.registerBean("reverse", FunctionRegistration.class,
				() -> new FunctionRegistration<>(new Reverse()).type(Reverse.class));
	}

}
