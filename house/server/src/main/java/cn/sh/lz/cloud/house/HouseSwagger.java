package cn.sh.lz.cloud.house;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.AuthorizationScopeBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

import static com.google.common.collect.Lists.newArrayList;

/**
 * Created by Link at 15:07 on 4/11/19.
 */
@Configuration
@EnableSwagger2
public class HouseSwagger {
    @Bean
    public Docket createRestApi() {
        AuthorizationScope[] authScopes = new AuthorizationScope[1];
        authScopes[0] = new AuthorizationScopeBuilder()
                .scope("read")
                .description("read access")
                .build();
        SecurityReference securityReference = SecurityReference.builder()
                .reference("house")
                .scopes(authScopes)
                .build();
        ArrayList<SecurityContext> securityContexts = newArrayList(SecurityContext.builder().securityReferences
                (newArrayList(securityReference)).build());

        return new Docket(DocumentationType.SWAGGER_2)
                .securitySchemes(newArrayList(new BasicAuth("house")))
                .securityContexts(securityContexts)
                .groupName("server-api")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("cn.sh.lz.cloud.house.controllers"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Test Project Restful API")
                .version("1.0")
                .contact(new Contact("Link Zhang", "", "Link.Zhang.0@gmail.com"))
                .build();
    }
}
