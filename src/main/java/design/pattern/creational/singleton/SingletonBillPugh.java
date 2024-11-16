package design.pattern.creational.singleton;

/**
 * Implementing a flawless thread-safe Singleton pattern in Java that covers all edge cases,
 * including lazy initialization and high efficiency, can be done using the Bill Pugh Singleton Design.
 * This approach uses a static inner helper class to ensure that the instance is created only
 * when it is requested for the first time, leveraging the Java class loading mechanism to
 * ensure thread safety and lazy initialization without synchronization overhead.
 */
public class SingletonBillPugh {
}

class Singleton {
    // Private constructor to prevent instantiation
    private Singleton() {
        // Prevent instantiation via reflection
        if (Holder.INSTANCE != null) {
            throw new IllegalStateException("Instance already created.");
        }
    }

    // Public method to provide access to the Singleton instance
    public static Singleton getInstance() {
        return Holder.INSTANCE;
    }

    // Implementing readResolve to prevent another instance from the deserialization
    private Object readResolve() {
        return getInstance();
    }

    // Static inner helper class responsible for holding the Singleton instance
    private static class Holder {
        private static final Singleton INSTANCE = new Singleton();
    }
}
