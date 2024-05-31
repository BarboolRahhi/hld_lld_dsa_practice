package com.interview.exception_eg;

import java.io.IOException;

public class ExceptionEg {

    public static void main(String[] args) {
        var b = new B();
        b.show();
    }
}


class A {
    public void show()  {
        System.out.println("A : Show");
    }
}

class B extends A {
    @Override
    public void show() throws RuntimeException {}  {
        System.out.println("B : Show");
    }
}
