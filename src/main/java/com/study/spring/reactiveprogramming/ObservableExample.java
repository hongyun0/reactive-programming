package com.study.spring.reactiveprogramming;

import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("deprecation")
public class ObservableExample {
  public static void main(String[] args) {
    var observer = new Observer() {
      @Override
      public void update(Observable o, Object arg) {
        System.out.println(arg);
      }
    };

    var observable = new Observable() {
      public void publish(Object o) {
        setChanged();
        notifyObservers(o);
      }
    };

    observable.addObserver(observer);

    final int MAX = 10;
    for (int i = 1; i <= MAX; i++) {
      observable.publish(i);
    }
  }
}
