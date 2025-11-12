package task3;

import task3.model.Person;

import java.util.Comparator;
import java.util.List;

public class PersonStream {
    private final int AGE_THRESHOLD = 30;
    private final String CITY_TO_CHECK = "Albuquerque";

    public int getAgeThreshold() {
        return AGE_THRESHOLD;
    }
    public String getCITY_TO_CHECK() {
        return CITY_TO_CHECK;
    }

    /**
     * Виводить усіх людей молодших за задану одиницю років.
     * @param persons список об'єктів Person.
     * */
    public void peopleYoungerThan(List<Person> persons) {
        persons.stream()
                .filter(p -> p.getAge() < AGE_THRESHOLD)
                .forEach(System.out::println);
    }

    /**
     * Виводить імена всіх людей у верхньому регістрі.
     * @param persons список об'єктів Person.
     * */
    public void namesInUppercase(List<Person> persons) {
        List<String> namesUpperCase = persons.stream()
                .map(p -> p.getName().toUpperCase())
                .toList();
        System.out.println(namesUpperCase);
    }

    /**
     * Перевіряє, чи всі люди живуть у заданому місті.
     * @param persons список об'єктів Person.
     * */
    public void doAllPeopleLiveInCity(List<Person> persons) {
        boolean allInCity = persons.stream()
                .allMatch(p -> p.getCity().toString().equalsIgnoreCase(CITY_TO_CHECK));
        System.out.println(allInCity);
    }

    /**
     * Виводить найстаршу людину зі списку.
     * @param persons список об'єктів Person.
     * */
    public void theOldestPerson(List<Person> persons) {
        persons.stream()
                .max(Comparator.comparingInt(Person::getAge))
                .ifPresent(System.out::println);
    }
}
