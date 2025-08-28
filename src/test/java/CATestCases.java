import org.example.Main;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class CATestCases {

    @Test
    void testUTMLinkGeneration() {
        String caName = "Alex Carter";
        String link = Main.generateUTMLink(caName);
        assertNotNull(link);
        assertTrue(link.contains("utm_medium=Alex_Carter"));
    }

    @Test
    void testEmptyNameUTMLink() {
        String link = Main.generateUTMLink("");
        assertNotNull(link); // still generates with blank name
    }
}
