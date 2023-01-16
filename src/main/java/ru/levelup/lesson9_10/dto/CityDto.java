package ru.levelup.lesson9_10.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CityDto {

    @NotNull
    private Integer id;

    private String nameRu;

    private String nameEn;

    @Min(1)
    private Integer population;

    private String regionName;

}
