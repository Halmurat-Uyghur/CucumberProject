package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {


    WebDriver driver;

    private static By SEARCH_BAR = By.cssSelector("input[aria-label='Search']");


    public void searchText(String targetSearch){

        WebElement searchBar = driver.findElement(SEARCH_BAR);
        searchBar.sendKeys(targetSearch, Keys.ENTER);

    }


}
