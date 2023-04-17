import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

public class Client {

    public static void main(String args[]) {
        try {
            // Obtenha uma referência ao registro RMI
            Registry registry = LocateRegistry.getRegistry();

            // Obtenha a referência ao objeto remoto
            Hello stub = (Hello) registry.lookup("Hello");

            // Chame o método remoto
            String response = stub.sayHello();

            System.out.println("Resposta do servidor: " + response);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
