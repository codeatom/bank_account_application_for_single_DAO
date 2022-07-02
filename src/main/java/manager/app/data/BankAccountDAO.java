package manager.app.data;

import manager.app.model.BankAccount;
import manager.app.model.Customer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BankAccountDAO {
    private static final List<BankAccount> bankAccountList = new ArrayList<>();

    public static List<BankAccount> getbankAccountList() {
        return new ArrayList<>(BankAccountDAO.bankAccountList);
    }

    public static void addBankAccountToList(BankAccount bankAccount) {
        BankAccountDAO.bankAccountList.add(bankAccount);
    }

    public static void resetBankAccountList() {
        BankAccountDAO.bankAccountList.clear();
    }

    public BankAccount createBankAccount(int customerId, double balance){
        BankAccount bankAccount = new BankAccount(customerId, balance);
        BankAccountDAO.bankAccountList.add(bankAccount);

        return bankAccount;
    }

    public BankAccount searchByAccountNumber(int accNumber){
        for (BankAccount bankAccount : BankAccountDAO.bankAccountList) {
            if(accNumber == bankAccount.getAccountNumber()){
                return bankAccount;
            }
        }

        return null;
    }

    public boolean bankAccountIsRemoved(int accNumber){
        for (BankAccount bankAccount : BankAccountDAO.bankAccountList) {
            if(accNumber == bankAccount.getAccountNumber()){
                return BankAccountDAO.bankAccountList.remove(bankAccount);
            }
        }

        return false;
    }

}
