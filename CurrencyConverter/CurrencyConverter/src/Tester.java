import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Source currency: USD");
        String sourceCurrency = "USD";

        System.out.print("Enter target currency: ");
        String targetCurrency = scanner.next().toUpperCase();

        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();

        CurrencyConverter Converter = new CurrencyConverter();
        double exchangeRate = Converter.getExchangeRate(sourceCurrency, targetCurrency);
        if (exchangeRate == -1) {
            System.out.println("error");
        }
        else {
            double convertedAmount = amount * exchangeRate;
            System.out.printf("%.2f %s = %.2f %s%n", amount, sourceCurrency, convertedAmount, targetCurrency);
            System.out.println("The exchange rate is " + exchangeRate);
        }

        scanner.close();
    }
}
