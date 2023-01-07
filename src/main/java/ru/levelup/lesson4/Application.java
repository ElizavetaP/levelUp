package ru.levelup.lesson4;

import java.util.stream.IntStream;

public class Application {
    public static void main(String[] args) {

        IntStream stream = ThousandRandom.getRandomStream();

        System.out.println("Все числа: ");
        int[] intArray = stream.peek(System.out::println).toArray();

        System.out.println("Сумма нечетных: " + ThousandRandom.getSumOfOdd(IntStream.of(intArray)));
        System.out.println("Максимальное: " + ThousandRandom.getMax(IntStream.of(intArray)));
        System.out.println("Минимальное: " + ThousandRandom.getMin(IntStream.of(intArray)));
        System.out.println("Среднее: " + ThousandRandom.getAverage(IntStream.of(intArray)));
        System.out.println("Карта значение-сумма цифр: " + ThousandRandom.getMap(IntStream.of(intArray)));

    }
}
