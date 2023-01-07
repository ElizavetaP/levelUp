package ru.levelup.lesson4;

import lombok.Data;
import lombok.experimental.UtilityClass;

import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Data
@UtilityClass
public class ThousandRandom {
    public IntStream getRandomStream() {
        return IntStream.iterate(0, i -> 0)
                .limit(1000)
                .map(i -> new Random().nextInt(1000));
    }

    public int getMax(IntStream stream) {
        return stream.max().orElseThrow();
    }

    public int getMin(IntStream stream) {
        return stream.min().orElseThrow();
    }

    public double getAverage(IntStream stream) {
        return stream.average().orElseThrow();
    }

    public long getSumOfOdd(IntStream stream) {
        return stream.peek(System.out::println)
                .reduce(0, (a, b) -> {
                    if (b % 2 > 0) {
                        return a + b;
                    }
                    return a;
                });
    }

    public Map<Integer, Integer> getMap(IntStream stream) {
        return stream.boxed().distinct().collect(Collectors.toMap(Function.identity(), i -> {
            int result = 0;
            while (i > 0) {
                result = result + i % 10;
                i = i / 10;
            }
            return result;
        }));
    }

}
