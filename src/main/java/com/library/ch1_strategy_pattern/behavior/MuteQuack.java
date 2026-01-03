package com.library.ch1.behavior;

public class MuteQuack implements QuackBehavior {

  @Override
  public void quack() {
    System.out.println("조용!!");
  }
}
