package task7;

import java.util.List;

public class ParallelStreams {

    /**
     * Обчислює суму елементів ліста за допомогою послідовного стріму та розраховує час виконання.
     * @param nums список цілих чисел
     * */
    public void sumWithStream(List<Integer> nums) {
        long startSequential = System.currentTimeMillis();
        long sumSequential = nums.stream()
                .mapToLong(Integer::longValue)
                .sum();
        long endSequential = System.currentTimeMillis();
        long timeSequential = endSequential - startSequential;

        System.out.println("Sum with stream(): " + sumSequential +
                "\nTime taken: " + timeSequential + " ms");
    }

    /**
     * Обчислює суму елементів ліста за допомогою паралельного стріму та розраховує час виконання.
     * @param nums список цілих чисел
     * */
    public void sumWithParallelStream(List<Integer> nums) {
        long startParallel = System.currentTimeMillis();
        long sumParallel = nums.parallelStream()
                .mapToLong(Integer::longValue)
                .sum();
        long endParallel = System.currentTimeMillis();
        long timeParallel = endParallel - startParallel;

        System.out.println("Sum with parallelStream(): " + sumParallel +
                "\nTime taken: " + timeParallel + " ms");
    }
}
