import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import static java.util.Objects.isNull;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Horse {

    final String name;
    final double speed;
    double distance;

    public Horse(String name, double speed, double distance) {
        if (isNull(name)) {
            throw new IllegalArgumentException("Name cannot be null.");
        } else if (name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank.");
        }
        if (speed < 0) {
            throw new IllegalArgumentException("Speed cannot be negative.");
        }
        if (distance < 0) {
            throw new IllegalArgumentException("Distance cannot be negative.");
        }

        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }

    public Horse(String name, double speed) {
        this(name, speed, 0);
    }

    public void move() {
        distance += speed * getRandomDouble(0.2, 0.9);
    }

    public static double getRandomDouble(double min, double max) {
        return (Math.random() * (max - min)) + min;
    }
}
