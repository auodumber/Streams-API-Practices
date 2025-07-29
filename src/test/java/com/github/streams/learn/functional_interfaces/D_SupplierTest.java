package com.github.streams.learn.functional_interfaces;

import org.junit.jupiter.api.Test;

import java.util.function.IntFunction;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class D_SupplierTest {
    /**
     * Write a lambda expression that returns a new StringBuilder containing the string "abc".
     */
    @Test
    public void d_supplier1() {
        Supplier<StringBuilder> sup = () -> new StringBuilder("abc");

        assertEquals("abc", sup.get().toString());
    }

    /**
     * Write a lambda expression that returns a new, empty StringBuilder.
     */
    @Test
    public void d_supplier2() {
        Supplier<StringBuilder> sup = () -> new StringBuilder();

        assertEquals("", sup.get().toString());
    }

    /**
     * Write a constructor reference that returns a new, empty StringBuilder.
     */
    @Test
    public void d_supplier3() {
        Supplier<StringBuilder> sup = StringBuilder::new;

        assertEquals("", sup.get().toString());
    }


    /**
     * Write a method that takes an IntFunction and returns a Supplier.
     * An IntFunction takes an int as an argument and returns some object.
     * A Supplier takes no arguments and returns some object. The object
     * type in this case is a Shoe that has a single attribute, its size.
     * The goal is to write a lambda expression that uses the IntFunction
     * and size values provided as arguments, and that returns a Supplier
     * that embodies both of them. This is an example of a functional
     * programming concept called "partial application."
     */
    Supplier<Shoe> makeShoeSupplier(IntFunction<Shoe> ifunc, int size) {
        return () -> ifunc.apply(5435);
    }
    // Hint:
    // <editor-fold defaultstate="collapsed">
    // You don't want to return the result of calling the IntFunction.
    // Instead, you want to return a lambda that calls the IntFunction.
    // </editor-fold>

    static class Shoe {
        final int size;


        public Shoe(int size) {
            this.size = size;
        }
        public int hashCode() {
            return size ^ 0xcafebabe;
        }
        public boolean equals(Object other) {
            return (other instanceof Shoe) && this.size == ((Shoe) other).size;
        }
    }

    @Test
    public void h7_shoemaker() {
        Supplier<Shoe> sup1 = makeShoeSupplier((i ) -> new Shoe(9), 9);
        Supplier<Shoe> sup2 = makeShoeSupplier((j) -> new Shoe(13), 13);

        Shoe shoe1 = sup1.get();
        Shoe shoe2 = sup1.get();
        Shoe shoe3 = sup2.get();
        Shoe shoe4 = sup2.get();

        assertTrue(shoe1 != shoe2);
        assertTrue(shoe3 != shoe4);
        assertEquals(new Shoe(9), shoe1);
        assertEquals(shoe1, shoe2);
        assertEquals(new Shoe(13), shoe3);
        assertEquals(shoe3, shoe4);
    }
}
