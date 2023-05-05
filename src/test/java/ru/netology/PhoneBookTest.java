package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class PhoneBookTest {
    @ParameterizedTest
    @MethodSource("parametersMethodTestAdd")
    public void testAdd(String name, String phoneNumber, int expected) {
        //Act
        int executable = PhoneBook.add(name, phoneNumber);

        //Assert
        Assertions.assertEquals(expected, executable);
    }

    public static Stream<Arguments> parametersMethodTestAdd() {
        return Stream.of(
                Arguments.of("Kate", "+79998887766", 1),
                Arguments.of("Dan", "+71112223344", 2),
                Arguments.of("Dan", "+75556667766", 2),
                Arguments.of("Leo", "+73332221100", 3)
        );
    }

    @ParameterizedTest
    @MethodSource("parametersMethodTestFindByNumber")
    public void testFindByNumber(String phoneNumber, String expected) {
        //Act
        String executable = PhoneBook.findByNumber(phoneNumber);

        //Assert
        Assertions.assertEquals(expected, executable);
    }

    public static Stream<Arguments> parametersMethodTestFindByNumber() {
        return Stream.of(
                Arguments.of("+79998887766", "Kate"),
                Arguments.of("+71112223344", "Dan"),
                Arguments.of("+75556667766", "ОШИБКА!"),
                Arguments.of("+73332221100", "Leo")
        );
    }
}
