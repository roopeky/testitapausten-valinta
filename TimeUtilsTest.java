import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TimeUtilsTest {

    private final TimeUtils timeUtils = new TimeUtils();

    @ParameterizedTest(name = "Sekunnit {0} muunnetaan muotoon {1}")
    @CsvSource({ "3665, 1:01:05", "3600, 1:00:00", "36000, 10:00:00", "-1, -1" })
    public void testSecToTime(int seconds, String expectedTime) {
        String message = "Sekuntien muuntaminen epäonnistui oikealla syötteellä.";

        String result = timeUtils.secToTime(seconds);

        assertEquals(expectedTime, result, message);
    }

    @Test
    public void testSecToTimeWithInvalidInput() {
        int invalidSeconds = 40000;
        String expectedErrorMessage = "-1";

        String result = timeUtils.secToTime(invalidSeconds);

        assertEquals(expectedErrorMessage, result, "Odottamaton virheilmoitus suurella sekuntimäärällä.");
    }
}