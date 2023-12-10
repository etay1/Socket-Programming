import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {
        // Create an HttpClient
        HttpClient httpClient = HttpClient.newHttpClient();

        // Define the request URI
        URI uri = URI.create("http://localhost:60000/hello");

        // Get user input for the message
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a message to send to the server: ");
        String userMessage = scanner.nextLine();

        // Create an HTTP request with the user's message
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .POST(HttpRequest.BodyPublishers.ofString(userMessage))
                .build();

        // Send the request and retrieve the response
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        // Print the response status code and body
        System.out.println("Response Code: " + response.statusCode());
        System.out.println("Response Body: " + response.body());
        scanner.close();
    }
}
