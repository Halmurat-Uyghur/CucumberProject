package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utilities.DriverManager;

public class LoginStepDef {


    WebDriver driver;
    LoginPage loginPage;

    @Given("user open google page")
    public void goToLoginPage(){

        driver = DriverManager.getDriver();
        driver.get("https://www.google.com");


    }

    @When("user search ")
    public void search(String text) {
        loginPage.searchText(text);
    }
}
