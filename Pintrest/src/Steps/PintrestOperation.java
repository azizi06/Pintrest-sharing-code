package Steps;


import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.w3c.dom.Document;
import org.w3c.dom.Node;



public class PintrestOperation {
   private WebDriver webDriver;
   private String Path;
   private List<String> ProductList;
   public PintrestOperation(WebDriver driver){
    this.webDriver = driver;
  
   }

   public void launch(){
   try{ this.Path = getDataPath();}catch(Exception e){System.out.println("Data file not found check your config.xml file");}
    this.ProductList = GetProduct();
    System.setProperty("webdriver.edge.driver","C:\\Program Files\\selenium-java-4.16.1\\edgedriver\\msedgedriver.exe");  
    Login login = new  Login(this.webDriver);
    System.out.println("Login to Pintrest...");
    login.launch();
    sleep(6);   
    System.out.println("Sharing Pin..");
    sharingPinMethod01();

    this.webDriver.close();
    System.out.println("success..");
   }

   private void sleep(int i){
    try{
       Thread.sleep(i*1000);
    }catch(InterruptedException e){
    System.out.println("Treads System");
        }
   }
   
   private void sharingPinMethod01(){
    SharePin sharePin =new SharePin(this.webDriver);
    for(String p : this.ProductList){
    sharePin.setURL(p);
    sharePin.launch();
    sleep(2);
    }

   }

   private List<String> GetProduct(){
    List<String> urlList =new ArrayList<String>();

    try (BufferedReader br = new BufferedReader(new FileReader(this.Path))) {
            String line;
           
            while ((line = br.readLine()) != null) {
               urlList.add(line);
            } 
        } catch (IOException e) {
            e.printStackTrace();
        }
    return urlList;
    }
    private String getDataPath() throws Exception {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    Document doc = factory.newDocumentBuilder().parse("src\\config.xml");
    XPath xpath = XPathFactory.newInstance().newXPath();
    XPathExpression expr = xpath.compile("//data/text()");
    Node node = (Node) expr.evaluate(doc, XPathConstants.NODE);
    System.out.println(node.getNodeValue());
    return node.getNodeValue();
  }


   
}
