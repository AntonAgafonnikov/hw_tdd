package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class PhoneBookTest {
    @ParameterizedTest
    @MethodSource("parametersMethodAddTest")
    public void testAdd(String name, String phoneNumber, int expected) {
        //Act
        int executable = PhoneBook.add(name, phoneNumber);

        //Assert
        Assertions.assertEquals(expected, executable);

    }

    public static Stream<Arguments> parametersMethodAddTest() {
        return Stream.of(
                Arguments.of("Kate", "+79998887766", 1),
                Arguments.of("Dan", "+71112223344", 2),
                Arguments.of("Dan", "+75556667766", 2),
                Arguments.of("Leo", "+73332221100", 3)
        );
    }
}
