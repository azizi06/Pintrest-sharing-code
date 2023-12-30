import org.openqa.selenium.edge.EdgeDriver;

import Steps.PintrestOperation;

public class Pintrest {
    public static void main(String[] args)  {
     PintrestOperation operation = new PintrestOperation(new EdgeDriver());
     operation.launch();
   
    }
}
