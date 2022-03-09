package co.com.t_evolvers.runners;

import io.cucumber.junit.CucumberOptions.SnippetType;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = {"src/test/resources/features/demoblaze.feature"},
        glue = {"co.com.t_evolvers.stepDefinitions"},
        tags = "",
        monochrome = true, snippets = SnippetType.CAMELCASE)

public class DemoblazeRunner {
}
