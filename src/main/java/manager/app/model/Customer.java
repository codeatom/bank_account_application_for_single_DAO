package manager.app.model;

public class Customer {
        private final int id;
        private String firstName;
        private String lastName;
        private String email;
        private int accountNumber;

        public Customer(int id, String firstName, String lastName, String email) {
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
        }

        public int getId() {
            return id;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public int getAccountNumber() {
            return accountNumber;
        }

        public void setAccountNumber(int accountNumber) {
            this.accountNumber = accountNumber;
        }

        public String getCustomerInformation(){
            return  "id: " + this.id +"\n"
                    + "First Name: " + this.firstName +"\n"
                    + "Last Name: " + this.lastName +"\n"
                    + "email: " + this.email +"\n"
                    + "accountNumber: " + accountNumber;
        }

       @Override
       public String toString() {
        return getCustomerInformation();
       }
}
