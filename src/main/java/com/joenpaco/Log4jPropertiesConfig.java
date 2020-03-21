package com.joenpaco;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({ @PropertySource("classpath:log4j.properties"),
				   @PropertySource("classpath:application.properties")}) 
public class Log4jPropertiesConfig {

}
