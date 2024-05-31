package com.interview.basic;


import java.util.function.Function;

public interface Validation {

    boolean validate(String value);

    default Validation and(Validation other) {
        return value -> {
            boolean result = this.validate(value);
            return result && other.validate(value);
        };
    }

    static Validation email() {
        return value -> {
            System.out.println("email");
            return value.contains("@");
        };
    }

    static Validation domain() {
        return value -> {
            System.out.println("domain");
            return value.contains("stateauto");
        };
    }
}
