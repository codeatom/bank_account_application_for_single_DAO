package manager.app.data;

import manager.app.model.BankAccount;
import manager.app.model.Customer;
import java.util.ArrayList;
import java.util.List;

public class BankAccountDAO {
    private static final List<BankAccount> bankAccountList = new ArrayList<>();

    public static List<BankAccount> getBankAccountList() {
        return new ArrayList<>(BankAccountDAO.bankAccountList);
    }

    public static void addBankAccountToList(BankAccount bankAccount) {
        bankAccountList.add(bankAccount);
    }

//    public static void resetBankAccountList() {
//        BankAccountDAO.bankAccountList.clear();
//    }

    public static BankAccount createBankAccount(Customer customer, double balance){
        BankAccount bankAccount = new BankAccount(customer.getId(), balance);

        customer.addAccountToList(bankAccount);

        CustomerDAO.addCustomerToList(customer);
        BankAccountDAO.addBankAccountToList(bankAccount);

        return bankAccount;
    }

    public static BankAccount searchByAccountNumber(int accNumber){
        for (BankAccount bankAccount : bankAccountList) {
            if(accNumber == bankAccount.getAccountNumber()){
                return bankAccount;
            }
        }

        return null;
    }

    public static boolean removeAccountFromList(int accNumber){
        for (BankAccount bankAccount : bankAccountList) {
            if(accNumber == bankAccount.getAccountNumber()){
                return bankAccountList.remove(bankAccount);
            }
        }

        return false;
    }

    public static boolean closeAccount(Customer customer, int accNumber){
        for (BankAccount bankAccount : customer.getBankAccountList()) {
            if(accNumber == bankAccount.getAccountNumber()){
                bankAccount.withdraw(bankAccount.getBalance());

                customer.removeAccountFromList(bankAccount);
                bankAccountList.remove(bankAccount);

                return true;
            }
        }

        return false;
    }

}