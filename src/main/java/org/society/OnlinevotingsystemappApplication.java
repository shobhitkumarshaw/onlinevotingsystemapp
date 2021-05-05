package org.society;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@CrossOrigin(origins = "http://localhost:4200")
@EnableSwagger2
public class OnlinevotingsystemappApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlinevotingsystemappApplication.class, args);
	}

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				// .apis(RequestHandlerSelectors.basePackage("com"))
				.paths(PathSelectors.any()).build().apiInfo(metaInfo());
	}

	private ApiInfo metaInfo() {
		@SuppressWarnings("deprecation")
		ApiInfo apiInfo = new ApiInfo("Online Voting Application", "Sprint:1", "1.0", "", "Group:2", "Licence 2.1.0",
				"https://www.cg.com");
		return apiInfo;
	}
}