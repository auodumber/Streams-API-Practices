package com.github.streams.learn.functional_interfaces;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class C_ConsumerTest {
  /** Write a lambda expression that appends the string "abc" to the given StringBuilder. */
  @Test
  public void c_consumer1() {
    Consumer<StringBuilder> cons = str -> str.append("abc");

    StringBuilder sb = new StringBuilder("xyz");
    cons.accept(sb);
    assertEquals("xyzabc", sb.toString());
  }

  /** Write a lambda expression that clears the given list. */
  @Test
  public void c_consumer2() {
    Consumer<List<String>> cons = list -> list.clear();

    List<String> list = new ArrayList<>(List.of("a", "b", "c"));
    cons.accept(list);
    Assertions.assertTrue(list.isEmpty());
  }

  /** Write an unbound method reference that clears the given list. */
  @Test
  public void c_consumer3() {
    Consumer<List<String>> cons = List::clear;

    List<String> list = new ArrayList<>(List.of("a", "b", "c"));
    cons.accept(list);
    Assertions.assertTrue(list.isEmpty());
  }

  /**
   * Given two consumers, create a consumer that passes the String to the first consumer, then to
   * the second.
   */
  @Test
  public void c_consumer4() {
    Consumer<List<String>> c1 = list -> list.add("first");
    Consumer<List<String>> c2 = list -> list.add("second");

    Consumer<List<String>> consumer = new Consumer<List<String>>() {
      @Override
      public void accept(List<String> strings) {
        c1.accept(strings);
        c2.accept(strings);
      }
    };

    List<String> list = new ArrayList<>(List.of("a", "b", "c"));
    consumer.accept(list);
    assertEquals(List.of("a", "b", "c", "first", "second"), list);
  }

  @Test
  public void c_consumer5(){
    Consumer<List<String>> c1 = list -> list.add("last");
    Consumer<List<String>> c2 = list -> list.add("last-last");

    Consumer<List<String>> consumer1 = c1.andThen(c2);

    List<String> list = new ArrayList<>(List.of("X", "Y", "Z"));
    consumer1.accept(list);
    assertEquals(List.of("X", "Y", "Z", "last", "last-last"), list);
  }
}
