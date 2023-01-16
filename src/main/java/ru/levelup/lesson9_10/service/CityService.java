package ru.levelup.lesson9_10.service;

import ru.levelup.lesson9_10.dto.CityDto;
import ru.levelup.lesson9_10.entity.City;

import java.util.List;

public interface CityService {

    List<City> findByNameRu(String name);

    List<City> findByNameRuAndPopulation(String name, Integer population);

    CityDto create(CityDto city);

    List<City> findAll();

    CityDto findById(Integer id);

    CityDto save(City city);

    CityDto updatePopulation(Integer id, Integer population);

    void deleteById(Integer id);

}
