package narayan.components.swagger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 *
 * @author narayana
 *
 */
class AlphaSwaggerContext {

    @Value("${API_VERSION:1.0}")
    private String API_VERSION;

    @Value("${API_TITLE:My Microservice API}")
    private String API_TITLE;

    @Value("${API_DESCRIPTION:My Microservice API Description}")
    private String API_DESCRIPTION;

    @Value("${API_PACKAGES_TO_SCAN:narayan.components.swagger.demo.controller}")
    private String API_PACKAGES_TO_SCAN;

    @Value("${API_CONTACT_NAME:Narayan Sambi Reddy}")
    private String API_CONTACT_NAME;

    @Value("${API_CONTACT_EMAIL:narayan-sambireddy@outlook.com}")
    private String API_CONTACT_EMAIL;

    @Value("${API_CONTACT_URL:}")
    private String API_CONTACT_URL;


    @Bean
    public Docket swaggerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .title(API_TITLE)
                        .description(API_DESCRIPTION)
                        .version(API_VERSION)
                        .contact(new Contact(API_CONTACT_NAME, API_CONTACT_URL, API_CONTACT_NAME))
                        .build())
                .select()
                        .apis(RequestHandlerSelectors.basePackage(API_PACKAGES_TO_SCAN))
                .build();
    }

}
