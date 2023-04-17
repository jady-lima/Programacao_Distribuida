import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculatorImpl extends UnicastRemoteObject implements Calculator
{
    //Método construtor
    public CalculatorImpl() throws RemoteException
    {
        super();
    }

    //Método de adição
    public int add(int x, int y) throws RemoteException
    {
        return x + y;
    }

    //Método de subtração
    public int subtract(int x, int y) throws RemoteException
    {
        return x - y;
    }

    //Método de multiplicação
    public int multiply(int x, int y) throws RemoteException
    {
        return x * y;
    }

    //Método de divisão
    public int divide(int x, int y) throws RemoteException
    {
        return x / y;
    }
}
