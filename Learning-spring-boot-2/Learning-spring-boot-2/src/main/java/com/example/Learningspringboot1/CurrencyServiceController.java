package com.example.Learningspringboot1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@SuppressWarnings("unused")
@ConfigurationProperties(prefix = "currency-service")
@Component
class CurrencyServiceConfiguration {
	public String url;
	public String userName;
	public String key;
}

@RestController
public class CurrencyServiceController {
	
	@Autowired
	private CurrencyServiceConfiguration configuration;
	
	@RequestMapping(value = "/currency-configuration", method = RequestMethod.GET)
	public CurrencyServiceConfiguration retrieveConfiguration(
			@RequestParam(value = "Course", required = false) Course coure) {
		return configuration;
	}
}
