package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.io.IOException;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"html:target/report.html","json:target/report/cucumber.json"},
                 features = {"src/test/resources/Features/"},
                 glue = {"steps"}, // no glue coloca o nome do pacote que está o hooks
                 tags = "@PlaceHolders")

public class RunnerTest {

    @AfterClass
    public static void report() throws IOException {
        Runtime.getRuntime().exec("cmd.exe /c mvn cluecumber-report:reporting");

    }
}
