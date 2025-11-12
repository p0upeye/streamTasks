package task4;

import task3.model.Person;
import task3.utils.City;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PersonCollectors {
    private final int AGE_THRESHOLD = 25;

    public int getAgeThreshold() {
        return AGE_THRESHOLD;
    }

    /**
     * Групує людей за містом проживання та виводить їх у консоль.
     * @param persons список об'єктів Person.
     * */
    public void groupByCity(List<Person> persons) {
        Map<City, List<Person>> byCity = persons.stream()
                .collect(Collectors.groupingBy(Person::getCity));

        byCity.forEach((city, personList) -> {
            System.out.println("\n" + city + ":");
            personList.forEach(p -> System.out.println(" - " + p.getName() + ", " + p.getAge() + " years"));
        });
    }

    /**
     * Підраховує кількість людей у кожному місті та виводить їх у консоль.
     * @param persons список об'єктів Person.
     * */
    public void countInEachCity(List<Person> persons) {
        Map<City, Long> cityCount = persons.stream()
                .collect(Collectors.groupingBy(Person::getCity, Collectors.counting()));

        cityCount.forEach((city, count) ->
                System.out.println(city + ": " + count + " " + getPeopleWord(count)));
    }

    /**
     * Виводить імена людей, старших за заданий вік, та їх загальну кількість.
     * @param persons список об'єктів Person.
     * */
    public void listNamesOlderThan(List<Person> persons) {
        List<String> namesOver25 = persons.stream()
                .filter(p -> p.getAge() > AGE_THRESHOLD)
                .map(Person::getName)
                .collect(Collectors.toList());

        System.out.println(namesOver25);
        System.out.println("Total: " + namesOver25.size() + " " + getPeopleWord(namesOver25.size()));
    }

    /**
     * Допоміжний метод для правильного відображення слова "person/people".
     * @param count Кількість осіб.
     * @return "person", якщо count == 1, і "people" в інших випадках.
     * */
    private static String getPeopleWord(long count) {
        if(count == 1) {
            return "person";
        }
        else {
            return "persons";
        }
    }
}
