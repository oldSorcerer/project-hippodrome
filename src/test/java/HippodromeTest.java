import org.junit.jupiter.api.Test;

import java.util.List;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class HippodromeTest {

    @Test
    void testConstructor_ShouldThrowIllegalArgumentEx_WhenArgsNull() {
        assertThrows(IllegalArgumentException.class, () -> new Hippodrome(null));
    }

    @Test
    void testConstructor_ShouldThrowExTextMessage_WhenArgsNull() {
        String expectedExceptionMessage = "Horses cannot be null.";

        var exception = assertThrows(IllegalArgumentException.class, () -> new Hippodrome(null));
        assertEquals(expectedExceptionMessage, exception.getMessage());
    }

    @Test
    void testConstructor_ShouldThrowIllegalArgumentEx_WhenArgsListIsEmpty() {
        assertThrows(IllegalArgumentException.class, () -> new Hippodrome(List.of()));
    }

    @Test
    void testConstructor_ShouldThrowExTextMessage_WhenArgsListIsEmpty() {
        String expectedExceptionMessage = "Horses cannot be empty.";

        var exception = assertThrows(IllegalArgumentException.class, () -> new Hippodrome(List.of()));
        assertEquals(expectedExceptionMessage, exception.getMessage());
    }

    @Test
    void testGetHorses_ShouldListFor30Horse_WhenPassListFor30Horse() {
        var horses = IntStream.range(0, 30).mapToObj(i -> new Horse("Zephyr " + i, i, i)).toList();

        Hippodrome hippodrome = new Hippodrome(horses);

        assertEquals(horses, hippodrome.getHorses());
//        assertSame(horses, hippodrome.getHorses());
    }

    @Test
    void testMove_ShouldCallMethodMove_WhenPassListFor50MockHorse() {
        var horses = IntStream.range(0, 50).mapToObj(i -> mock(Horse.class)).toList();

        new Hippodrome(horses).move();

        horses.forEach(horse -> verify(horse, times(1)).move());
    }

    @Test
    void testGetWinner_ShouldHorse_WhenLongestDistance() {
        Horse horse1 = new Horse("Blaze", 1, 10);
        Horse horse2 = new Horse("Lobster", 2, 20);
        Horse horse3 = new Horse("Pegasus", 3, 30);

        Hippodrome hippodrome = new Hippodrome(List.of(horse1, horse2, horse3));

        assertSame(horse3, hippodrome.getWinner());
    }
}
//test{Method}_Should{Do}_When{Condition}