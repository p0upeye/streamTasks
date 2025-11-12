package task1;

import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalDemo {

    /**
     * Перевіряє, чи починається рядок з великої літери.
     * */
    public Predicate<String> startsWithUpperCase = str ->
            str != null && !str.isEmpty() &&
                    Character.isUpperCase(str.charAt(0));

    /**
     * Повертає довжину рядка.  */
    public Function<String, Integer> getStringLength = str ->
            str != null ? str.length() : 0;

    /**
     * Повертає випадкове число типу Double.
     * */
    public Supplier<Double> randomSupplier = () ->
            new Random().nextDouble();

    /**
     * Виводить рядок у верхньому регістрі.
     * */
    public Consumer<String> printUpperCase = str ->
            System.out.println(str.toUpperCase());
}
