import java.time.LocalDate;

import org.example.Main;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class CATestCases {

    @Test
    void testUTMLinkGeneration() {
        String caName = "Alex Carter";
        Main.UTMData utm = new Main.UTMData(caName);

        LocalDate today = LocalDate.now();
        String expectedCampaign = "IAC_CA_" + today.getYear() + "_" + String.format("%02d", today.getMonthValue());

        assertNotNull(utm.utmLink);
        assertTrue(utm.utmSource.equals("Alex_Carter"));
        assertTrue(utm.utmMedium.equals("ambassador"));
        assertTrue(utm.utmCampaign.equals(expectedCampaign));
        assertTrue(utm.utmLink.contains("utm_source=Alex_Carter"));
        assertTrue(utm.utmLink.contains("utm_campaign=" + expectedCampaign));
    }

    @Test
    void testEmptyNameUTMLink() {
        Main.UTMData utm = new Main.UTMData("");
        assertNotNull(utm.utmLink);
        assertTrue(utm.utmMedium.equals("ambassador"));
    }
}
