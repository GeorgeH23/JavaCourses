package sJavaNetworkingProgramming.dHighLevelAPIs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class HttpUrlConnection {
    public static void main(String[] args) {

        // https://www.w3.org/Protocols/rfc2616/rfc2616-sec9.html
        // https://en.wikipedia.org/wiki/List_of_HTTP_header_fields

        // https://www.flickr.com/services/feeds/docs/photos_public/

        try {
            // URL url = new URL("http://example.org");
            URL url = new URL("https://www.flickr.com/services/feeds/photos_public.gne?tags=cats");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", "Chrome");

            int responseCode = connection.getResponseCode();
            System.out.println("Response code: " + responseCode);
            connection.setReadTimeout(10000);

            if (responseCode != 200) {
                System.out.println("Error reading web page.");
                System.out.println(connection.getResponseMessage());
                return;
            }

            BufferedReader inputReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line = "";
            while ((line = inputReader.readLine()) != null) {
                System.out.println(line);
            }
            inputReader.close();

        } catch (MalformedURLException e) {
            System.out.println("URL Malformed: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }
}
