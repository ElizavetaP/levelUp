package ru.levelup.lesson6;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@ConditionalOnProperty(name = "levelup.isSaveFibonacci", havingValue = "true")
@Slf4j
public class StorageFibonacciImpl implements StorageFibonacci {
    Map<Integer, Long> fibonacciMap = new HashMap<>();

    @Override
    public Long getFibonacci(Integer number) {
        if (fibonacciMap.containsKey(number)) {
            log.info(String.format("взято %d-е число Фибоначчи", number));
            return fibonacciMap.get(number);
        }
        return -1L;
    }

    @Override
    public void putFibonacci(Integer number, Long amount){
        if (!fibonacciMap.containsKey(number)) {
            log.info(String.format("сохранено %d-е число Фибоначчи", number));
            fibonacciMap.put(number, amount);
        }
    }
}
