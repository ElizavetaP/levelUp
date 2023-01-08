package ru.levelup.lesson8.service;

import ru.levelup.lesson8.entity.City;

import java.util.List;

public interface CityService {

    List<City> findByNameRu(String name);

    List<City> findByNameRuAndPopulation(String name, Integer population);

    void save(City city);

    List<City> findAll();

    void update(City city);

    void deleteById(Integer id);

}
