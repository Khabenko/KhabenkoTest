import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/features",
        glue = "",
 //       tags = "@all",
        dryRun = false,
        strict = false,
        snippets = SnippetType.CAMELCASE
//        name = "^Успешное|Успешная.*"
)
public class RunnerTest {
}
