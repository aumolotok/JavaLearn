package main.parser;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runner.RunWith;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


class PersonValidatorTest {

    static PersonValidator validator;

    @BeforeAll
    public static void before(){
        validator = new PersonValidator();
    }

    @ParameterizedTest
    @MethodSource("provideStringsForIsBlank")
    void isValidPersonString(String string, boolean exResult) {
        Boolean result  = validator.isValidPersonString(string);
        assertEquals(result, exResult, "String validation for string: " + string + " are not" + exResult);
    }

    private static Stream<Arguments> provideStringsForIsBlank() {
        return Stream.of(
                Arguments.of("Иванов | Петя | Информатика | 1", true),
                Arguments.of("Иванов | Петя | Информатика |1", true),
                Arguments.of("Иванов | Петя | Информатика| 1", true),
                Arguments.of("Иванов|Петя|Информатика|1", true),
                Arguments.of("Иванов | Петя |Информатика | ", false),
                Arguments.of("Иванов | Петя | | 1", false),
                Arguments.of(" | Петя |Информатика | 1", false)
        );
    }
}