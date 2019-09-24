package com.study.spring.reactiveprogramming;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.Executors;

@SuppressWarnings("deprecation")
public class ObservableRunnableExample {
  static class ObservableRunnable extends Observable implements Runnable {
    final int MAX = 10;

    @Override
    public void run() {
      for (int i = 1; i <= MAX; i++) {
        setChanged();
        notifyObservers(i);
      }
    }
  }

  public static void main(String[] args) {
    var observer = new Observer() {
      @Override
      public void update(Observable o, Object arg) {
        // not main thread
        System.out.println(Thread.currentThread().getName() + " " + arg);
      }
    };

    var observable = new ObservableRunnable();
    observable.addObserver(observer);

    var executor = Executors.newSingleThreadExecutor();
    executor.execute(observable);

    // run before update()
    System.out.println(Thread.currentThread().getName() + " EXIT");

    executor.shutdown();
  }
}
