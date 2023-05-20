package ad.example.javapattern;

import ad.example.javapattern.enrich.CustomEnrichment;
import ad.example.javapattern.enrich.DefaultEnrichment;
import ad.example.javapattern.enrich.Enrichment;
import net.minidev.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaPatternApplication {

    public static void main(String[] args) {
       // SpringApplication.run(JavaPatternApplication.class, args);
        enrichment("");
        enrichment("custom");
    }

    private static void enrichment(String enrichmentType) {
        Enrichment enrichment;
        System.out.println(enrichmentType);

        switch (enrichmentType) {
            case "custom":
                enrichment = new CustomEnrichment();
                break;
            default:
                enrichment = new DefaultEnrichment();
        }

        JSONObject data = new JSONObject();
        data.put("name", "AD");

        enrichment.enrich(data);
        System.out.println("*****************");
        System.out.println("Input : " + enrichmentType);
        System.out.println("Output : " + data);
        System.out.println("*****************");
    }

}
