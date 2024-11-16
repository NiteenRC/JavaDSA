package design.pattern.creational.singleton;

import java.io.*;
import java.lang.reflect.Constructor;

public final class AuditService implements Serializable, Cloneable {
    // Step 1: Private static instance to hold the Singleton instance
    private static volatile AuditService instance;

    // Step 2: Private constructor to prevent instantiation from outside
    private AuditService() {
        // Prevent Reflection from breaking the Singleton pattern
        if (instance != null) {
            throw new IllegalStateException("Cannot instantiate more than one instance of AuditService");
        }
        // Initialization logic
        System.out.println("AuditService Initialized");
    }

    // Step 3: Public static method to access the Singleton instance
    public static AuditService getInstance() {
        if (instance == null) {
            synchronized (AuditService.class) {
                if (instance == null) {
                    instance = new AuditService();
                }
            }
        }
        return instance;
    }

    // Audit logging method (stateless)
    public void logAudit(String message) {
        System.out.println("Audit log: " + message);
    }

    // Step 4: Prevent cloning of the Singleton object
    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Cloning is not supported for Singleton class");
    }

    // Step 5: Prevent deserialization from breaking the Singleton pattern
    private Object readResolve() {
        return instance; // Ensures the Singleton instance is returned during deserialization
    }

    // Step 6: Prevent subclassing of the Singleton class
    public static class SingletonException extends RuntimeException {
        public SingletonException(String message) {
            super(message);
        }
    }
}