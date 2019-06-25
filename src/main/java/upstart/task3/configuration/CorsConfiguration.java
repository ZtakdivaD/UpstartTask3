package upstart.task3.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration implements WebMvcConfigurer {
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
			
				registry.addMapping("/**").allowedOrigins("https://ztakdivad.github.io/ZtakdivaD")
				.allowedMethods("GET, HEAD, PUT, POST, DELETE").allowCredentials(true);
			}
		};
	}
}
