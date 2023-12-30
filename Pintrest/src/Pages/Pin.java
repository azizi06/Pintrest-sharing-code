package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Pin {
    private WebDriver webDriver;
    By pinButton =By.xpath("//*[@id=\"__PWS_ROOT__\"]/div/div[1]/div/div[2]/div/div/div/div[5]/div/div/div/div/div/div/button/div/div/svg");
    By pin2Button = By.xpath("//*[@id=\"board_actions-item-0\"]/div/div/div[1]/div/div/span");
    By saveUsingURLButton = By.xpath("//*[@id=\"__PWS_ROOT__\"]/div//button[.//div[text()='Enregistrer depuis l’URL']]");
    By URLArea = By.xpath("//*[@id=\"scrape-view-website-link\"]");
    By URLAreaButton = By.xpath("//*[@id=\"__PWS_ROOT__\"]/div/div[1]//button[@aria-label =\"Envoyer\"]");
    By image = By.xpath("//div[@role =\"list\"]//div[1]//img");
    By addPin = By.xpath("//button[..//div[text()=\"Ajouter 1 Épingle\"]]");
    By descriptionArea = By.xpath("//*[@id=\"pin-draft-title-03b0fb21-1ee0-4638-884f-b30a3e0bb2a8\"]");
     By shareButton = By.xpath("//button[@data-test-id=\"board-dropdown-save-button\"]");
    public Pin(WebDriver driver){
        this.webDriver =driver ;
    }
    public void ClickpinButton(){
        //this.webDriver.findElement(pinButton).click();
        this.webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        this.webDriver.findElement(pin2Button).click();
    }
    public void saveUsingURL(){
           Wait<WebDriver> wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(2));
        wait.until(d -> this.webDriver.findElement(saveUsingURLButton));
        this.webDriver.findElement(saveUsingURLButton).click();
    }
    public void sendPinURL(String URL){
        Wait<WebDriver> wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(2));
        wait.until(d -> this.webDriver.findElement(URLArea));
        this.webDriver.findElement(URLArea).sendKeys(URL);
    }
    public void submitURLpin(){
        this.webDriver.findElement(URLAreaButton).click();;
    }
    public void selectImage(){
        Wait<WebDriver> wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(2));
        wait.until(d -> this.webDriver.findElement(image));
        this.webDriver.findElement(image).click();
    }
    public void ClickaddButton(){
        this.webDriver.findElement(addPin).click();
    }
    public void share(){
        Wait<WebDriver> wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(2));
        wait.until(d -> this.webDriver.findElement(shareButton));
        this.webDriver.findElement(shareButton).click();
    }
}
