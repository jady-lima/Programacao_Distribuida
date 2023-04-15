import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server {

    public static void main(String args[]) {
        try {
            // Crie o objeto remoto
            HelloImpl obj = new HelloImpl();

            // Exporte o objeto remoto
            Hello stub = (Hello) UnicastRemoteObject.exportObject(obj, 0);

            // Registre o stub no registro RMI
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("Hello", stub);

            System.out.println("Servidor pronto...");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
