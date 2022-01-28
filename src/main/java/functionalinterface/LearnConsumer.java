package functionalinterface;

import java.util.function.Consumer;

public class LearnConsumer {

    static class Customer{

        private String name;
        private String phoneNumber;

        public Customer(String name, String phoneNumber) {
            this.name = name;
            this.phoneNumber = phoneNumber;
        }
    }

    static void greetCustomer(Customer customer){
        System.out.println("Hello" + customer.name +
                ". Thanks for registering phone number "+ customer.phoneNumber);
    }

    static Consumer<Customer> greetCustomerConsumer =
            customer -> System.out.println("Hello" + customer.name +
                    ". Thanks for registering phone number "+ customer.phoneNumber);

    public static void main(String[] args) {
        Customer maria = new Customer("Maria", "4399428490");

        //java Function
        greetCustomer(maria);

        //Consumer Functional Interface
        greetCustomerConsumer.accept(maria);
    }

}
