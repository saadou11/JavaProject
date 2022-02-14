package spring.swagger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;
import java.util.List;

@Configuration
@Import(BeanValidatorPluginsConfiguration.class)
@ConditionalOnProperty(value = "am-data.fsociety.swagger.enabled", havingValue = "true")
public class SwaggerConfiguration {

    private final boolean secure;
    public static final String AUTHORIZATION_HEADER = "Authorization";

    public SwaggerConfiguration(@Value("${am-data.fsociety.security.enabled}") boolean secure) {
        this.secure = secure;
    }

    /**
     * @return
     */
    private ApiKey apiKey() {
        return new ApiKey("JWT", AUTHORIZATION_HEADER, "header");
    }

    /**
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("AM&DATA")
                .description("Your documentation goes here")
                .version("1.0")
                .termsOfServiceUrl("Terms of service")
                .contact(new Contact("AM&DATA", "", "anes.mahi@gmail.com"))
                .license("Licence of API")
                .licenseUrl("Api licence URL")
                .extensions(Collections.emptyList())
                .build();
    }

    /**
     * @return
     */
    @Bean
    public Docket api() {
        final Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
        if (secure)
            docket.securityContexts(Collections.singletonList(securityContext()))
                    .securitySchemes(Collections.singletonList(apiKey()));
        return docket;
    }

    /**
     * @return
     */
    private SecurityContext securityContext() {
        return SecurityContext.builder().securityReferences(defaultAuth()).build();
    }

    /**
     * @return
     */
    private List<SecurityReference> defaultAuth() {
        AuthorizationScope[] authorizationScope = {new AuthorizationScope("global", "everything")};
        return Collections.singletonList(new SecurityReference("JWT", authorizationScope));
    }
}

