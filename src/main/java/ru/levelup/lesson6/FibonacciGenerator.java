package ru.levelup.lesson6;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class FibonacciGenerator {

    @Autowired(required = false)
    StorageFibonacci storageFibonacci;

    @Value("${levelup.isSaveFibonacci}")
    private boolean isSaveFibonacci;

    public Long nextAmount(Integer number) {
        if (isSaveFibonacci) {
            if (storageFibonacci.fibonacciMap.containsKey(number)) {
                log.info(String.format("взято %d-е число Фибоначчи", number));
                return storageFibonacci.fibonacciMap.get(number);
            }
        }

        long amount;
        if (number == 2) {
            amount = 1L;
        } else if (number == 1) {
            amount = 0L;

        } else {
            amount = nextAmount(number - 2) + nextAmount(number - 1);
        }
        if (isSaveFibonacci) {
            if (!storageFibonacci.fibonacciMap.containsKey(number)){
                log.info(String.format("сохранено %d-е число Фибоначчи", number));
                storageFibonacci.fibonacciMap.put(number, amount);
            }
        }
        return amount;
    }
}
