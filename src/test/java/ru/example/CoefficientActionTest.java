package ru.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static ru.example.model.CoefficientAction.*;


public class CoefficientActionTest {
    @Test
    void testPlus() {
        var expected = PLUS;
        var expectedString = "+";
        var actual = getCoefficientAction(expectedString);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testMinus() {
        var expected = MINUS;
        var expectedString = "-";
        var actual = getCoefficientAction(expectedString);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testOther() {
        String expected = null;
        var expectedString = "#";
        var actual = getCoefficientAction(expectedString);

        Assertions.assertEquals(expected, actual);
    }
}
