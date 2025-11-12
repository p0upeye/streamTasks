package task6;

import java.util.List;

public class AdvancedStreams {
    private final String PREFIX_TO_FILTER = "J";

    public String getPrefixToFilter() {
        return PREFIX_TO_FILTER;
    }

    /**
     * Фільтрує назви курсів за префіксом і виводить їх у консоль.
     * @param courses список назв курсів
     * */
    public void filterCoursesStartingWith(List<String> courses) {
        List<String> jCourses = courses.stream()
                .filter(c -> c.startsWith(PREFIX_TO_FILTER))
                .toList();
        System.out.println(jCourses);
    }

    /**
     * З'єднує назви курсів, що починаються з певного префікса, в один рядок розділений комами і виводить у консоль.
     * @param courses список назв курсів
     * */
    public void connectCoursesToString(List<String> courses) {
        String joinedCourses = courses.stream()
                .filter(c -> c.startsWith(PREFIX_TO_FILTER))
                .reduce((a, b) -> a + ", " + b)
                .orElse("");
        System.out.println(joinedCourses);
    }

    /**
     * Рахує загальну кількість символів у назвах курсів, що починаються з певного префікса, і виводить у консоль.
     * @param courses список назв курсів
     * */
    public void countTotalCharactersInCourses(List<String> courses) {
        int totalChars = courses.stream()
                .filter(c -> c.startsWith(PREFIX_TO_FILTER))
                .mapToInt(String::length)
                .sum();
        System.out.println("Total characters: " + totalChars);
    }
}
