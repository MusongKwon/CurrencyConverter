import java.util.HashMap;

public class CountryNameNormalizer {
    private static final HashMap<String, String> nameMapping;

    static {
        nameMapping = new HashMap<>();
        // Map common names and misspellings to the standard country name
        nameMapping.put("united states", "United States");
        nameMapping.put("usa", "United States");
        nameMapping.put("u.s.", "United States");
        nameMapping.put("america", "United States");
        nameMapping.put("u.s.a.", "United States");
        nameMapping.put("united states of america", "United States");
        nameMapping.put("United Kingdom", "United Kingdom");
        nameMapping.put("uk", "United Kingdom");
        nameMapping.put("britain", "United Kingdom");
        nameMapping.put("england", "United Kingdom");
        nameMapping.put("uae", "United Arab Emirates");
        nameMapping.put("emirates", "United Arab Emirates");
        // Add more mappings as needed
    }

    public static String normalizeCountryName(String input) {
        input = input.toLowerCase().trim();
        if (nameMapping.containsKey(input)) {
            return nameMapping.get(input);
        }
        // Fallback to find the closest match
        return findClosestMatch(input);
    }

    private static String findClosestMatch(String input) {
        String closestMatch = "unknown";
        int minDistance = Integer.MAX_VALUE;

        for (String key : nameMapping.keySet()) {
            int distance = levenshteinDistance(input, key);
            if (distance < minDistance) {
                minDistance = distance;
                closestMatch = nameMapping.get(key);
            }
        }

        // If the match is too far off, return "unknown"
        return (minDistance <= 3) ? closestMatch : "unknown";
    }

    private static int levenshteinDistance(String a, String b) {
        int[][] dp = new int[a.length() + 1][b.length() + 1];

        for (int i = 0; i <= a.length(); i++) {
            for (int j = 0; j <= b.length(); j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else {
                    int cost = (a.charAt(i - 1) == b.charAt(j - 1)) ? 0 : 1;
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1), dp[i - 1][j - 1] + cost);
                }
            }
        }
        return dp[a.length()][b.length()];
    }
}

