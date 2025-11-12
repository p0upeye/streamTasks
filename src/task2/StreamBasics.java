package task2;

import java.util.List;

public class StreamBasics {

    /**
     * Stream API: Читабельніший та компактніший код. Написання займає менше часу (можливо так лише у мене).
     * */
    public void streamSolutions(List<Integer> numbers) {
        System.out.print("1. Only even numbers: ");
        numbers.stream()
                .filter(n -> n % 2 == 0)
                .forEach(n -> System.out.print(n + " "));
        System.out.println();

        System.out.print("2. Squares of all numbers: ");
        List<Integer> squared = numbers.stream()
                .map(n -> n * n)
                .toList();
        System.out.println(squared);

        System.out.print("3. Sum of all numbers: ");
        int sumOfSquares = squared.stream()
                .reduce(0, Integer::sum);
        System.out.println(sumOfSquares);
    }

    /**
     * For-loop: Більше коду, проте інтуїтивно зрозумілий для новачків
     * + контроль над процесом.
     * */
    public void forLoopSolutions(List<Integer> numbers) {
        System.out.print("1. Only even numbers: ");
        for(Integer n : numbers) {
            if(n % 2 == 0) {
                System.out.print(n + " ");
            }
        }
        System.out.println();

        System.out.print("2. Squares of all numbers: ");
        List<Integer> squared = new java.util.ArrayList<>();

        for(Integer n : numbers) {
            squared.add(n * n);
        }
        System.out.println(squared);

        System.out.print("3. Sum of all numbers: ");
        int sumOfSquares = 0;

        for(Integer n : squared) {
            sumOfSquares += n;
        }
        System.out.println(sumOfSquares);
    }
}
