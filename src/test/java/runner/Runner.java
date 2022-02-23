package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\123\\workspace\\BookingWebsite\\src\\test\\java\\feature\\hotelbooking.feature",
glue="stepdefinations",
tags="@reserve or @sign-in",
dryRun=false,monochrome=true,plugin={"html:target/cumcumber_html_report.html"})
public class Runner {

}
