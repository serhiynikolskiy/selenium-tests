package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by NikolS on 8/8/2015.
 */
public class MainPage {
 private WebDriver driver;

    @FindBy(linkText = "Расписание")
    WebElement linkNews;
    @FindBy(linkText = "Контакты")
    WebElement linkContacts;
    @FindBy(linkText = "Услуги")
    WebElement linkTeachers;
    @FindBy(linkText = "Получить бесплатную консультацию")
    WebElement linkSend;
    @FindBy(name = "userName")
    WebElement fieldName;
    @FindBy(id = "phone")
    WebElement fieldPhone;
    @FindBy(name = "userEmail")
    WebElement fieldEmail;
    @FindBy(xpath = ".//*[@name='course']")
    Select course;
    @FindBy(xpath = ".//*[@id='main-form']/form/select/option[5]")
    WebElement courseCase4;
    @FindBy(xpath = ".//*[@id='main-form']/form/input[4]")
    WebElement submit;



    public void login(){
        linkNews.click();
        linkContacts.click();
        linkTeachers.click();
    }

    public void send(String userName, String userPhone, String userEmail) {
        linkSend.click();
        fieldName.sendKeys(userName);
        fieldPhone.clear();
        fieldPhone.sendKeys(userPhone);
        fieldEmail.sendKeys(userEmail);
        //new Select(driver.findElement(By.name("course"))).selectByVisibleText("Backend");
        submit.click();
    }
}
