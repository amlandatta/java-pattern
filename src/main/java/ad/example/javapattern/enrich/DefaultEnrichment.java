package ad.example.javapattern.enrich;

import ad.example.javapattern.chainofresponsibility.EnrichFromSourceA;
import ad.example.javapattern.chainofresponsibility.EnrichmentStep;

import net.minidev.json.JSONObject;

public class DefaultEnrichment implements Enrichment {

    @Override
    public void enrich(JSONObject data) {
        // Create instances of enrichment steps
        EnrichmentStep step1 = new EnrichFromSourceA();

        // Start the enrichment process by calling the enrich method of the first step
        step1.enrich(data);
    }

}
