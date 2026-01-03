package com.library.ch1.duck;

import com.library.ch1.behavior.FlyWithWings;
import com.library.ch1.behavior.Quack;

public class MallardDuck extends Duck {

  public MallardDuck() {
    quackBehavior = new Quack();
    flyBehavior = new FlyWithWings();
  }

  @Override
  public void display() {
    System.out.println("저는 물오리입니다.");
  }
}
