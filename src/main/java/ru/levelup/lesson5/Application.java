package ru.levelup.lesson5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.levelup.lesson5.enums.Units;
import ru.levelup.lesson5.impl.ConverterImpl;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        Temperature temperature = new Temperature(45d, Units.CELSIUS);
        System.out.println("Температура в Фаренгейтах: " +
                context.getBean(ConverterImpl.class).convert(temperature, Units.FAHRENHEIT));

    }
}
