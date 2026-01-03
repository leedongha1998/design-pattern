package com.library.ch1.behavior;

public class FlyNoWay implements FlyBehavior{

  @Override
  public void fly() {
    System.out.println("저는 못 날아요");
  }
}
