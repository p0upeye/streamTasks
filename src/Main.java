import task1.FunctionalDemo;
import task2.StreamBasics;
import task3.model.Person;
import task3.PersonStream;
import task4.PersonCollectors;
import task5.ReduceOptional;
import task6.AdvancedStreams;
import task7.ParallelStreams;
import task8.StudentAnalytics;
import task8.model.Student;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static task3.utils.City.*;

public class Main {
    public static void main(String[] args) {
        FunctionalDemo fDemo = new FunctionalDemo();
        StreamBasics sBasics = new StreamBasics();
        PersonStream personStream = new PersonStream();
        PersonCollectors personCollectors = new PersonCollectors();
        ReduceOptional reduceOptional = new ReduceOptional();
        AdvancedStreams advancedStreams = new AdvancedStreams();
        ParallelStreams parallelStreams = new ParallelStreams();
        StudentAnalytics studentAnalytics = new StudentAnalytics(getStudents());

        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║  Lecture 5: Stream API. Functional         ║");
        System.out.println("║  Interfaces. Lambda Expressions            ║");
        System.out.println("╚════════════════════════════════════════════╝\n");

        System.out.println("——— Task #1 ———");
        String testString = "Hi there!";

        System.out.println("Starts with uppercase: " + fDemo.startsWithUpperCase.test(testString));
        System.out.println("String length: " + fDemo.getStringLength.apply(testString));
        System.out.println("Random number: " + fDemo.randomSupplier.get());
        System.out.print("Print uppercase: ");
        fDemo.printUpperCase.accept(testString);

        System.out.println("\n——— Task #2 ———");
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("Input numbers: " + numbers + "\n");

        System.out.println("Stream solutions:");
        sBasics.streamSolutions(numbers);
        System.out.println();

        System.out.println("For-loop solutions:");
        sBasics.forLoopSolutions(numbers);

        System.out.println("\n——— Task #3 ———");
        List<Person> persons = getPersons();

        System.out.println("Input persons: ");
        persons.forEach(System.out::println);
        System.out.println();

        System.out.println("1. People younger than " + personStream.getAgeThreshold() + ":");
        personStream.peopleYoungerThan(persons);
        System.out.print("2. Names in uppercase: ");
        personStream.namesInUppercase(persons);
        System.out.print("3. Do all people live in " + personStream.getCITY_TO_CHECK() + "? - ");
        personStream.doAllPeopleLiveInCity(persons);
        System.out.print("4. The oldest person: ");
        personStream.theOldestPerson(persons);

        System.out.println("\n——— Task #4 ———");
        System.out.print("1. Group people by city:");
        personCollectors.groupByCity(persons);
        System.out.println("\n2. Count people in each city:");
        personCollectors.countInEachCity(persons);
        System.out.print("\n3. List of names of people older than " + personCollectors.getAgeThreshold() + ": ");
        personCollectors.listNamesOlderThan(persons);

        System.out.println("\n——— Task #5 ———");
        List<Integer> values = Arrays.asList(3, 5, 7, 2, 8, 6);
        System.out.println("Input values: " + values);
        System.out.println();

        System.out.print("1. Sum of all values: ");
        reduceOptional.sumOfValues(values);
        System.out.println("2. Minimum and maximum values:");
        reduceOptional.minAndMaxValues(values);
        System.out.println("3. First and any value greater than " + reduceOptional.getNumberThreshold() + ":");
        reduceOptional.findFirstAndAnyGreaterThan(values);

        System.out.println("\n——— Task #6 ———");
        List<String> courses = List.of("Java", "Python", "C++", "JavaScript", "Kotlin");
        System.out.println("Input courses: " + courses);
        System.out.println();

        System.out.println("1. Courses starting with '" + advancedStreams.getPrefixToFilter() + "':");
        advancedStreams.filterCoursesStartingWith(courses);
        System.out.println("2. Connected courses string:");
        advancedStreams.connectCoursesToString(courses);
        System.out.println("3. Count total characters in filtered courses:");
        advancedStreams.countTotalCharactersInCourses(courses);

        System.out.println("\n——— Task #7 ———");
        final int SIZE = 10000000;

        List<Integer> nums = IntStream.rangeClosed(1, SIZE)
                .boxed()
                .toList();

        System.out.println("Calculating sum of " + SIZE + " numbers:");
        parallelStreams.sumWithStream(nums);
        System.out.println("Calculating sum of " + SIZE + " numbers in parallel:");
        parallelStreams.sumWithParallelStream(nums);

        System.out.println("\n——— Task #8 ———");
        List<Student> students = getStudents();
        System.out.println("Input students:");
        students.forEach(System.out::println);
        System.out.println();

        System.out.println("Average grade of all students: " + studentAnalytics.calculateAverageGrade());
        System.out.println("Group with highest average grade: " + studentAnalytics.findGroupWithHighestAverage());
        System.out.println("Top 3 students:");
        studentAnalytics.printTop3Students();
    }

    /**
     * Допоміжний метод для створення списку осіб.
     * Відноситься до Task #3 та Task #4.
     * @return Список осіб.
     * */
    private static List<Person> getPersons() {
        Person wolterWhite = new Person("Walter", 51, ALBUQUERQUE);
        Person jessePinkman = new Person("Jesse", 25, ALBUQUERQUE);
        Person saulGoodman = new Person("Saul", 41, ILLINOIS);
        Person gusFring = new Person("Gus", 44, SANTIAGO);
        Person mikeEhrmantraut = new Person("Mike", 65, LOS_ANGELES);
        Person hankSchrader = new Person("Hank", 43, ALBUQUERQUE);

        return List.of(
                wolterWhite, jessePinkman, saulGoodman,
                gusFring, mikeEhrmantraut, hankSchrader
        );
    }

    /**
     * Допоміжний метод для створення списку студентів.
     * Відноситься до Task #8.
     * @return Список студентів.
     * */
    private static List<Student> getStudents() {
        Student student1 = new Student("Olexander", 19, 8.5, "KND-22");
        Student student2 = new Student("Bogdan", 18, 9.0, "KND-21");
        Student student3 = new Student("Oleg", 21, 7.5, "KND-22");
        Student student4 = new Student("Diana", 19, 9.5, "KND-21");
        Student student5 = new Student("Sofia", 20, 8.0, "KND-24");

        return List.of(
                student1, student2, student3,
                student4, student5
        );
    }
}