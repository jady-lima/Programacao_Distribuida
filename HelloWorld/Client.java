import java.rmi.registry.Registry;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Client 
{
    public static void main(String args[]) {
        try {
            // Obtenha uma referência ao registro RMI
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            // Obtenha a referência ao objeto remoto
            //Hello stub = (Hello) registry.lookup("Hello");
            // Chame o método remoto
            //String response = stub.sayHello();

            Hello hello = (Hello) registry.lookup("Hello");            

            System.out.println("Resposta do servidor: " + hello.sayHello());
        } catch (RemoteException e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        } catch (NotBoundException e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
