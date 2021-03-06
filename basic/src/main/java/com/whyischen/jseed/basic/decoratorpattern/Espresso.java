package com.whyischen.jseed.basic.decoratorpattern;

/**
 * 具体组件
 * <p>
 * 浓缩咖啡
 */
public class Espresso extends Beverage {

    public Espresso() {
        description = "Espresso";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}
