import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

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
    void getHorses() {
        List<Horse> horses = IntStream.range(0, 30).mapToObj(i -> new Horse("" + i, i, i)).toList();
        Hippodrome hippodrome = new Hippodrome(horses);

        assertEquals(horses, hippodrome.getHorses());
    }

    @Test
    void move() {
        List<Horse> horses = IntStream.range(0, 50).mapToObj(i -> Mockito.mock(Horse.class)).collect(Collectors.toList());

        new Hippodrome(horses).move();

        horses.forEach(horse -> Mockito.verify(horse, Mockito.times(1)).move());
    }

    @Test
    void getWinner() {

//        new Horse()
    }
}