package com.shedhack.trace.request.viewer;

import com.samskivert.mustache.Mustache;
import com.shedhack.trace.request.jpa.config.TraceRequestJpaConfiguration;
import com.shedhack.trace.request.viewer.controller.TraceRequestController;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.util.ClassUtils;

@SpringBootApplication
@Import(TraceRequestJpaConfiguration.class)
public class Application {

	@Value("${spring.application.name}")
	private String appName;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public BeanPostProcessor mutacheHackerBeanPostProcessor() {
		return new BeanPostProcessor() {
			private static final String BEAN_NAME = "mustacheCompiler";

			@Override
			public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
				return bean;
			}

			@Override
			public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
				if (ClassUtils.isAssignable(bean.getClass(), Mustache.Compiler.class) || BEAN_NAME.equals(beanName)) {
					Mustache.Compiler compiler = (Mustache.Compiler) bean;
					return compiler.defaultValue("").nullValue("");
				}

				return bean;
			}
		};
	}
}


