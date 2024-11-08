import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CurrencyConverter {

    private static final String API_KEY = "2af5d6f6a2a528eb8085e9e52aab24b9";

    public static double getExchangeRate(String sourceCurrency, String targetCurrency) {
        String urlString = String.format(
                "http://api.currencylayer.com/live?access_key=2af5d6f6a2a528eb8085e9e52aab24b9",
                API_KEY, targetCurrency, sourceCurrency);

        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            if (conn.getResponseCode() != 200) {
                System.out.println("Error");
                return -1;
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            String responseString = response.toString();
            String searchString = "\"" + sourceCurrency + targetCurrency + "\":";
            int searchIndex = responseString.indexOf(searchString);

            if (searchIndex == -1) {
                System.out.println("Error");
                return -1;
            }

            int start = searchIndex + searchString.length();
            int end = responseString.indexOf(",", start);
            if (end == -1) {
                end = responseString.indexOf("}", start);
            }

            String rateString = responseString.substring(start, end).trim();
            return Double.parseDouble(rateString);

        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

}
