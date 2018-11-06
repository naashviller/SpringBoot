package ru.itis;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
/*@ComponentScan("ru.itis")
@EnableJpaRepositories("ru.itis.repository")
@EntityScan(basePackages = "ru.itis.model")*/
public class Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class, args);

    }


}
