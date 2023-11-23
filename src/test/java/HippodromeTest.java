import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HippodromeTest {

    @Test
    void testConstructor_ShouldThrowIllegalArgumentEx_WhenArgsNull() {
        assertThrows(IllegalArgumentException.class, () -> new Hippodrome(null));
    }

    @Test
    void testConstructor_ShouldThrowExTextMessage_WhenArgsNull() {
        assertThrows(IllegalArgumentException.class,
                () -> new Hippodrome(null), "Horses cannot be null.");
    }

    @Test
    void testConstructor_ShouldThrowIllegalArgumentEx_WhenArgsListIsEmpty() {
        assertThrows(IllegalArgumentException.class, () -> new Hippodrome(List.of()));
    }

    @Test
    void testConstructor_ShouldThrowExTextMessage_WhenArgsListIsEmpty() {
        assertThrows(IllegalArgumentException.class,
                () -> new Hippodrome(List.of()), "Horses cannot be empty.");
    }

    @Test
    void getHorses() {
    }

    @Test
    void move() {
    }

    @Test
    void getWinner() {
    }
}