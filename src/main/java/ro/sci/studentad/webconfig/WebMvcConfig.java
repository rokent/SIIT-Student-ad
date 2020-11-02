package ro.sci.studentad.webconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.dialect.springdata.SpringDataDialect;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	@Bean
	public SpringDataDialect springDataDialect() {
		return new SpringDataDialect();
	}
}