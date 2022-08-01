package runners;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import utilities.DriverManager;

public class BaseCukes {

    @BeforeClass
    public static void setup(){

        DriverManager.setDriver();

    }


    @AfterClass
    public static void tearDown(){

        DriverManager.quitDriver();
    }
}
