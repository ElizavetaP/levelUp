package ru.levelup.lesson5.impl;

import org.springframework.stereotype.Component;
import ru.levelup.lesson5.Converter;
import ru.levelup.lesson5.Temperature;
import ru.levelup.lesson5.enums.Units;

@Component
public class ConverterImpl implements Converter {
    @Override
    public Double convert(Temperature temperature, Units toUtils) {
        Double kelvins = convertToKelvins(temperature);
        if (Units.CELSIUS.equals(toUtils)) {
            return kelvins - 273.15;
        } else if (Units.FAHRENHEIT.equals(toUtils)) {
            return 9 * (kelvins - 273.15) / 5 + 32;
        }
        return kelvins;
    }

    private Double convertToKelvins(Temperature temperature) {
        Double degrees = temperature.getDegrees();
        if (Units.CELSIUS.equals(temperature.getUnits())) {
            return (degrees + 273.15);
        } else if (Units.FAHRENHEIT.equals(temperature.getUnits())) {
            return 5 * (degrees - 32) / 9 + 273.15;
        }
        return degrees;
    }

}
