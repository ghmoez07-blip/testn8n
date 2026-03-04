package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features", // Chemin vers vos fichiers .feature
        glue = "steps",                      // Nom du package où se trouvent vos steps
        plugin = {"pretty", "html:target/cucumber-reports.html"} // Génère un rapport pour n8n
)
public class TestRunner {
}
