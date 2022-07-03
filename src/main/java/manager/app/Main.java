package manager.app;

import manager.app.data.BankAccountDAO;
import manager.app.data.CustomerDAO;
import manager.app.model.BankAccount;
import manager.app.model.Customer;

public class Main {
    public static void main(String[] args) {

        System.out.println("Bank Account Management Application Demo \n");

        Customer customer = CustomerDAO.createCustomer("Chris", "Lucky", "cl@email.com");
        BankAccountDAO.createBankAccount(customer, 100);
        BankAccountDAO.createBankAccount(customer, 300);
        BankAccountDAO.createBankAccount(customer, 100);

        System.out.println("This customer's information is:");
        System.out.println(customer.getCustomerInformation());


        for(int i = 0; i < customer.getBankAccountList().size(); i++){
            System.out.println("account number of customer's account " + (i + 1) + " is: " + customer.getBankAccountList().get(i).getAccountNumber());
        }
        System.out.println("");

        double accBalance;

        accBalance = customer.getBankAccountList().get(0).getBalance();
        System.out.println("Account balance of customer's first account is " + accBalance + "kr");

        accBalance = customer.getBankAccountList().get(0).withdraw(30);
        System.out.println("Account balance of customer's first account after withdrawal is " + accBalance+ "kr");

        accBalance = customer.getBankAccountList().get(0).withdraw(50);
        System.out.println("Account balance of customer's first account after another withdrawal is " + accBalance+ "kr");

        customer.getBankAccountList().get(0).depositFund(100);
        accBalance = customer.getBankAccountList().get(0).getBalance();
        System.out.println("Account balance of customer's first account after a deposit " + accBalance+ "kr");

        accBalance = customer.getBankAccountList().get(1).getBalance();
        System.out.println("\nAccount balance of Customer's second account is " + accBalance+ "kr");

        customer.getBankAccountList().get(1).depositFund(200);
        accBalance = customer.getBankAccountList().get(1).getBalance();
        System.out.println("Account balance of customer's second account after a deposit " + accBalance+ "kr");

        accBalance = customer.getBankAccountList().get(2).getBalance();
        System.out.println("\nAccount balance of Customer's third account is " + accBalance+ "kr");
    }
}