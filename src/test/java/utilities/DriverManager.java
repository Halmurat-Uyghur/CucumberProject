package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
import org.openqa.selenium.WebDriver;

public class DriverManager {

    @Getter private static WebDriver driver ;

    public static void setDriver() {
        driver = WebDriverManager.chromiumdriver().getWebDriver();
    }

    public static WebDriver getDriver(){
        return driver;
    }

    public static void quitDriver() {
        driver.quit();
    }
}
