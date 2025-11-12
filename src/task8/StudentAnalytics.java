package task8;

import task8.model.Student;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentAnalytics {
    private List<Student> students;

    public StudentAnalytics(List<Student> students) {
        this.students = students;
    }

    /**
     * Обчислює середній бал усіх студентів у списку.
     * @return середній бал студентів
     * */
    public double calculateAverageGrade() {
        return students.stream()
                .mapToDouble(Student::getAverageGrade)
                .average()
                .orElse(0.0);
    }

    /**
     * Знаходить групу з найвищим середнім балом.
     * Формат виводу: "Група (average point: СереднійБал)"
     * @return назва групи з найвищим середнім балом
     * */
    public String findGroupWithHighestAverage() {
        Map<String, Double> groupAverages = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getGroup,
                        Collectors.averagingDouble(Student::getAverageGrade)
                ));

        return groupAverages.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(entry -> entry.getKey() + " (average point: " +
                        String.format("%.2f", entry.getValue()) + ")")
                .orElse("");
    }

    /**
     * Виводить трьох студентів з найвищими середніми балома.
     * Формат виводу: "1. Ім'я - СереднійБал (група Група)"
     * */
    public void printTop3Students() {
        List<Student> top3 = students.stream()
                .sorted(Comparator.comparingDouble(Student::getAverageGrade).reversed())
                .limit(3)
                .toList();

        int rank = 1;
        for (Student student : top3) {
            System.out.printf("%d. %s - %.2f (група %s)%n",
                    rank++, student.getName(),
                    student.getAverageGrade(), student.getGroup());
        }
    }
}
