package br.com.p3d50.functionalinterface;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class _Predicate {

    public static void main(String[] args) {
        System.out.println("without predicate");
        System.out.println(isPhoneNumberValid("07000000000"));
        System.out.println(isPhoneNumberValid("0700000000"));
        System.out.println(isPhoneNumberValid("09987800000"));

        System.out.println("with predicate");
        System.out.println(isPhoneNumberValidPredicate1
                .test("07000000000"));
        System.out.println(isPhoneNumberValidPredicate2
                .and(isPhoneNumberValidPredicate2).test("0700000000"));
        System.out.println(isPhoneNumberValidPredicate1
                .and(isPhoneNumberValidPredicate2).test("09987800000"));

        System.out.println("with bipredicate");
        System.out.println(isPhoneNumberWithAreaCodeValidPredicate
                .test("07","000000000"));
        System.out.println(isPhoneNumberWithAreaCodeValidPredicate
                .test("07","00000000"));
        System.out.println(isPhoneNumberWithAreaCodeValidPredicate
                .test("09","987800000"));

    }

    //with predicate
    static Predicate<String> isPhoneNumberValidPredicate1 = phoneNumber
            -> phoneNumber.startsWith("07") ;

    static Predicate<String> isPhoneNumberValidPredicate2 = phoneNumber
            -> phoneNumber.length() == 11;

    //with bipredicate
    static BiPredicate<String,String> isPhoneNumberWithAreaCodeValidPredicate =
            (ddd, phoneNumber)
            -> ddd.startsWith("07")&&phoneNumber.length()==9;



    //without predicate
    static boolean isPhoneNumberValid(String phoneNumber){
        return phoneNumber.startsWith("07") && phoneNumber.length() ==11;
    }


}
