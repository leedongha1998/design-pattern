package com.library.ch1.duck;

import com.library.ch1.behavior.FlyBehavior;
import com.library.ch1.behavior.QuackBehavior;

public abstract class Duck {
  QuackBehavior quackBehavior;
  FlyBehavior flyBehavior;

  public Duck() {
  }

  public void performQuack() {
    quackBehavior.quack();
  }

  public void performFly() {
    flyBehavior.fly();
  }

  public void swim(){
    System.out.println("모든 오리는 물에 뜹니다. 가짜 오리도 뜨죠");
  }

  public void display(){
    System.out.println("내가 진짜 오리");
  }

  public void setFlyBehavior(FlyBehavior flyBehavior){
    this.flyBehavior = flyBehavior;
  }

  public void setQuackBehavior(QuackBehavior quackBehavior){
    this.quackBehavior = quackBehavior;
  }
}
