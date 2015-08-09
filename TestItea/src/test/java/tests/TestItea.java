package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static setup.SetupDriver.getDriver;

public class TestItea {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = getDriver();
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\NikolS\\Downloads\\chromedriver.exe");
        //driver = new ChromeDriver();
        baseUrl = "http://itea.ua/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testUntitled() throws Exception {
        driver.get(baseUrl);
        driver.manage().window().maximize() ;
        assertTrue(isElementPresent(By.cssSelector(".container>a")));
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".container>a")).click();
        driver.findElement(By.name("userName")).clear();
        driver.findElement(By.name("userName")).sendKeys("test");
        driver.findElement(By.id("phone")).clear();
        driver.findElement(By.id("phone")).sendKeys("0507777777");
        driver.findElement(By.name("userEmail")).clear();
        driver.findElement(By.name("userEmail")).sendKeys("test@test");
        new Select(driver.findElement(By.name("course"))).selectByVisibleText("Backend");
        driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
        driver.findElement(By.id("backLink")).click();
    }


    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
