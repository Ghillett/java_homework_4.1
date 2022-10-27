import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BonusServiceTest {

    @Test
    void shouldCalculateForRegisteredAndUnderLimit() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        int amount = 1000;
        boolean registered = true;
        int expected = 30;

        // вызываем целевой метод:
        int actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForRegisteredAndOverLimit() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        int amount = 1_000_000;
        boolean registered = true;
        int expected = 500;

        // вызываем целевой метод:
        int actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForUnregisteredAndUnderLimit() {
        BonusService service = new BonusService();

        int amount = 1000;
        boolean registered = false;
        int expected = 10;

        int actual = service.calculate(amount, registered);

        Assertions.assertEquals(expected, actual);

    }

    @Test
    void shouldCalculateForUnregisteredAndOverLimit() {
        BonusService service = new BonusService();

        int amount = 1_000_000;
        boolean registered = false;
        int expected = 500;

        int actual = service.calculate(amount, registered);

        Assertions.assertEquals(expected, actual);
    }
}