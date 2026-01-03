package com.library.ch1;

import com.library.ch1.behavior.FlyRocketPowered;
import com.library.ch1.duck.Duck;
import com.library.ch1.duck.MallardDuck;
import com.library.ch1.duck.ModelDuck;

public class DuckMain {

  public static void main(String[] args) {
    Duck mallardDuck = new MallardDuck();
    mallardDuck.performQuack();
    mallardDuck.performFly();
    mallardDuck.display();
    mallardDuck.swim();

    System.out.println("===================");

    Duck modelDuck = new ModelDuck();
    modelDuck.performFly();
    modelDuck.setFlyBehavior(new FlyRocketPowered());
    modelDuck.performFly();
  }
}
