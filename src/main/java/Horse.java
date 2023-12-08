import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

import static java.util.Objects.isNull;

@Slf4j
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Horse {

    final String name;
    final double speed;
    double distance;

    public Horse(String name, double speed, double distance) {
        if (isNull(name)) {
            log.error("Name is null");
            throw new IllegalArgumentException("Name cannot be null.");
        } else if (name.isBlank()) {
            log.error("Name is blank");
            throw new IllegalArgumentException("Name cannot be blank.");
        }
        if (speed < 0) {
            log.error("Speed is negative");
            throw new IllegalArgumentException("Speed cannot be negative.");
        }
        if (distance < 0) {
            log.error("Distance is negative");
            throw new IllegalArgumentException("Distance cannot be negative.");
        }

        this.name = name;
        this.speed = speed;
        this.distance = distance;
        log.debug("Создание Horse, имя [{}], скорость [{}]", name, speed);
    }

    public Horse(String name, double speed) {
        this(name, speed, 0);
    }

    public void move() {
        distance += speed * getRandomDouble(0.2, 0.9);
    }

    public static double getRandomDouble(double min, double max) {
        return new Random().nextDouble(min, max);
//        return (Math.random() * (max - min)) + min;
    }
}
