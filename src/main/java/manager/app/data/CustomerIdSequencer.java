package manager.app.data;

public class CustomerIdSequencer {
    private static int id = 0;

    public static int readId() {
        return id;
    }

    public static int nextCustomerId(){
        return ++id;
    }

    public static int resetId(){
        return id = 0;
    }
}
