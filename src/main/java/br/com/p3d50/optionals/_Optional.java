package br.com.p3d50.optionals;


import java.util.Optional;
import java.util.function.Supplier;

public class _Optional {

    public static void main(String[] args) {

        Object value = Optional.ofNullable(null)
                        .orElseGet(()->"default value, orElseGet");
        System.out.println(value);

        Object value2 = Optional.ofNullable("Hello, orElseGet")
                .orElseGet(()->"default value");
        System.out.println(value2);

        Object value3 = Optional.ofNullable("Hello, orElseThrow")
                .orElseThrow(()->new IllegalStateException("Exeption"));
        System.out.println(value3);

        Supplier<IllegalStateException> illegalStateExceptionSupplier = ()
                -> new IllegalStateException("Exeption,orElseThrow");
        try {
            Optional.ofNullable(null)
                    .orElseThrow(illegalStateExceptionSupplier);
        }catch (IllegalStateException e){
            e.printStackTrace();
        }

        Optional.ofNullable("Hello, ifPresent")
                .ifPresent(System.out::println);

        Optional.ofNullable(null)
                .ifPresent(value5 -> {
                    System.out.println(value5);
                });

        Optional.ofNullable("p3d50@mail.com")
                .ifPresentOrElse(email ->{
                            System.out.println("Sendig email to "+email);
                        },
                        ()->{
                            System.out.printf("Cannot send email");
                        }
                );

        Optional.ofNullable(null)
                        .ifPresentOrElse(email ->{
                            System.out.println("Sendig email to "+email);
                        },
                            ()->{
                            System.out.printf("Cannot send email");
                            }
                        );

    }
}
