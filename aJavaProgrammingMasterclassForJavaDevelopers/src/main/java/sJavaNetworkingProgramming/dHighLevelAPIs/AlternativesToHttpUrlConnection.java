package sJavaNetworkingProgramming.dHighLevelAPIs;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AlternativesToHttpUrlConnection {
    public static void main(String[] args) throws IOException {

        // Jetty
        // https://www.eclipse.org/jetty/
        // Apache HTTPClient
        // http://hc.apache.org/downloads.cgi

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet("https://www.flickr.com/services/feeds/photos_public.gne?tags=cats");
        request.addHeader("User-Agent", "Chrome");

        CloseableHttpResponse response = httpClient.execute(request);
        try {
            System.out.println("response code = " + response.getStatusLine().getStatusCode());

            BufferedReader inputReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String line;
            while ((line = inputReader.readLine()) != null) {
                System.out.println(line);
            }
            inputReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            response.close();
        }
    }
}
