package ru.levelup.lesson6;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class FibonacciGenerator {

    @Autowired(required = false)
    StorageFibonacciImpl storageFibonacci;

    @Value("${levelup.isSaveFibonacci}")
    private boolean isSaveFibonacci;

    public Long nextAmount(Integer number) {
        if (isSaveFibonacci) {
            Long fibonacci = storageFibonacci.getFibonacci(number);
            if (fibonacci > 0) {
                return fibonacci;
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
            storageFibonacci.putFibonacci(number, amount);
        }
        return amount;
    }
}
