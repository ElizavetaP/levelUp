package ru.levelup.lesson9_10.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.levelup.lesson9_10.entity.Region;


public interface RegionRepository extends JpaRepository<Region, Integer> {

    Region findByName(String nameRu);
}
