package qDebuggingAndUnitTesting.xChallenges;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

class UtilitiesTest {

    private Utilities utilities;

    @BeforeEach
    public void setup(){
        utilities = new Utilities();
        System.out.println("Running a test...");
    }

    @AfterEach
    public void exit(){
        System.out.println("Exiting test...");
    }

    @ParameterizedTest
    @MethodSource("everyNthCharParameters")
    void everyNthChar(int n, char[] output, char[] input) {
        assertArrayEquals(output, utilities.everyNthChar(input,n));
    }

    @ParameterizedTest
    @MethodSource("removePairsParameters")
    void removePairs(String input, String output) {
        assertEquals(output,utilities.removePairs(input),"Result is not as expected.");
    }

    @Test
    void removePairsNull(){
        assertNull(null, utilities.removePairs(null));
    }

    @ParameterizedTest
    @MethodSource("converterParameters")
    void converter(int a, int b, int expected) {
        assertEquals(expected, utilities.converter(a, b));
    }

    @Test
    void converterArithmeticException() {
        assertThrows(ArithmeticException.class, () -> utilities.converter(10, 0));
    }

    @ParameterizedTest
    @MethodSource("nullIfOddLengthParametersOdd")
    void nullIfOddLengthOdd(String input, String expected) {
        assertNull(expected, utilities.nullIfOddLength(input));
    }

    @ParameterizedTest
    @MethodSource("nullIfOddLengthParametersEven")
    void nullIfOddLengthEven(String input, String expected) {
        assertNotNull(expected, utilities.nullIfOddLength(input));
    }

    private static Stream<Arguments> removePairsParameters() {
        return Stream.of(
                Arguments.of("ABBCDEEF", "ABCDEF"),
                Arguments.of("ABCBDEEF", "ABCBDEF"),
                Arguments.of("AABBCDDEEFFGHH", "ABCDEFGH"),
                Arguments.of("A", "A"),
                Arguments.of("", ""),
                Arguments.of("112233445566", "123456")
        );
    }

    private static Stream<Arguments> everyNthCharParameters() {
        return Stream.of(
                Arguments.of(2, new char[] {'e', 'l'}, new char[] {'h','e','l','l','o'}),
                Arguments.of(6, new char[] {'h','e','l','l','o'}, new char[] {'h','e','l','l','o'})
        );
    }

    private static Stream<Arguments> nullIfOddLengthParametersOdd() {
        return Stream.of(
                Arguments.of("Ana", null),
                Arguments.of("Claudia", null),
                Arguments.of("Odd", null)
        );
    }

    private static Stream<Arguments> nullIfOddLengthParametersEven() {
        return Stream.of(
                Arguments.of("Claudita", "Claudita"),
                Arguments.of("Andrei", "Andrei"),
                Arguments.of("Even", "Even")
        );
    }

    private static Stream<Arguments> converterParameters() {
        return Stream.of(
                Arguments.of(10, 5, 300)
        );
    }
}