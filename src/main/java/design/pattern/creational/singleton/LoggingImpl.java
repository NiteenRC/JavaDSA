package design.pattern.creational.singleton;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Logger {
    private static final String LOG_FILE_PATH = "/Users/niteenchougula/Documents/logs/logs.txt";
    private static Logger instance;
    private final Path logFilePath;

    private Logger() {
        logFilePath = Paths.get(LOG_FILE_PATH);
        try {
            // Create directories if they don't exist
            Files.createDirectories(logFilePath.getParent());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public synchronized void log(String message) {
        try {
            String formattedMessage = "[" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "] " + message + "\n";
            Files.writeString(logFilePath, formattedMessage, StandardCharsets.UTF_8, java.nio.file.StandardOpenOption.CREATE, java.nio.file.StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class LoggingImpl {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("Logging a message");
    }
}
