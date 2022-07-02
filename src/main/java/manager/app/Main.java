package manager.app;

import manager.app.data.BankAccountDAO;
import manager.app.data.CustomerDAO;
import manager.app.model.BankAccount;
import manager.app.model.Customer;

public class Main {
    public static void main(String[] args) {

        System.out.println(" Bank Management App Demo \n");


        CustomerDAO customerDAO = new CustomerDAO();
        BankAccountDAO bankAccountDAO = new BankAccountDAO();

        Customer customerA = customerDAO.createCustomer("Chris", "Lucky", "cl@email.com");
        BankAccount accountA_1 = bankAccountDAO.createBankAccount(customerA.getId(), 100);
        customerA.addAccountToList(accountA_1);
        BankAccount accountA_2 = bankAccountDAO.createBankAccount(customerA.getId(), 300);
        customerA.addAccountToList(accountA_2);
        BankAccount accountA_3 = bankAccountDAO.createBankAccount(customerA.getId(), 1000);
        customerA.addAccountToList(accountA_3);

        for(BankAccount bankAccount : customerA.getBankAccountList()){
            System.out.println("account No. " + bankAccount.getAccountNumber());
        }
        System.out.println(customerA.getCustomerInformation());


        double accBalance;

        accBalance = customerA.getBankAccountList().get(0).getBalance();
        System.out.println("Account balance of first is " + accBalance);

        accBalance = customerA.getBankAccountList().get(0).withdraw(30);
        System.out.println("Account balance after  withdrawal is " + accBalance);

        accBalance = customerA.getBankAccountList().get(0).withdraw(50);
        System.out.println("Account balance after  another withdrawal is " + accBalance);

        accBalance = customerA.getBankAccountList().get(1).getBalance();
        System.out.println("\nAccount balance of second account is " + accBalance);

        accBalance = customerA.getBankAccountList().get(2).getBalance();
        System.out.println("\nAccount balance of third account is " + accBalance);

    }
}