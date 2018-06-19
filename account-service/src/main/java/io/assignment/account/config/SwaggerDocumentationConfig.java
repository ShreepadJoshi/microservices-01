package io.assignment.account.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Deepak Muthekar
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerDocumentationConfig {
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("io.assignment.account.resource"))
				.paths(PathSelectors.any())
				.build()
                .apiInfo(metaData());


	}

	 private ApiInfo metaData() {
	        return new ApiInfoBuilder()
	                .title("Customer REST API")
	                .description("Spring Boot REST API for Customer Resource")
	                .version("1.0.0")
	                /*.license("Created For assignmnet. Put your licence terms and conditions here")
	                .licenseUrl("License URL goes heer")*/
	                .contact(new Contact("Deepak Muthekar","https://www.linkedin.com/in/deepak-muthekar-20275b9/", "deepakmuthekar@gmail.com"))
	                .build();
	    }



}
