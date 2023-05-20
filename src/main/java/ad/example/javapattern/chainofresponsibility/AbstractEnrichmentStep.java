package ad.example.javapattern.chainofresponsibility;

import net.minidev.json.JSONObject;

/*
AbstractEnrichmentStep class provides the common functionality and
implements the EnrichmentStep interface.
 */
public abstract class AbstractEnrichmentStep implements EnrichmentStep {
    private EnrichmentStep nextStep;

    public void setNextStep(EnrichmentStep nextStep) {
        this.nextStep = nextStep;
    }

    public void enrich(JSONObject data) {
        // Perform any common processing before enrichment
        System.out.println("AbstractEnrichmentStep.enrich() called,  performing common processing");
        data.put("generic", "fromAbstract");
        // Call the specific enrichment logic of the subclass
        performEnrichment(data);

        // Pass the request to the next step in the chain
        if (nextStep != null) {
            nextStep.enrich(data);
        }
    }

    protected abstract void performEnrichment(JSONObject data);
}