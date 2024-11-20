import java.util.HashMap;

public class CountryCurrencyMapper {
    private static final HashMap<String, String> nameToCurrency;
    static {
        nameToCurrency = new HashMap<>();
        nameToCurrency.put("Andorra", "EUR");
        nameToCurrency.put("United Arab Emirates", "AED");
        nameToCurrency.put("Afghanistan", "AFN");
        nameToCurrency.put("Antigua and Barbuda", "XCD");
        nameToCurrency.put("Anguilla", "XCD");
        nameToCurrency.put("Albania", "ALL");
        nameToCurrency.put("Armenia", "AMD");
        nameToCurrency.put("Angola", "AOA");
        nameToCurrency.put("Argentina", "");
        nameToCurrency.put("United States", "USD");
    }

    public static String getCurrencyCode(String countryName) {
        return nameToCurrency.getOrDefault(countryName.toLowerCase().trim(), "unknown");
    }
}
