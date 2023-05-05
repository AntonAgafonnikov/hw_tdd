package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class PhoneBookTest {
    private static final PhoneBook phoneBook = new PhoneBook();

    @BeforeAll
    public static void fillPhoneBook() {
        phoneBook.add("Kim", "+79991111111");
        phoneBook.add("Rick", "+70000000000");
        phoneBook.add("Todd", "+77777777777");
    }

    @ParameterizedTest
    @MethodSource("parametersMethodTestAdd")
    public void testAdd(String name, String phoneNumber, int expected) {
        //Act
        int executable = phoneBook.add(name, phoneNumber);

        //Assert
        Assertions.assertEquals(expected, executable);
    }

    @ParameterizedTest
    @MethodSource("parametersMethodTestFindByNumber")
    public void testFindByNumber(String phoneNumber, String expected) {
        //Act
        String executable = phoneBook.findByNumber(phoneNumber);

        //Assert
        Assertions.assertEquals(expected, executable);
    }

    @ParameterizedTest
    @MethodSource("parametersMethodTestFindByName")
    public void testFindByName(String name, String expected) {
        //Act
        String executable = phoneBook.findByName(name);

        //Assert
        Assertions.assertEquals(expected, executable);
    }

    public static Stream<Arguments> parametersMethodTestAdd() {
        return Stream.of(
                Arguments.of("Kate", "+79998887766", 4),
                Arguments.of("Dan", "+71112223344", 5),
                Arguments.of("Dan", "+75556667766", 5),
                Arguments.of("Leo", "+73332221100", 6)
        );
    }

    public static Stream<Arguments> parametersMethodTestFindByNumber() {
        return Stream.of(
                Arguments.of("+79991111111", "Kim"),
                Arguments.of("+70000000000", "Rick"),
                Arguments.of("+75556667766", "ОШИБКА! Контакт не найден!"),
                Arguments.of("+77777777777", "Todd")
        );
    }

    public static Stream<Arguments> parametersMethodTestFindByName() {
        return Stream.of(
                Arguments.of("Kim", "+79991111111"),
                Arguments.of("Rick", "+70000000000"),
                Arguments.of("John", "ОШИБКА! Контакт не найден!"),
                Arguments.of("Todd", "+77777777777")
        );
    }
}
