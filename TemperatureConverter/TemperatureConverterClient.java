import java.rmi.Naming;
import java.util.Scanner;

public class TemperatureConverterClient {

public static final double MINCELSIUS = -273.15;
public static final double MAXCELSIUS = 141678500 * 10^24;
public static final double MINFAHRENHEIT = -459.67;
public static final double MAXFAHRENHEIT = 2.550213E32;
public static final double MINKELVIN = 0;

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            TemperatureConverter converter = (TemperatureConverter) Naming.lookup("rmi://localhost:1029/TemperatureConverter");

            System.out.println("Digite de que temperatura deseja converter [C/F/K]:");
            String tempInicial = sc.nextLine();
            System.out.println("Para qual temperatura deseja converter[C/K/F]? ");
            String tempFinal = sc.nextLine();

            do{
                System.out.println("Digite a temperatura: ");
                double temperatura = sc.nextDouble();

                //C -> K
                if (tempInicial.equals("C") && tempFinal.equals("K") && temperatura >= MINCELSIUS && temperatura <= MAXCELSIUS) 
                {
                    System.out.println("Celsius: " + temperatura + "C \t -> " + "Kelvin: " + converter.CelsiusParaKelvin(temperatura) + "K" );
                    break;
                }

                //C -> F
                else if (tempInicial.equals("C") && tempFinal.equals("F") && temperatura >= MINCELSIUS && temperatura <= MAXCELSIUS)
                {
                    System.out.println("Celsius: " + temperatura + "C \t -> " + "Fahrenheit: " + converter.CelsiusParaFahrenheit(temperatura) + "F");
                    break;
                }

                //F -> C
                else if (tempInicial.equals("F") && tempFinal.equals("C") && temperatura >= MINFAHRENHEIT && temperatura <= MAXFAHRENHEIT)
                {
                    System.out.println("Fahrenheit: " + temperatura + "F \t -> " + "Celsius: " + converter.FahrenheitParaCelsius(temperatura) + "C");
                    break;
                }

                //F -> K
                else if (tempInicial.equals("F") && tempFinal.equals("K") && temperatura >= MINFAHRENHEIT && temperatura <= MAXFAHRENHEIT)
                {
                    System.out.println("Fahrenheit: " + temperatura + "F \t -> " + "Kelvin: " + converter.FahrenheitParaKelvin(temperatura) + "K");
                    break;
                }

                //K -> C
                else if (tempInicial.equals("K") && tempFinal.equals("C") && temperatura >= MINKELVIN)
                {
                    if (converter.KelvinParaCelsius(temperatura) > MAXCELSIUS)
                    {
                        System.out.println("O valor não existe dentro da escala solicitada.");
                    }
                    else
                    {
                        System.out.println("Kelvin: " + temperatura + "K \t -> " + "Celsius: " + converter.KelvinParaCelsius(temperatura) + "C");
                        break;
                    }   
                }

                //K -> F
                else if (tempInicial.equals("K") && tempFinal.equals("F") && temperatura >= MINKELVIN)
                {
                    if (converter.KelvinParaCelsius(temperatura) > MAXFAHRENHEIT)
                    {
                        System.out.println("O valor não existe dentro da escala solicitada.");
                    }
                    else
                    {
                        System.out.println("Kelvin: " + temperatura + "K \t -> " + "Fahrenheit: " + converter.KelvinParaFahrenheit(temperatura) + "F");
                        break;
                    }
                }
                
                //Nenhuma das opçoes acima
                else
                {
                    System.out.println("Não é possivel realizar a conversão solicitada. Tente novamente.");
                }

            }while(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
