package task5;

import java.util.List;
import java.util.Optional;

public class ReduceOptional {
    private final int NUMBER_THRESHOLD = 1;

    public int getNumberThreshold() {
        return NUMBER_THRESHOLD;
    }

    /**
     * Обчислює суму значень у списку та виводить її у консоль.
     * @param values список цілих чисел.
     * */
    public void sumOfValues(List<Integer> values) {
        Optional<Integer> sum = values.stream()
                .reduce(Integer::sum);
        sum.ifPresent(System.out::println);
    }

    /**
     * Знаходить мінімальне та максимальне значення у списку та виводить їх у консоль.
     * @param values список цілих чисел.
     * */
    public void minAndMaxValues(List<Integer> values) {
        Optional<Integer> min = values.stream()
                .reduce(Integer::min);

        Optional<Integer> max = values.stream()
                .reduce(Integer::max);

        min.ifPresent(minValue -> System.out.println("Min value: " + minValue));
        max.ifPresent(maxValue -> System.out.println("Max value: " + maxValue));
    }

    /**
     * Знаходить перше та будь-яке значення, що перевищує заданий поріг, та виводить їх у консоль.
     * @param values список цілих чисел.
     * */
    public void findFirstAndAnyGreaterThan(List<Integer> values) {
        Optional<Integer> first = values.stream()
                .filter(v -> v > NUMBER_THRESHOLD)
                .findFirst();

        Optional<Integer> any = values.stream()
                .filter(v -> v > NUMBER_THRESHOLD)
                .findAny();

        first.ifPresent(firstValue ->
                System.out.println("First value greater than " + NUMBER_THRESHOLD + ": " + firstValue));
        any.ifPresent(anyValue ->
                System.out.println("Any value greater than " + NUMBER_THRESHOLD + ": " + anyValue));
    }
}
