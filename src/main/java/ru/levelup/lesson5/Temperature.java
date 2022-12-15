package ru.levelup.lesson5;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.levelup.lesson5.enums.Units;

@Data
@AllArgsConstructor
public class Temperature {

    private Double degrees;
    private Units units;

}
