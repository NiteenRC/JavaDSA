package design.pattern.creational.singleton;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

public class SingletonBreakTest {
    public static void main(String[] args) {
        // Scenario 1: Access the Singleton instance
        System.out.println("Scenario 1: Access Singleton Instance");
        AuditService auditService1 = AuditService.getInstance();
        auditService1.logAudit("First log message");

        // Scenario 2: Attempt to create another instance using Reflection
        try {
            System.out.println("\nScenario 2: Attempt to create Singleton via Reflection");
            Constructor<AuditService> constructor = AuditService.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            AuditService auditService2 = constructor.newInstance();
        } catch (Exception e) {
            System.out.println("Reflection Exception: " + e.getMessage());
        }

        // Scenario 3: Attempt to clone the Singleton instance
        try {
            System.out.println("\nScenario 3: Attempt to clone Singleton instance");
            AuditService auditServiceClone = (AuditService) auditService1.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("Clone Exception: " + e.getMessage());
        }

        // Scenario 4: Attempt to deserialize the Singleton instance (serialization/deserialization)
        try {
            System.out.println("\nScenario 4: Attempt to deserialize Singleton instance");
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(auditService1);
            objectOutputStream.close();

            // Deserialize the Singleton object
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            AuditService auditServiceDeserialized = (AuditService) objectInputStream.readObject();
            objectInputStream.close();

            // Print to verify if it's the same instance
            System.out.println("Deserialized instance is same as original: " + (auditService1 == auditServiceDeserialized));
        } catch (Exception e) {
            System.out.println("Serialization/Deserialization Exception: " + e.getMessage());
        }

        // Scenario 5: Attempt to subclass the Singleton class
        try {
            System.out.println("\nScenario 5: Attempt to subclass Singleton class");
            Class<?> subclass = Class.forName("design.pattern.creational.singleton.AuditService$SingletonException");
            AuditService.SingletonException subclassInstance = (AuditService.SingletonException) subclass.newInstance();
            System.out.println("Subclass instance: " + subclassInstance);
        } catch (Exception e) {
            System.out.println("Subclass Exception: " + e.getMessage());
        }
    }
}
