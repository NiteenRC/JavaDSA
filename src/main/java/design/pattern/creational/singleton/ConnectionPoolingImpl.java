package design.pattern.creational.singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

class ConnectionPool {
    private static final int MAX_CONNECTIONS = 10;
    private static ConnectionPool instance;
    private final List<Connection> connections;

    private ConnectionPool() {
        connections = new ArrayList<>();
        initializeConnections();
    }

    public static synchronized ConnectionPool getInstance() {
        if (instance == null) {
            instance = new ConnectionPool();
        }
        return instance;
    }

    private void initializeConnections() {
        try {
            for (int i = 0; i < MAX_CONNECTIONS; i++) {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/design-db", "root", "Root@123");
                connections.add(connection);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public synchronized Connection getConnection() {
        if (!connections.isEmpty()) {
            return connections.remove(0);
        }
        return null;
    }

    public synchronized void releaseConnection(Connection connection) {
        connections.add(connection);
    }
}

public class ConnectionPoolingImpl {
    public static void main(String[] args) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = connectionPool.getConnection();
// Use the connection
        connectionPool.releaseConnection(connection);

    }
}
