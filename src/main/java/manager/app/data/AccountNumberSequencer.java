package manager.app.data;

public class AccountNumberSequencer {
    private static int accountNumber = 0;

    public static int readAccountNumber() {
        return accountNumber;
    }

    public static int nextAccountNumber(){
        return ++accountNumber;
    }

    public static void resetNumber(){
        accountNumber = 0;
    }
}
