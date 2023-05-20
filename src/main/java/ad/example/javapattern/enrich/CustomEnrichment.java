package ad.example.javapattern.enrich;

import ad.example.javapattern.chainofresponsibility.EnrichFromSourceA;
import ad.example.javapattern.chainofresponsibility.EnrichFromSourceB;
import ad.example.javapattern.chainofresponsibility.EnrichmentStep;
import net.minidev.json.JSONObject;

public class CustomEnrichment implements Enrichment {

    @Override
    public void enrich(JSONObject data) {
        // Create instances of enrichment steps
        EnrichmentStep step1 = new EnrichFromSourceA();
        EnrichmentStep step2 = new EnrichFromSourceB();

        // Set the order of the enrichment steps
        step1.setNextStep(step2);

        // Start the enrichment process by calling the enrich method of the first step
        step1.enrich(data);
    }

}
