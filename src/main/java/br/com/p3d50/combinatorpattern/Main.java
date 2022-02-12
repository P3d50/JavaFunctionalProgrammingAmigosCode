package br.com.p3d50.combinatorpattern;

import java.time.LocalDate;

public class Main {

    static CustomerValidatorService validatorService = new CustomerValidatorService();


    public static void main(String[] args) {
        Customer customer = new Customer(
                "Alice",
                "alice@mail.com",
                "+0898978987898",
                LocalDate.of(2006,1,1)
        );


        System.out.println(validatorService.isValid(customer));

        ValidationResult result = CustomerRegistrationValidator
                .isEmailValid()
                .and(CustomerRegistrationValidator.isPhoneNumberlValid())
                .and(CustomerRegistrationValidator.isAdult())
                .apply(customer);
        System.out.println(result);

        if(result!=ValidationResult.SUCCESS){
            throw new IllegalStateException(result.name());
        }

    }
}
