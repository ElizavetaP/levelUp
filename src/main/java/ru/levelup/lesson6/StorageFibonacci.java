package ru.levelup.lesson6;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@ConditionalOnProperty(name = "levelup.isSaveFibonacci", havingValue = "true")
public class StorageFibonacci {
    Map<Integer, Long> fibonacciMap = new HashMap<>();

}
