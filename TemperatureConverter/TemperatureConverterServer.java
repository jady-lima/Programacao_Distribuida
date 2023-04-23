import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class TemperatureConverterServer {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1029);
            TemperatureConverter temperatureConverter = new TemperatureConverterImp();
            Naming.rebind("rmi://localhost:1029/TemperatureConverter", temperatureConverter);
            System.out.println("Server is ready");
        } catch (RemoteException e) {
            e.printStackTrace();
        } 
        catch (MalformedURLException e) {
            System.out.println("Erro");
            e.printStackTrace();
        }
    }
}
