package br.com.p3d50.functionalinterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {

    public static void main(String[] args) {

        Customer maria = new Customer("Mary","9999999999");
        greetCustomer(maria);
        System.out.println();
        greetCustomerConsumer.accept(maria);
        System.out.println();
        greetCustomerConsumerWithDynamicPhoneNumber.accept(maria,false);
        greetCustomerConsumerWithDynamicPhoneNumber.accept(maria,true);
    }

    //declarative approach
    static Consumer<Customer> greetCustomerConsumer =
            (customer)-> System.out.printf("Hello %s, thanks for registering phone number %s",customer.name,customer.phoneNumber);

    static BiConsumer<Customer,Boolean> greetCustomerConsumerWithDynamicPhoneNumber =
            (customer, showProneNumber)-> System.out.println("Hello "+customer.name+", " +
                    "thanks for registering phone number " +
                    (showProneNumber?customer.phoneNumber:"*********"));

    //imperative approach
    static void greetCustomer(Customer customer){

        System.out.printf("Hello %s, thanks for registering phone number %s",customer.name,customer.phoneNumber);
    }

    static class Customer{
          private final String name;
          private final String phoneNumber;

        public Customer(String name, String phoneNumber) {
            this.name = name;
            this.phoneNumber = phoneNumber;
        }
    }

}
