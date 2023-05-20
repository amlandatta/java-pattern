package ad.example.javapattern;

import ad.example.javapattern.chainofresponsibility.EnrichFromSourceA;
import ad.example.javapattern.chainofresponsibility.EnrichFromSourceB;
import ad.example.javapattern.chainofresponsibility.EnrichmentStep;
import net.minidev.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JavaPatternApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void testEnrichmentStep1() {
        JSONObject jsonData = new JSONObject();
        EnrichmentStep step1 = new EnrichFromSourceA();

        step1.enrich(jsonData);

        // Assert that the enrichment logic for Step 1 has been applied
        Assertions.assertEquals("India", jsonData.get("country"));
    }

    @Test
    public void testEnrichmentStep2() {
        JSONObject jsonData = new JSONObject();
        EnrichmentStep step1 = new EnrichFromSourceA();
        EnrichmentStep step2 = new EnrichFromSourceB();

        step1.setNextStep(step2);
        step1.enrich(jsonData);

        // Assert that the enrichment logic for Step 1 and Step 2 has been applied
        Assertions.assertEquals("India", jsonData.get("country"));
        Assertions.assertEquals("Karnataka", jsonData.get("state"));
    }

    @Test
    public void testEmptyData() {
        JSONObject jsonData = new JSONObject();
        EnrichmentStep step1 = new EnrichFromSourceA();

        step1.enrich(jsonData);

        // Assert that the enrichment logic for Step 1 has been applied
        Assertions.assertEquals("India", jsonData.get("country"));
    }

}
