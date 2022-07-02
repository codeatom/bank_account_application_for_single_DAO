package manager.app.data;

import java.util.ArrayList;
import java.util.List;
import manager.app.model.Customer;

public class CustomerDAO {
    private static final List<Customer> customerList = new ArrayList<>();
    private static final List<String> customerEmailList = new ArrayList<>();

    public static List<Customer> getCustomerList() {
        return new ArrayList<>(CustomerDAO.customerList);
    }

    public static List<String> getCustomerEmailList() {
        return new ArrayList<>(CustomerDAO.customerEmailList);
    }

    public static void addCustomerToList(Customer customer) {
        CustomerDAO.customerList.add(customer);
    }

    public static void addEmailToList(String email) {
        CustomerDAO.customerEmailList.add(email);
    }

    public static void resetCustomerList() {
        CustomerDAO.customerList.clear();
    }

    public static void resetcustomerEmailList() {
        CustomerDAO.customerEmailList.clear();
    }

    public Customer createCustomer(String firstName, String lastName, String email){
        Customer customer = new Customer(firstName, lastName, email);

        if(emailIsUnique(email)){
            customer.setEmail(email);
            CustomerDAO.customerEmailList.add(email);
        }
        else{
            customer.setEmail("email is missing");
        }

        CustomerDAO.customerList.add(customer);

        return customer;
    }

    public boolean emailIsUnique(String email){
        return !(CustomerDAO.customerEmailList.contains(email));
    }

    public Customer searchById(int customerId){
        for (Customer customer : CustomerDAO.customerList) {
            if(customerId == customer.getId()){
                return customer;
            }
        }

        return null;
    }

    public boolean customerIsRemoved(int customerId){
        for (Customer customer : CustomerDAO.customerList) {
            if(customerId == customer.getId()){
                return CustomerDAO.customerList.remove(customer);
            }
        }

        return false;
    }
}