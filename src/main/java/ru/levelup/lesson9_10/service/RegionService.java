package ru.levelup.lesson9_10.service;

import ru.levelup.lesson9_10.entity.Region;

public interface RegionService {

    Region save(Region region);

    Region findByName(String name);
}
