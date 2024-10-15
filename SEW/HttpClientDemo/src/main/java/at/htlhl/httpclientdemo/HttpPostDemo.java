package at.htlhl.httpclientdemo;

import at.htlhl.httpclientdemo.model.Product;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class HttpPostDemo {

    // Constants **********************************************************

    public static final int COSTUMER = 3;

    private static final String REQUEST_URL = "https://api.predic8.de/shop/v2/customers/" + COSTUMER + "/orders";

    private ArrayList<Product> products = new ArrayList<Product>();


    // Fields *************************************************************

    private ObjectMapper jsonMapper;

    public HttpPostDemo() {
        jsonMapper = new ObjectMapper();



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

                JsonNode jsonNode = jsonMapper.readTree(response.body());
                JsonNode productNode = jsonNode.get("products");

                List<Product> productList = jsonMapper.readerForListOf(Product.class).readValue(productNode);

                for (Product product : productList) {
                    System.out.println(product);
                }
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
        new HttpPostDemo();
    }
}
