/**
 * Created by IntelliJ IDEA.
 * User: trident
 * Date: 2023/3/25
 * Time: 20:45
 **/
package com.aks.management;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
   
   /* http://localhost:8080/swagger-ui/index.html*/
    @Bean
    public OpenAPI aksOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("AKS API")
                        .description("aks接口文档")
                        .version("v1.0.1"))
                /*.externalDocs(new ExternalDocumentation()
                        .description("aks接口文档")
                        .url("https://aks-nj.com"))*/;
    }
}