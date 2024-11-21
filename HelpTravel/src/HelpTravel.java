import java.util.Scanner;

public class HelpTravel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("In which country do you currently reside: ");
        String sourceCountryName = scanner.nextLine();
        String validSource = CountryNameNormalizer.normalizeCountryName(sourceCountryName);


        System.out.print("Where are you travelling to? ");
        String destCountryName = scanner.nextLine();
        String validDest = CountryNameNormalizer.normalizeCountryName(destCountryName);
        TravelAdvisory Advisory = new TravelAdvisory();
        String travelAdvisory = Advisory.getTravelAdvisory(validDest);
        System.out.println(travelAdvisory);

        System.out.print("How much money will you bring: ");
        double amount = scanner.nextDouble();


        // Use input to determine currency code
        System.out.println("Converting currency of " + validSource + " to currency of " + validDest);
        String sourceCurrency = CountryCurrencyMapper.getCurrencyCode(validSource);
        String targetCurrency = CountryCurrencyMapper.getCurrencyCode(validDest);
        System.out.println("Source: " + sourceCurrency + "\nTarget: " + targetCurrency);


        CurrencyConverter Converter = new CurrencyConverter();
        double exchangeRate = Converter.getExchangeRate(sourceCurrency, targetCurrency);
        System.out.println(Converter.convertCurrency(amount, exchangeRate));
        scanner.close();
    }
}
