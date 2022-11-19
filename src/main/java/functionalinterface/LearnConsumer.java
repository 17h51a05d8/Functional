package functionalinterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class LearnConsumer {

    static class Customer{

        private final String name;
        private final String phoneNumber;

        public Customer(String name, String phoneNumber) {
            this.name = name;
            this.phoneNumber = phoneNumber;
        }
    }

    static void greetCustomer(Customer customer){
    	// Hellow world
        System.out.println("Hello" + customer.name +
                ". Thanks for registering phone number "+ customer.phoneNumber);
    }

    static Consumer<Customer> greetCustomerConsumer =
            customer -> System.out.println("Hello" + customer.name +
                    ". Thanks for registering phone number "+ customer.phoneNumber);

    static BiConsumer<Customer, Customer> customerSong = (cust1, cust2) -> {
        System.out.println("Na mai samjha, Na mai jaana, tumne jo bhi mujhse kaha hai "+ cust1.name);
        System.out.println("O " + cust2.name +" O " + cust2.name +" O "+cust2.name+" Oh Oo");
    };

    public static void main(String[] args) {
        Customer maria = new Customer("Maria", "4399428490");
        Customer senorita = new Customer("Senorita", "4399428490");

        //java Function
        greetCustomer(maria);

        //Consumer Functional Interface
        greetCustomerConsumer.accept(senorita);

        //BiConsumer Functional Interface
        customerSong.accept(senorita, maria);
    }

}
