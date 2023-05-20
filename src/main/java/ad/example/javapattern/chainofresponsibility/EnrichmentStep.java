package ad.example.javapattern.chainofresponsibility;

import net.minidev.json.JSONObject;

/*
The EnrichmentStep interface defines the contract for the enrichment steps.
*/
public interface EnrichmentStep {
    void setNextStep(EnrichmentStep nextStep);
    void enrich(JSONObject data);
}
