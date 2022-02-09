package br.com.p3d50.functionalinterface;

import java.util.List;
import java.util.function.Supplier;

public class _Supplier {

    public static void main(String[] args) {
        System.out.println("without supplier");
        System.out.println(getConnectionUrl());
        System.out.println("with supplier");
        System.out.println(getConnectionUrlsSupplier.get());
    }

    //with supplier
    static Supplier<List<String>> getConnectionUrlsSupplier = ()
        -> List.of(
                "jdbc://localhost:5432/users",
                "jdbc://localhost:5432/customers");

    //without supplier
    static String getConnectionUrl(){
        return "jdbc://localhost:5432/users";
    }
}
