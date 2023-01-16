package ru.levelup.lesson9_10.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.levelup.lesson9_10.dto.CityDto;
import ru.levelup.lesson9_10.service.CityService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@Validated
public class CityController {

    private final CityService cityService;

    @GetMapping("/city/{id}")
    public CityDto getCity(@PathVariable Integer id) {
        return cityService.findById(id);
    }

    @PostMapping("/city")
    @ResponseStatus(HttpStatus.CREATED)
    public CityDto createCity(@Valid @RequestBody CityDto city) {
        return cityService.create(city);
    }

    @DeleteMapping("/city/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity deleteCity(@PathVariable Integer id) {
        cityService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/city/{id}")
    public CityDto updatePopulation(@PathVariable Integer id, @RequestParam Integer population) {
        return cityService.updatePopulation(id, population);
    }

}
