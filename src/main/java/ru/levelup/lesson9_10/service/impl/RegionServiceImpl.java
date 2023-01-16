package ru.levelup.lesson9_10.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.levelup.lesson9_10.entity.Region;
import ru.levelup.lesson9_10.repository.RegionRepository;
import ru.levelup.lesson9_10.service.RegionService;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RegionServiceImpl implements RegionService {

    private final RegionRepository regionRepository;

    @Override
    @Transactional
    public Region save(Region region) {
        return regionRepository.save(region);
    }

    @Override
    public Region findByName(String name){
        return regionRepository.findByName(name);
    };

}
