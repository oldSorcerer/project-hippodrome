import lombok.AccessLevel;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
class HorseTest {

    String name = "Zephyr";
    int speed = 10;
    double distance = 10;

    @Test
    void testConstructor_ShouldThrowIllegalArgumentEx_WhenArgsNameIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new Horse(null, speed));
    }

    @Test
    void testConstructor_ShouldThrowExTextMessage_WhenArgsNameIsNull() {
        String expectedExceptionMessage = "Name cannot be null.";

        var exception = assertThrows(IllegalArgumentException.class, () -> new Horse(null, speed));
        assertEquals(expectedExceptionMessage, exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "\t", "\n", "\f", "\r"})
    void testConstructor_ShouldThrowIllegalArgumentEx_WhenArgsNameIsBlank(String name) {
        assertThrows(IllegalArgumentException.class, () -> new Horse(name, speed));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "\t", "\n", "\f", "\r"})
    void testConstructor_ShouldThrowExTextMessage_WhenArgsNameIsBlank(String name) {
        String expectedExceptionMessage = "Name cannot be blank.";

        var exception = assertThrows(IllegalArgumentException.class, () -> new Horse(name, speed));
        assertEquals(expectedExceptionMessage, exception.getMessage());
    }

    @Test
    void testConstructor_ShouldThrowIllegalArgumentEx_WhenArgsSpeedIsNegative() {
        assertThrows(IllegalArgumentException.class, () -> new Horse(name, -speed));
    }

    @Test
    void testConstructor_ShouldThrowExTextMessage_WhenArgsSpeedIsNegative() {
        String expectedExceptionMessage = "Speed cannot be negative.";

        var exception = assertThrows(IllegalArgumentException.class, () -> new Horse(name, -speed));
        assertEquals(expectedExceptionMessage, exception.getMessage());
    }

    @Test
    void testConstructor_ShouldThrowIllegalArgumentEx_WhenArgsDistanceIsNegative() {
        assertThrows(IllegalArgumentException.class, () -> new Horse(name, speed, -distance));
    }

    @Test
    void testConstructor_ShouldThrowExTextMessage_WhenArgsDistanceIsNegative() {
        String expectedExceptionMessage = "Distance cannot be negative.";

        var exception = assertThrows(IllegalArgumentException.class, () -> new Horse(name, speed, -distance));
        assertEquals(expectedExceptionMessage, exception.getMessage());
    }

    @Test
    void testGetName_ShouldReturnName_WhenArgsInConstructorIsName() {
        assertEquals("Zephyr", new Horse(name, speed).getName());
    }

    @Test
    void testGetSpeed_ShouldReturnSpeed_WhenArgsInConstructorIsSpeed() {
        assertEquals(10, new Horse(name, speed).getSpeed());
    }

    @Test
    void testGetDistance_ShouldReturnDistance_WhenArgsInConstructorIsDistance() {
        assertEquals(10, new Horse(name, speed, distance).getDistance());
    }

    @Test
    void testGetDistance_ShouldReturnZero_WhenConstructorPassTwoArgs() {
        assertEquals(0, new Horse(name, speed).getDistance());
    }

    @Test
    @SneakyThrows
    void testGetName_ShouldReturnName_WhenArgsInConstructorIsName_UsingReflection() {
        String expectedName = "Zephyr";

        Horse horse = new Horse(name, speed);

        Field field = Horse.class.getDeclaredField("name");
        field.setAccessible(true);
        String actualName = (String) field.get(horse);

        assertEquals(expectedName, actualName);
    }

    @Test
    @SneakyThrows
    void testGetSpeed_ShouldReturnSpeed_WhenArgsInConstructorIsSpeed_UsingReflection() {
        double expectedSpeed = 10;

        Horse horse = new Horse(name, speed);

        Field field = Horse.class.getDeclaredField("speed");
        field.setAccessible(true);
        double actualSpeed = (double) field.get(horse);

        assertEquals(expectedSpeed, actualSpeed);
    }

    @Test
    @SneakyThrows
    void testGetDistance_ShouldReturnDistance_WhenArgsInConstructorIsDistance_UsingReflection() {
        double expectedDistance = 10;

        Horse horse = new Horse(name, speed, distance);

        Field field = Horse.class.getDeclaredField("distance");
        field.setAccessible(true);
        double actualDistance = (double) field.get(horse);

        assertEquals(expectedDistance, actualDistance);
    }

    @Test
    @SneakyThrows
    void testGetDistance_ShouldReturnZero_WhenConstructorPassTwoArgs_UsingReflection() {
        double expectedDistance = 0;

        Horse horse = new Horse(name, speed);

        Field field = Horse.class.getDeclaredField("distance");
        field.setAccessible(true);
        double actualDistance = (double) field.get(horse);

        assertEquals(expectedDistance, actualDistance);
    }

    @Test
    void testMove_ShouldInvokeGetRandomDouble_WhenGetRandomDoubleArgs0dot2And0dot9() {
        try (MockedStatic<Horse> mockStatic = Mockito.mockStatic(Horse.class)) {

            new Horse(name, speed, distance).move();

            mockStatic.verify(() -> Horse.getRandomDouble(0.2, 0.9));
        }
    }

    @ParameterizedTest
    @ValueSource(doubles = {0, 0.2, 0.5, 0.7, 1, 10})
    void testMove_ShouldAssignValue_WhenGetRandomDoubleArgs0dot2And0dot9(double fakeValue) {
        Horse horse = new Horse(name, speed, distance);

        double expectedDistance = horse.getDistance() + horse.getSpeed() * fakeValue;

        try (MockedStatic<Horse> mockStatic = Mockito.mockStatic(Horse.class)) {

            mockStatic.when(() -> Horse.getRandomDouble(0.2, 0.9)).thenReturn(fakeValue);

            horse.move();

            double actualDistance = horse.getDistance();

            assertEquals(expectedDistance, actualDistance);
        }
    }
}
//test{Method}_Should{Do}_When{Condition}