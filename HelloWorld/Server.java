import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

public class Server 
{
    public static void main(String args[]) 
    {
        try {
            // Crie o objeto remoto
            Hello hello = new HelloImpl();

            // Exporte o objeto remoto
            // Hello stub = (Hello) UnicastRemoteObject.exportObject(obj, 1099);

            // Registre o stub no registro RMI
            Registry registry = LocateRegistry.getRegistry(1100);
            registry.bind("Hello", hello);

            System.out.println("Servidor running...");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
