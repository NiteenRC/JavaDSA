package programs.serialisation;

import java.io.*;

record NonSerialized(String name) {
}

class Serialized implements Serializable {
    // Marked as transient or else exception since this class is not implements serializable
    private transient NonSerialized nonSerialized;
    private int id;

    // Constructor
    public Serialized(int id, NonSerialized nonSerialized) {
        this.id = id;
        this.nonSerialized = nonSerialized;
    }

    // Getters and setters
    public NonSerialized getNonSerialized() {
        return nonSerialized;
    }

    public void setNonSerialized(NonSerialized nonSerialized) {
        this.nonSerialized = nonSerialized;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Serialized{id=" + id + ", nonSerialized=" + nonSerialized + "}";
    }
}

public class Serialization1 {
    public static void main(String[] args) {
        try {
            // Create an instance of Serialized with a NonSerialized field
            NonSerialized nonSerializedObject = new NonSerialized("ExampleName");
            Serialized serializedObject = new Serialized(1, nonSerializedObject);

            // Serialize the object
            FileOutputStream fileOut = new FileOutputStream("serializedObject.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(serializedObject);// java.io.NotSerializableException: programs.serialisation.NonSerialized
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in serializedObject.ser");

            // Deserialize the object
            FileInputStream fileIn = new FileInputStream("serializedObject.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Serialized deserializedObject = (Serialized) in.readObject();
            in.close();
            fileIn.close();

            // Display the deserialized object
            System.out.println("Deserialized Serialized object:");
            System.out.println(deserializedObject);
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Serialized class not found");
            c.printStackTrace();
        }
    }
}