package generic;

public class GenericCaller {
    public static void main(String[] args) {
        GenericCaller caller = new GenericCaller();
        caller.callWithNull("Hello");  // Output: String
        caller.callWithNull(42);       // Output: Integer
    }

    private void callWithNull(String str) {
        System.out.println("String");
    }

    private void callWithNull(Integer integer) {
        System.out.println("Integer");
    }

    public <T> void callWithNull(T arg) {
        if (arg instanceof String) {
            callWithNull((String) arg);
        } else if (arg instanceof Integer) {
            callWithNull((Integer) arg);
        } else {
            System.out.println("Unknown Type");
        }
    }
}