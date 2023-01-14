package ru.levelup.lesson6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ru.levelup.lesson6.Application.class, args);

        Scanner in = new Scanner(System.in);
        System.out.print("Input a number: ");
        int num = in.nextInt();

        FibonacciGenerator fg = context.getBean(FibonacciGenerator.class);

        while (num > 0) {
            System.out.println("Фибоначчи: " + fg.nextAmount(num));
            System.out.println("Input a number: ");
            num = in.nextInt();
        }
        System.exit(0);

    }
}
