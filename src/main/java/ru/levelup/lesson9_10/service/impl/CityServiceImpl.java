package ru.levelup.lesson9_10.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.levelup.lesson9_10.dto.CityDto;
import ru.levelup.lesson9_10.entity.City;
import ru.levelup.lesson9_10.entity.Region;
import ru.levelup.lesson9_10.repository.CityRepository;
import ru.levelup.lesson9_10.service.CityService;
import ru.levelup.lesson9_10.service.RegionService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;

    private final RegionService regionService;

    @Override
    public List<City> findByNameRu(String nameRu) {
        return cityRepository.findByNameRu(nameRu);
    }

    public CityDto findById(Integer id) {
        City city = cityRepository.findById(id).get();
        return new CityDto(city.getId(), city.getNameRu(), city.getNameEn(), city.getPopulation(), city.getRegion().getName());
    }

    @Override
    public List<City> findByNameRuAndPopulation(String nameRu, Integer population) {
        return cityRepository.findByNameRuAndPopulation(nameRu, population);
    }

    @Override
    @Transactional
    public CityDto create(CityDto cityDto) {
        System.out.println(cityDto);
        Region region = regionService.findByName(cityDto.getRegionName());
        City city = new City(cityDto.getId(), cityDto.getNameRu(), cityDto.getNameEn(),
                cityDto.getPopulation(), region);
        return save(city);
    }

    @Override
    public List<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    @Transactional
    public CityDto save(City city) {
        City updatedCity = cityRepository.save(city);
        return new CityDto(updatedCity.getId(), updatedCity.getNameRu(), updatedCity.getNameEn(),
                updatedCity.getPopulation(), updatedCity.getRegion().getName());
    }

    @Override
    @Transactional
    public CityDto updatePopulation(Integer id, Integer population){
        City city = cityRepository.findById(id).get();
        city.setPopulation(population);
        return save(city);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void deleteById(Integer id) {
        cityRepository.deleteById(id);
    }
}
