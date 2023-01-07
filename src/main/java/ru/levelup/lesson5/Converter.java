package ru.levelup.lesson5;

import ru.levelup.lesson5.enums.Units;

public interface Converter {

    Double convert(Temperature temperature, Units toUtils);
}
