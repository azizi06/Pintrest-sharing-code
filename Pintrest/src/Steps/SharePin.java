package Steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

import Pages.Pin;

public class SharePin {
    private WebDriver driver;
    private String url;
     public SharePin(WebDriver driver){
        this.driver = driver;
    } 
    public SharePin(WebDriver driver,String url){
        this.driver = driver;
        this.url =url;
    } 
    public void launch(){
        this.driver.switchTo().newWindow(WindowType.TAB);
        Pin pin = new Pin(this.driver);
        this.driver.get("https://www.pinterest.fr/pin-creation-tool/");
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
       // pin.ClickpinButton();
        //this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));    
        pin.saveUsingURL();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        pin.sendPinURL(url);
        pin.submitURLpin();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        pin.selectImage();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        pin.ClickaddButton();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        sleep(3);

        pin.share();
    }   
    private void sleep(int i){
         try{
            Thread.sleep(i*1000);
    }catch(InterruptedException e){
         System.out.println("Treads System problem");
    }
    } 
    public void setURL(String URL){
        this.url= URL;
    }
}
