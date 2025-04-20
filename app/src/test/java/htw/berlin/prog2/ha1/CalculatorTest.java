package htw.berlin.prog2.ha1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Retro calculator")
class CalculatorTest {

    @Test
    @DisplayName("should display result after adding two positive multi-digit numbers")
    void testPositiveAddition() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "40";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display result after getting the square root of two")
    void testSquareRoot() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressUnaryOperationKey("√");

        String expected = "1.41421356";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display error when dividing by zero")
    void testDivisionByZero() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(7);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display error when drawing the square root of a negative number")
    void testSquareRootOfNegative() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(7);
        calc.pressNegativeKey();
        calc.pressUnaryOperationKey("√");

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }


    //TODO hier weitere Tests erstellen

    ///  Grüner Test.
    @Test
    @DisplayName("muss erfolgreich teilen")
    // Grüner Test
    void testTeilen() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(8);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(2);
        calc.pressEqualsKey();
        String expected = "4";
        String actual = calc.readScreen();
        assertEquals(expected, actual);
    }

    ///  Roter Test.
    @Test
    @DisplayName("muss den Prozess bis zum Ende durchführen")
    void testMultipleDecimalDots() {
        Calculator calc = new Calculator();
        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(1);
        calc.pressDigitKey(0);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressEqualsKey();
        //  calc.pressBinaryOperationKey("+");

        String expected = "70";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

 // ROTER TEST .
    @Test
    @DisplayName("muss Dezimale Zahlen erfolgreich addieren")
    void testDecimalAdditionPrecision() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(3);
        calc.pressDotKey();
        calc.pressDigitKey(1); // 1.1
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(4);
        calc.pressDotKey();
        calc.pressDigitKey(2); // 2.2
        calc.pressEqualsKey();

        String expected = "7.3";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }
}
