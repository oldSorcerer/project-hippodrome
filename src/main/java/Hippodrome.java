import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Objects.isNull;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class Hippodrome {

    List<Horse> horses;

    public Hippodrome(List<Horse> horses) {
        if (isNull(horses)) {
            throw new IllegalArgumentException("Horses cannot be null.");
        } else if (horses.isEmpty()) {
            throw new IllegalArgumentException("Horses cannot be empty.");
        }
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return Collections.unmodifiableList(horses);
    }

    public void move() {
        horses.forEach(Horse::move);
    }

    public Horse getWinner() {
        return horses.stream()
                .max(Comparator.comparing(Horse::getDistance))
                .orElseThrow();
    }
}
