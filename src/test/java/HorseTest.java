import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class HorseTest {

    //test{Method}_Should{Do}_When{Condition}

    @Test
    void testConstructor_ShouldThrowIllegalArgumentEx_WhenArgsNameNull() {
        assertThrows(IllegalArgumentException.class,
                () -> new Horse(null, 10));
    }

    @Test
    void testConstructor_ShouldThrowExTextMessage_WhenArgsNameNull() {
        assertThrows(IllegalArgumentException.class,
                () -> new Horse(null, 10), "Name cannot be null."
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "\t", "\n", "\f", "\r"})
    void testConstructor_ShouldThrowIllegalArgumentEx_WhenArgsNameIsBlank(String name) {
        assertThrows(IllegalArgumentException.class,
                () -> new Horse(name, 10));
    }


    @ParameterizedTest
    @ValueSource(strings = {"", " ", "\t", "\n", "\f", "\r"})
    void testConstructor_ShouldThrowExTextMessage_WhenArgsNameIsBlank(String name) {
        assertThrows(IllegalArgumentException.class,
                () -> new Horse(name, 10), "Name cannot be blank.");
    }

    @Test
    void testConstructor_ShouldThrowIllegalArgumentEx_WhenArgsSpeedNegative() {
        assertThrows(IllegalArgumentException.class,
                () -> new Horse(null, -10));
    }

    @Test
    void testConstructor_ShouldThrowExTextMessage_WhenArgsSpeedNegative() {
        assertThrows(IllegalArgumentException.class,
                () -> new Horse(null, -10), "Speed cannot be negative.");
    }

    @Test
    void testConstructor_ShouldThrowIllegalArgumentEx_WhenArgsDistanceNegative() {
        assertThrows(IllegalArgumentException.class,
                () -> new Horse(null, 10, -10));
    }


    @Test
    void testConstructor_ShouldThrowExTextMessage_WhenArgsDistanceNegative() {
        assertThrows(IllegalArgumentException.class,
                () -> new Horse(null, 10, -10), "Distance cannot be negative.");
    }

    @Test
    void testGetName_ShouldReturnName_WhenArgsInConstructorIsName() {
        assertEquals("Zephyr", new Horse("Zephyr", 10).getName());
    }

    @Test
    void testGetSpeed_ShouldReturnSpeed_WhenArgsInConstructorIsSpeed() {
        assertEquals(10, new Horse("Zephyr", 10).getSpeed());
    }

    @Test
    void testGetDistance_ShouldReturnDistance_WhenArgsInConstructorIsDistance() {
        assertEquals(10, new Horse("Zephyr", 0, 10).getDistance());
    }

    @Test
    void move() {
    }
}