package ad.example.javapattern.enrich;

import net.minidev.json.JSONObject;

public interface Enrichment {

    void enrich(JSONObject data);
}
