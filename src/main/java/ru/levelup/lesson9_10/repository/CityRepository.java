package ru.levelup.lesson9_10.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.levelup.lesson9_10.entity.City;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Integer> {

    List<City> findByNameRu(String nameRu);

    @Query("select city from City city " +
            "where city.nameRu = :nameRu " +
            "and city.population >= :population")
    List<City> findByNameRuAndPopulation(@Param("nameRu") String nameRu,
                                         @Param("population") Integer population);
}
