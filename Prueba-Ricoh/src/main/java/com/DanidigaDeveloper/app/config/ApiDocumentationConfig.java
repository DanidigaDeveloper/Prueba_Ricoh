package com.DanidigaDeveloper.app.config;

import io.swagger.annotations.*;

@SwaggerDefinition(
        info = @Info(
                description = "API REST para Prueba Práctica en RICOH",
                version = "",
                title = "API REST Daniel",
                contact = @Contact(
                   name = "Daniel Díaz", 
                   email = "dani_di_ga@hotmail.com", 
                   url = ""
                ),
                license = @License(
                   name = "", 
                   url = ""
                )
        ),
        consumes = {"application/json", "application/xml"},
        produces = {"application/json", "application/xml"},
        schemes = {SwaggerDefinition.Scheme.HTTP, SwaggerDefinition.Scheme.HTTPS},
        externalDocs = @ExternalDocs(value = "Read Docs.", url = "")
)
public interface ApiDocumentationConfig {

}