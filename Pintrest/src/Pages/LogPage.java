package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogPage {
    private WebDriver driver;
    By logKey = By.xpath("//*[@id=\"mweb-unauth-container\"]/div/div[3]/div/div/div[3]/form/div[7]/button/div");
    By emailTArea = By.id("email");
    By passwordTArea = By.id("password");

    public LogPage(WebDriver WebDriver){
        this.driver = WebDriver;
    }
    public void ckickLogKey(){
       this.driver.findElement(logKey).click();
    }
    public void sendEmail(String email){
       this.driver.findElement(emailTArea).sendKeys(email);
       this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
    }
    public void sendPassword(String password){
        this.driver.findElement(passwordTArea).sendKeys(password);
    }

    
}
