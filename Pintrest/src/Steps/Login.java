package Steps;

import java.time.Duration;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.openqa.selenium.WebDriver;
import org.w3c.dom.Node;

import Pages.LogPage;


import javax.xml.xpath.XPathExpression;

import org.w3c.dom.Document;


public class Login {
    WebDriver driver;
    public Login(WebDriver webDriver){
        this.driver =webDriver;
    }
    public void launch(){
       

        LogPage logpage = new LogPage(this.driver);

        this.driver.get("https://www.pinterest.fr/login/");

        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        try{
        logpage.sendEmail(getEmail());
        logpage.sendPassword(getPassword());
        }catch(Exception e){ System.out.println("password or email not fount check your config.xml file");}
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        logpage.ckickLogKey();
    }
    private String getPassword() throws Exception {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    Document doc = factory.newDocumentBuilder().parse("src\\config.xml");
    XPath xpath = XPathFactory.newInstance().newXPath();
    XPathExpression expr = xpath.compile("//password/text()");
    Node node = (Node) expr.evaluate(doc, XPathConstants.NODE);
    System.out.println(node.getNodeValue());
    return node.getNodeValue();
  }
    private String getEmail() throws Exception {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    Document doc = factory.newDocumentBuilder().parse("src\\config.xml");
    XPath xpath = XPathFactory.newInstance().newXPath();
    XPathExpression expr = xpath.compile("//email/text()");
    Node node = (Node) expr.evaluate(doc, XPathConstants.NODE);
    System.out.println(node.getNodeValue());
    return node.getNodeValue();
  }
}
