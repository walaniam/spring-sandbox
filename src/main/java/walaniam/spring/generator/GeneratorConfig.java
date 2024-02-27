package walaniam.spring.generator;

import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeneratorConfig {

    @Bean
    public Faker faker() {
        return new Faker();
    }
}
