# Socket Programming Project

This project involves a simple server-client interaction via the terminal and localhost, demonstrating Java-based client-server communication using HTTP. The server listens on port 60000 and responds to client messages, updating a shared message on the server. The client sends a message to the server, and the server responds with a combined message.

## Project Files

- **Server.java:** Contains the server-side implementation.
- **Client.java:** Contains the client-side implementation.

## Instructions

### Running the Server

1. Open the terminal or command prompt.
2. Navigate to the directory containing `Server.java`.
3. Compile the server code: `javac Server.java`.
4. Run the server: `java Server`.

The server will start running on [http://localhost:60000/hello](http://localhost:60000/hello). You can access this URL in your browser.

### Running the Client

1. Open another terminal or command prompt.
2. Navigate to the directory containing `Client.java`.
3. Compile the client code: `javac Client.java`.
4. Run the client: `java Client`.

The client will prompt you to enter a message. Enter a message, and the client will send it to the server. The server will respond with a combined message.

## Project Notes

- The server processes POST requests at the `/hello` endpoint.
- The client sends a user-defined message to the server.
- The server combines and displays the client's messages.
- The server can be gracefully stopped using a shutdown hook.

## Example

1. Start the server.
2. Open the client and enter a message.
3. The server will display the client's message along with the server's response.

## Dependencies

- Java SDK 8 or higher.
