package programs.design;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

public class URLShortener {
    private static final String BASE_URL = "http://short.com/";
    private static final int KEY_LENGTH = 6; // Length of shortened URL key
    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    private final Map<String, String> urlMap; // Mapping from shortened URL to original URL

    public URLShortener() {
        this.urlMap = new HashMap<>();
    }

    public static void main(String[] args) {
        URLShortener urlShortener = new URLShortener();

        // Shorten some URLs
        String shortURL1 = urlShortener.shortenURL("https://www.example.com/page1/mypost/practice");
        String shortURL2 = urlShortener.shortenURL("https://www.example.com/page2");

        // Redirect to original URLs
        System.out.println("Redirecting to original URL for " + shortURL1 + ": " + urlShortener.redirectToOriginalURL(shortURL1));
        System.out.println("Redirecting to original URL for " + shortURL2 + ": " + urlShortener.redirectToOriginalURL(shortURL2));
    }

    // Shorten the given original URL
    public String shortenURL(String originalURL) {
        String key = generateKey();
        String shortenedURL = BASE_URL + key;
        urlMap.put(shortenedURL, originalURL);
        return shortenedURL;
    }

    // Redirect to the original URL corresponding to the given shortened URL
    public String redirectToOriginalURL(String shortenedURL) {
        return urlMap.getOrDefault(shortenedURL, "Original URL not found");
    }

    // Generate a random key for the shortened URL
    private String generateKey() {
        StringBuilder sb = new StringBuilder();
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < KEY_LENGTH; i++) {
            int index = random.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(index));
        }
        return sb.toString();
    }
}