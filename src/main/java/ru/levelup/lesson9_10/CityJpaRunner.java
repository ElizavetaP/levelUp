package ru.levelup.lesson9_10;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.levelup.lesson9_10.dto.CityDto;
import ru.levelup.lesson9_10.entity.Region;
import ru.levelup.lesson9_10.service.CityService;
import ru.levelup.lesson9_10.service.RegionService;

@SpringBootApplication
public class CityJpaRunner {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(CityJpaRunner.class, args);
        CityService cityService = context.getBean(CityService.class);
        System.out.println(cityService.findByNameRu("Апатиты"));

        Region region = new Region(null, "Восточный");
        RegionService regionService = context.getBean(RegionService.class);
        region = regionService.save(region);
        System.out.println(region);
        cityService.create(new CityDto(812, "Санкт-Петербург", "Saint-Petersburg", 3000000, "Северо-Западный"));

        System.out.println("Все города: " + cityService.findAll());


    }
}
