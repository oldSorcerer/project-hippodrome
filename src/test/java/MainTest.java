import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    @Disabled
    @Timeout(value = 21)
    void timeout() throws Exception {
        Main.main(null);
    }
}