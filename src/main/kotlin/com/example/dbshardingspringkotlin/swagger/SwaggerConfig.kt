package com.example.dbshardingspringkotlin.swagger

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

import springfox.documentation.builders.*

import springfox.documentation.service.ApiInfo
import springfox.documentation.service.ApiKey
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket


@Configuration
class SwaggerConfig {
    @Bean
    fun customDocket(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo)
                .securitySchemes(security())
    }

    private val apiInfo: ApiInfo
        private get() = ApiInfo(
                "spring rest Api Documentation",
                "This is REST API documentation of the Spring rest Api.",
                "1.0",
                "service",
                Contact(
                        "wade",
                        "",
                        "alienwade007@gmail.com"
                ),
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0", emptyList())

    private fun security(): List<ApiKey> {
        return listOf(ApiKey("JWT", "Authorization", "header"))
    }
}
