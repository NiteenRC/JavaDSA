package design.pattern.behavioral.chain;

import lombok.Data;

// Handler interface
interface Handler {
    void handle(HttpRequest request); // Method to handle requests

    void setNextHandler(Handler handler); // Method to set the next handler in the chain
}

// Abstract class implementing the Handler interface
abstract class AbstractHandler implements Handler {
    Handler nextHandler; // Reference to the next handler in the chain

    @Override
    public void setNextHandler(Handler handler) {
        this.nextHandler = handler;
    }
}

@Data // Lombok annotation to generate getters and setters
class HttpRequest {
    private final String path; // Path of the HTTP request
    private final String method; // HTTP method of the request
    private final String body; // Body of the request

    // Constructor to initialize the HttpRequest object
    HttpRequest(String path, String method, String body) {
        this.path = path;
        this.method = method;
        this.body = body;
    }
}

// Concrete Handler for authentication
class AuthenticationHandler extends AbstractHandler {
    @Override
    public void handle(HttpRequest request) {
        // Simulate authentication logic
        if (request.getPath().equals("/admin") && !isLoggedIn(request)) {
            System.out.println("User is not logged in.");
            return;
        }
        this.nextHandler.handle(request); // Pass the request to the next handler
    }

    // Simulated method to check if the user is logged in
    private boolean isLoggedIn(HttpRequest request) {
        // In a real application, this would involve checking session, cookies, or tokens
        return true;
    }
}

// Concrete Handler for logging
class LoggingHandler extends AbstractHandler {
    @Override
    public void handle(HttpRequest request) {
        // Simulate logging
        System.out.println("Logging request: " + request.getMethod() + " " + request.getPath());

        this.nextHandler.handle(request); // Pass the request to the next handler
    }
}

// Concrete Handler for validation
class ValidationHandler extends AbstractHandler {
    @Override
    public void handle(HttpRequest request) {
        // Check if the request path is "/create" and the request body is valid
        if (request.getPath().equals("/create") && !isValid(request.getBody())) {
            System.out.println("Request body is not valid.");
        } else {
            System.out.println("All handlers passed");
        }
    }

    // Simulated method to validate the request body
    private boolean isValid(String body) {
        return body != null && !body.isEmpty();
    }
}

// Client code
public class RequestInterceptor {
    public static void main(String[] args) {
        Handler handler = getHandlers(); // Get the chain of handlers

        // Simulate incoming HTTP requests
        HttpRequest request1 = new HttpRequest("/admin", "GET", "");
        HttpRequest request2 = new HttpRequest("/create", "POST", "Some data");

        // Handle requests
        handler.handle(request1); // Output: Logging request: GET /admin
        handler.handle(request2); // Output: Logging request: POST /create
        // Output: Request body is not valid.
    }

    // Method to construct the chain of responsibility
    private static Handler getHandlers() {
        Handler authenticationHandler = new AuthenticationHandler();
        Handler loggingHandler = new LoggingHandler();
        Handler validationHandler = new ValidationHandler();

        // Construct the chain of responsibility
        authenticationHandler.setNextHandler(loggingHandler);
        loggingHandler.setNextHandler(validationHandler);
        return authenticationHandler; // Return the first handler in the chain
    }
}