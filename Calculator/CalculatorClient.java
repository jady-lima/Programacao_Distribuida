import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalculatorClient 
{
    public static void main(String[] args) 
    {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1100);
            Calculator calculator = (Calculator) registry.lookup("CalculatorService");

            int x = 10;
            int y = 5;

            System.out.println(x + " + " + y + " = " + calculator.add(x, y));
            System.out.println(x + " - " + y + " = " + calculator.subtract(x, y));
            System.out.println(x + " * " + y + " = " + calculator.multiply(x, y));
            System.out.println(x + " / " + y + " = " + calculator.divide(x, y));
            
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
        
    }
}
