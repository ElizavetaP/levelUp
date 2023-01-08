package ru.levelup.lesson8.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.levelup.lesson8.entity.City;
import ru.levelup.lesson8.repository.CityRepository;
import ru.levelup.lesson8.service.CityService;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;

    @Override
    public List<City> findByNameRu(String nameRu) {
        return cityRepository.findByNameRu(nameRu);
    }

    @Override
    public List<City> findByNameRuAndPopulation(String nameRu, Integer population) {
        return cityRepository.findByNameRuAndPopulation(nameRu, population);
    }

    @Override
    @Transactional
    public void save(City city) {
        cityRepository.save(city);
    }

    @Override
    @Transactional
    public List<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    @Transactional
    public void update(City city) {
        cityRepository.save(city);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void deleteById(Integer id) {
        cityRepository.deleteById(id);
    }
}
