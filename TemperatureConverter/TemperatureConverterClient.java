import java.rmi.Naming;
import java.util.Scanner;

public class TemperatureConverterClient {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            TemperatureConverter converter = (TemperatureConverter) Naming.lookup("rmi://localhost:1029/TemperatureConverter");

            System.out.println("Digite de que temperatura deseja converter [C/F/K]:");
            String tempInicial = sc.nextLine();
            System.out.println("Para qual temperatura deseja converter[C/K/F]? ");
            String tempFinal = sc.nextLine();
            System.out.println("Digite a temperatura: ");
            double temperatura = sc.nextDouble();

            if (tempInicial.equals("C") && tempFinal.equals("K")) 
            {
                System.out.println("Celsius: " + temperatura + "°C \t -> " + "Kelvin: " + converter.CelsiusParaKelvin(temperatura) + "K");
            }
            else if (tempInicial.equals("C") && tempFinal.equals("F"))
            {
                System.out.println("Celsius: " + temperatura + "°C \t -> " + "Fahrenheit: " + converter.CelsiusParaFahrenheit(temperatura) + "°F");
            }
            else if (tempInicial.equals("F") && tempFinal.equals("C"))
            {
                System.out.println("Fahrenheit: " + temperatura + "°F \t -> " + "Celsius: " + converter.FahrenheitParaCelsius(temperatura) + "°C");
            }
            else if (tempInicial.equals("F") && tempFinal.equals("K"))
            {
                System.out.println("Fahrenheit: " + temperatura + "°F \t -> " + "Kelvin: " + converter.FahrenheitParaKelvin(temperatura) + "K");
            }
            else if (tempInicial.equals("K") && tempFinal.equals("C"))
            {
                System.out.println("Kelvin: " + temperatura + "K \t -> " + "Celsius: " + converter.KelvinParaCelsius(temperatura) + "°C");
            }
            else if (tempInicial.equals("K") && tempFinal.equals("F"))
            {
                System.out.println("Kelvin: " + temperatura + "K \t -> " + "Fahrenheit: " + converter.KelvinParaFahrenheit(temperatura) + "°F");
            }
            else
            {
                System.out.println("Não é possivel realizar a conversão solicitada.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
