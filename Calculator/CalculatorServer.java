import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalculatorServer 
{
    public static void main(String[] args) throws Exception
    {
        Calculator calculator = new CalculatorImpl();
        Registry registry = LocateRegistry.createRegistry(1099);
        registry.bind("CalculatorService", calculator);
        System.out.println("CalculatorService is running...");
    }
}
