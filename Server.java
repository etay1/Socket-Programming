import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class Server {
    private static String clientMessage = "";

    public static void main(String[] args) throws IOException {
        // Create an HTTP server that listens on port 60000
        int port = 60000;
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);

        // Create a context for the "/hello" path and set the handler
        server.createContext("/hello", new HelloHandler());

        // Start the server
        server.start();

        // Add a shutdown hook to stop the server gracefully
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            server.stop(0);
            System.out.println("Server stopped");
        }));

        System.out.println("Server is running on port " + port + ". Open your browser and visit http://localhost:60000/hello");
    }

    // Handler class for the "/hello" path
    static class HelloHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            // Check if the request method is POST
            if ("POST".equals(exchange.getRequestMethod())) {
                // Read the client's message from the request body
                InputStreamReader isr = new InputStreamReader(exchange.getRequestBody(), "utf-8");
                BufferedReader br = new BufferedReader(isr);
                String clientMessage = br.readLine();

                // Print the client's message received
                System.out.println("Client Message Received: " + clientMessage);

                // Update the server's message by adding the client's message
                Server.clientMessage += "\nClient Message Received:" + clientMessage;
            }

            // Set the response headers
            exchange.getResponseHeaders().set("Content-Type", "text/plain");
            exchange.sendResponseHeaders(200, 0);

            // Get the output stream and write the response
            OutputStream os = exchange.getResponseBody();
            String response = "Server Message: Hello, World!!!" + "\n" + Server.clientMessage;
            os.write(response.getBytes());

            // Close the output stream and the exchange
            os.close();
            exchange.close();
        }
    }

}
