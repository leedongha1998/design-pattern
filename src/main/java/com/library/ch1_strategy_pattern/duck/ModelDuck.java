package com.library.ch1.duck;

import com.library.ch1.behavior.FlyNoWay;
import com.library.ch1.behavior.Quack;

public class ModelDuck extends Duck {

  public ModelDuck() {
    flyBehavior = new FlyNoWay();
    quackBehavior = new Quack();
  }

  public void display() {
    System.out.println("저는 모형 오리입니다.");
  }
}
