package at.htlhl.httpclientdemo;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpGetDemo {
    // Constants **********************************************************

    private final String REQUEST_URL = "https://api.predic8.de/shop/v2/products?limit=1000";


    // Fields *************************************************************

    private ObjectMapper jsonMapper;

    // Instance creation **************************************************

    public HttpGetDemo() {
        try {
            // HTTP GET-request erzeugen
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(REQUEST_URL))
                    .header("Content-Type", "application/json")
                    .GET()
                    .build();
            /*
             * Den erzeugten HTTP-Request mit HttpClient senden
             * (die Rückmeldung wird in `response` vom Typ HttpResponse gespeichert)
             */


            HttpClient httpClient = HttpClient.newHttpClient();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            /*
                * Die Rückmeldung verarbeiten: Status Code ok?
             */

            System.out.println("Status Code: " + response.statusCode());
            if(response.statusCode() == HttpURLConnection.HTTP_OK) {
                System.out.println("Response Body: " + response.body());
            }
        } catch (URISyntaxException ex) {
            System.err.println("URISyntaxException: " + ex.getMessage());
            System.err.println("Programm will exit ...");
            System.exit(1);
        } catch (IOException ex) {
            System.err.println("IOException: " + ex.getMessage());
            System.err.println("Programm will exit ...");
            System.exit(1);
        } catch (InterruptedException ex) {
            System.err.println("InterruptedException: " + ex.getMessage());
            System.err.println("Programm will exit ...");
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        new HttpGetDemo();
    }
}