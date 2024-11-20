import java.util.Scanner;

public class HelpTravel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /*System.out.print("name a country: ");
        String countryName = scanner.nextLine();
        String currency = CountryCurrencyMapper.getCurrencyCode(countryName);
        System.out.print(currency);
        scanner.close();*/

        /*System.out.print("Where are you travelling to? ");
        String countryName = scanner.nextLine();
        TravelAdvisory Advisory = new TravelAdvisory();
        String travelAdvisory = Advisory.getTravelAdvisory(countryName);
        System.out.println(travelAdvisory);
        scanner.close();*/

        System.out.print("Source currency: ");
        String sourceCurrency = scanner.next().toUpperCase();

        System.out.print("Target currency: ");
        String targetCurrency = scanner.next().toUpperCase();

        System.out.print("Amount: ");
        double amount = scanner.nextDouble();

        CurrencyConverter Converter = new CurrencyConverter();
        double exchangeRate = Converter.getExchangeRate(sourceCurrency, targetCurrency);
        System.out.println(Converter.convertCurrency(amount, exchangeRate));
        scanner.close();
    }
}
