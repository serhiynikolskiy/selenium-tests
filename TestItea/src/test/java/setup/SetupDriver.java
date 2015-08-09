package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by ad on 22.06.2015.
 */
public class SetupDriver {

    static WebDriver driver;

    public static WebDriver getDriver() {

        if (driver == null) {
            driver = new FirefoxDriver();
        }
        return driver;
    }
}