import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = false, format = {"pretty"},
        glue = {"ru.sbtqa.tag.stepdefs.ru"},
        //glue = {"ru.sbtqa.tag.pagefactory.stepdefs"},
        features = {"src/test/features/"}
)
public class CucumberTest {}

