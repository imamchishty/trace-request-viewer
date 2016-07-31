package com.shedhack.trace;

import com.shedhack.trace.request.viewer.config.TraceRequestViewerConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(TraceRequestViewerConfiguration.class)
public class Application {

	@Bean
	public TestService service() {
		return new TestService();
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}


