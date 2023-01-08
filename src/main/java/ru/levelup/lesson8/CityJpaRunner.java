package ru.levelup.lesson8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.levelup.lesson8.entity.City;
import ru.levelup.lesson8.entity.Region;
import ru.levelup.lesson8.service.CityService;
import ru.levelup.lesson8.service.RegionService;

@SpringBootApplication
public class CityJpaRunner {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(CityJpaRunner.class, args);
        CityService cityService = context.getBean(CityService.class);
        System.out.println(cityService.findByNameRu("Апатиты"));

        Region region = new Region(3, "Северо-Западный2");
        RegionService regionService = context.getBean(RegionService.class);
        region = regionService.save(region);
        System.out.println(region);
        cityService.save(new City(812, "Санкт-Петербург", "Saint-Petersburg", 3000000, region));

        System.out.println("Все города: " + cityService.findAll());

        System.out.println("Удаляем 81555");
        cityService.deleteById(81555);
        System.out.println("Обновляем 812");
        cityService.update(new City(812, "Санкт-Петербург", "Saint-Petersburg", 3000001, region));
        System.out.println("Все города: " + cityService.findAll());

    }
}
