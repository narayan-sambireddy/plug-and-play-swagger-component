package narayan.components.swagger;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *
 * @author narayana
 *
 */
@Configuration
@EnableSwagger2
@Import(AlphaSwaggerContext.class)
public @interface EnableAlphaSwagger { }
