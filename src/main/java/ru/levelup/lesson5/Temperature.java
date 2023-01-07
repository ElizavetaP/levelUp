package ru.levelup.lesson5;

import lombok.Data;
import ru.levelup.lesson5.enums.Units;

@Data
public class Temperature {

    private final Double degrees;
    private final Units units;

}
