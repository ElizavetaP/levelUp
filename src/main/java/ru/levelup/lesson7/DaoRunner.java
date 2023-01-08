package ru.levelup.lesson7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.levelup.lesson7.dao.CityDao;
import ru.levelup.lesson7.model.City;

import java.util.Scanner;

@SpringBootApplication
public class DaoRunner {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DaoRunner.class, args);
        CityDao cityDao = context.getBean(CityDao.class);
        Scanner in = new Scanner(System.in);

        cityInput(in, cityDao);

        System.out.println("All cities: \n" + cityDao.findAll());

        System.out.println(cityId + " city. print city: \n" + cityDao.getById(cityId));
        cityDao.update(new City(cityId, "newRu", "newEn", 0));
        System.out.println(cityId + " city. update city: \n" + cityDao.getById(cityId));
        cityDao.deleteById(cityId);
        System.exit(0);
    }

    private static int cityId;

    private static void cityInput(Scanner in, CityDao cityDao) {
        System.out.println("Новый город: ");
        System.out.println("Введите код города: ");
        int code = in.nextInt();
        System.out.print("Введите название на русском: ");
        String nameRu = in.next();
        System.out.print("Введите название на английском: ");
        String nameEn = in.next();
        System.out.print("Введите численность населения: ");
        int population = in.nextInt();
        cityDao.create(new City(code, nameRu, nameEn, population));
        System.out.println("Выход y/n: ");
        String exit = in.next();
        if ("n".equals(exit)) {
            cityInput(in, cityDao);
        }
        cityId = code;

    }
}
