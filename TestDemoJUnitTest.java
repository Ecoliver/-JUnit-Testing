package com.promineotech;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;
import org.mockito.Mockito;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class TestDemoJUnitTest {

    private TestDemo testDemo;

    @BeforeEach
    public void setUp() {
        testDemo = new TestDemo();
    }

    @Test
    void assertThatTwoPositiveNumbersAreAddedCorrectly() {
        assertThat(testDemo.addPositive(4, 5)).isEqualTo(9);
        assertThat(testDemo.addPositive(40, 50)).isEqualTo(90);
    }

    @Test
    void assertThatMultiplicationIsCorrect() {
        assertThat(testDemo.multiply(4, 5)).isEqualTo(20);
        assertThat(testDemo.multiply(10, 3)).isEqualTo(30);
    }

    @Test
    void assertThatNumberSquaredIsCorrect() {
        TestDemo mockedDemo = Mockito.spy(testDemo);
        Mockito.doReturn(5).when(mockedDemo).getRandomInt();

        int fiveSquared = mockedDemo.randomNumberSquared();

        assertThat(fiveSquared).isEqualTo(25);
    }

    @Test
    void assertThatTwoPositiveNumbersAreAddedCorrectly_Param() {
        assertThatTwoPositiveNumbersAreAddedCorrectly(2, 4, 6, false);
        assertThatTwoPositiveNumbersAreAddedCorrectly(0, 4, 0, true);
        assertThatTwoPositiveNumbersAreAddedCorrectly(2, -4, 0, true);
        assertThatTwoPositiveNumbersAreAddedCorrectly(-2, -4, 0, true);
    }

    private void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
        if (!expectException) {
            assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
        } else {
            assertThatThrownBy(() ->
                    testDemo.addPositive(a, b))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
        assertThat(testDemo.addPositive(4, 5)).isEqualTo(9);
        assertThat(testDemo.addPositive(40, 50)).isEqualTo(90);
    }

    public static Stream<Arguments> argumentsForAddPositive() {
        return Stream.of(
                arguments(2, 4, 6, false),
                arguments(0, 4, 0, true),
                arguments(2, -4, 0, true),
                arguments(-2, -4, 0, true)
        );
    }

    @Test
    void assertThatPairsOfPositiveNumbersAreAddedCorrectly_Param() {
        assertThatPairsOfPositiveNumbersAreAddedCorrectly(2, 4, 6, false);
        assertThatPairsOfPositiveNumbersAreAddedCorrectly(0, 4, 0, true);
        assertThatPairsOfPositiveNumbersAreAddedCorrectly(2, -4, 0, true);
        assertThatPairsOfPositiveNumbersAreAddedCorrectly(-2, -4, 0, true);
    }

    private void assertThatPairsOfPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
        if (!expectException) {
            assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
        } else {
            assertThatThrownBy(() ->
                    testDemo.addPositive(a, b))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
 