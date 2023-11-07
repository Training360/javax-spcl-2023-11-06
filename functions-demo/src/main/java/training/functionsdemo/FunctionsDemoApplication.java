package training.functionsdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Function;

@SpringBootApplication
public class FunctionsDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(FunctionsDemoApplication.class, args);
    }

    @Bean
    public Function<String, String> uppercase() {
        return s -> s.toUpperCase();
    }

    @Bean
    public Function<String, String> substring() {
        return s -> s.substring(0, 2);
    }

}
