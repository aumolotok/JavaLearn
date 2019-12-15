package main.parser;

import main.common.Subjects;
import main.student.Student;
import main.student.StudentAverageMarkInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import javax.print.attribute.IntegerSyntax;
import javax.security.auth.Subject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

class StudentsStatisticsTest {

    static List<Student> students1 = Arrays.asList(
            new Student("one", "one", buildMap(1)),
            new Student("two", "two", buildMap(1)),
            new Student("three", "three", buildMap(1)),
            new Student("four", "four", buildMap(2)),
            new Student("five", "five", buildMap(2)),
            new Student("six", "six", buildMap(2)),
            new Student("seven", "seven", buildMap(2)),
            new Student("eight", "eight", buildMap(3)),
            new Student("nine", "nine", buildMap(4)),
            new Student("ten", "ten", buildMap(5))
    );

    static List<StudentAverageMarkInfo> stInfo1Exp70percent = Arrays.asList(
            new StudentAverageMarkInfo("eight eight", 3.0),
            new StudentAverageMarkInfo("nine nine", 4.0),
            new StudentAverageMarkInfo("ten ten", 5.0)
    );

    static List<StudentAverageMarkInfo> stInfo1Exp60percent = Arrays.asList(
            new StudentAverageMarkInfo("four four", 2.0),
            new StudentAverageMarkInfo("five five", 2.0),
            new StudentAverageMarkInfo("six six", 2.0),
            new StudentAverageMarkInfo("seven seven", 2.0),
            new StudentAverageMarkInfo("eight eight", 3.0),
            new StudentAverageMarkInfo("nine nine", 4.0),
            new StudentAverageMarkInfo("ten ten", 5.0)
    );

    static List<StudentAverageMarkInfo> stInfo1Exp10percent = Arrays.asList(
            new StudentAverageMarkInfo("four four", 2.0),
            new StudentAverageMarkInfo("five five", 2.0),
            new StudentAverageMarkInfo("six six", 2.0),
            new StudentAverageMarkInfo("seven seven", 2.0),
            new StudentAverageMarkInfo("eight eight", 3.0),
            new StudentAverageMarkInfo("nine nine", 4.0),
            new StudentAverageMarkInfo("ten ten", 5.0)
    );

    @BeforeEach
    void setUp() {
    }

    @ParameterizedTest(name = "Check results for students1 with percentage value [{2}]")
    @MethodSource("averageTestData")
    void getStudentsAverageMoreThanPersentageOfStudentsHas(List<Student> list, List<StudentAverageMarkInfo> exResultList, Double percentage) {
        StudentsStatistics statistic = new StudentsStatistics(list);

        List<StudentAverageMarkInfo> result = statistic.getStudentsAverageMoreThanPersentageOfStudentsHas(percentage);

        assertThat(result).hasSameSizeAs(exResultList);
        assertThat(result).hasSameElementsAs(exResultList);

    }

    private static Stream<Arguments> averageTestData(){
        return Stream.of(
                Arguments.of(students1, stInfo1Exp70percent, 70.0),
                Arguments.of(students1, stInfo1Exp60percent, 60.0),
                Arguments.of(students1, stInfo1Exp60percent, 20.0));
    }

    private static HashMap<Subjects, Integer> buildMap(Integer mark){
        HashMap<Subjects, Integer> map = new HashMap<>();
        Arrays.stream(Subjects.values())
                .forEach(s -> map.put(s, mark));
        return map;
    }
}