package ad.example.javapattern.chainofresponsibility;

import net.minidev.json.JSONObject;

public class EnrichFromSourceA extends AbstractEnrichmentStep {
    protected void performEnrichment(JSONObject data) {
        // Enrich data with attributes using external service or other logic
        System.out.println("Enriching from Source A");
        data.put("country", "India");
    }
}