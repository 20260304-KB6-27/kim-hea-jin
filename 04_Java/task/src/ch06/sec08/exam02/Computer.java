package ch06.sec08.exam02;

import java.util.Arrays;

public class Computer {
    int sum(int... values) {
        return Arrays.stream(values).sum();
    }
}
