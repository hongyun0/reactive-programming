package com.study.spring.reactiveprogramming;

import java.util.Iterator;

public class IterableExample {
  public static void main(String[] args) {
    var iterable = new Iterable<Integer>() {
      @Override
      public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
          final int MAX = 10;
          int i = 0;

          @Override
          public boolean hasNext() {
            return i < MAX;
          }

          @Override
          public Integer next() {
            return ++i;
          }
        };
      }
    };

    for (int i : iterable) {
      System.out.println(i);
    }

  }
}
