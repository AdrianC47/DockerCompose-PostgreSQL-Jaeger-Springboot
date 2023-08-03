package ec.edu.ups.Clientes;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {


    @Bean
    public OpenAPI customOpenApi(){
        return new OpenAPI()
                .info(new Info()
                        .title("API Documentation")
                        .version("1.0")
                        .description("API documentacion para la App de Clientes en Sistemas Distribuidos")
                        .contact(new Contact()
                                .name("Adrian Cabrera")
                                .email("lcabrerab@est.ups.edu.ec")));
    }



}
