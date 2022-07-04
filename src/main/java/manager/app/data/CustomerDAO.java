package manager.app.data;

import java.util.ArrayList;
import java.util.List;
import manager.app.model.Customer;

public class CustomerDAO {
    private static final List<Customer> customerList = new ArrayList<>();
    private static final List<String> customerEmailList = new ArrayList<>();

    public static List<Customer> getCustomerList() {
        return new ArrayList<>(customerList);
    }

    public static List<String> getCustomerEmailList() {
        return new ArrayList<>(customerEmailList);
    }

    public static void addCustomerToList(Customer customer) {
        customerList.add(customer);
    }

    public static void addEmailToList(String email) {
        customerEmailList.add(email);
    }

//    public static void resetCustomerList() {
//        customerList.clear();
//    }
//
//    public static void resetCustomerEmailList() {
//        customerEmailList.clear();
//    }

    public static Customer createCustomer(String firstName, String lastName, String email){
        Customer customer = new Customer(firstName, lastName, email);

        if(emailIsUnique(email)){
            customer.setEmail(email);
            customerEmailList.add(email);
        }
        else{
            customer.setEmail("email is missing");
        }

        return customer;
    }

    public static boolean emailIsUnique(String email){
        return !(customerEmailList.contains(email));
    }

    public static Customer searchById(int customerId){
        for (Customer customer : customerList) {
            if(customerId == customer.getId()){
                return customer;
            }
        }

        return null;
    }

    public static boolean removeCustomerFromList(int customerId){
        for (Customer customer : customerList) {
            if(customerId == customer.getId()){
                return customerList.remove(customer);
            }
        }

        return false;
    }
}