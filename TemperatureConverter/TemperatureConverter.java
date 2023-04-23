import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TemperatureConverter extends Remote {
    double CelsiusParaFahrenheit(double celsius) throws RemoteException;
    double CelsiusParaKelvin(double celsius) throws RemoteException;
    double FahrenheitParaCelsius(double fahrenheit) throws RemoteException;
    double FahrenheitParaKelvin(double fahrenheit) throws RemoteException;
    double KelvinParaCelsius(double kelvin) throws RemoteException;
    double KelvinParaFahrenheit(double kelvin) throws RemoteException;
}