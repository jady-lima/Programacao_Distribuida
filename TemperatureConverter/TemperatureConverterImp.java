import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class TemperatureConverterImp extends UnicastRemoteObject implements TemperatureConverter
{
    public TemperatureConverterImp() throws RemoteException
    {
        super();
    }

    public double CelsiusParaFahrenheit(double celsius) throws RemoteException
    {
        return (celsius * 1.8) + 32;
    }

    public double CelsiusParaKelvin(double celsius) throws RemoteException
    {
        return celsius + 273.15;
    }

    public double FahrenheitParaCelsius(double fahrenheit) throws RemoteException
    {
        return (fahrenheit - 32) / 1.8;
    }

    public double FahrenheitParaKelvin(double fahrenheit) throws RemoteException
    {
        return (fahrenheit + 459.67) * 5/9;
    }

    public double KelvinParaCelsius(double kelvin) throws RemoteException
    {
        return kelvin - 273.15;
    }

    public double KelvinParaFahrenheit(double kelvin) throws RemoteException
    {
        return ((kelvin - 273.15) * 1.8 ) + 32;
    }
}
