package runners;

import com.fasterxml.jackson.databind.ser.Serializers;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@CucumberOptions(
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        features = "src/test/java/features"
        ,glue = {"src/test/java/stepDefinitions"}
        ,monochrome = true

)
public class RegressionRunner extends BaseCukes {
}
