package seb_39.pre_36.clone_stackoverflow.clone_stackoverflow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class CloneStackoverflowApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloneStackoverflowApplication.class, args);
	}

//	@Bean
//	public WebMvcConfigurer corsConfigurer(){
//		return new WebMvcConfigurer() {
//		@Override
//			public void addCorsMapping(CorsRegistry registry){
//			registry.addMapping("/**")
//					.allowedOrigins("http://localhost:3000", "http://localhost:8080");
//			}
//		};
//	}
}
