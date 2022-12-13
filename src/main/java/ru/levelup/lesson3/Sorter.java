package ru.levelup.lesson3;

import lombok.Data;
import lombok.experimental.UtilityClass;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Data
@UtilityClass
public class Sorter {

    public void printWords(String str) {
        Arrays.stream(str.toLowerCase().split("[,.:?; !]+"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.toList())).entrySet().stream()
                .sorted((o1, o2) -> -Integer.compare(o1.getValue().size(), o2.getValue().size()))
                .map(Map.Entry::getKey).forEach(System.out::println);

    }
}
