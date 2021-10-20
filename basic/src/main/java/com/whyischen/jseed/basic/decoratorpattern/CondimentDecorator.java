package com.whyischen.jseed.basic.decoratorpattern;

/**
 * 抽象装饰者
 * <p>
 * 调料
 */
public abstract class CondimentDecorator extends Beverage {
    public abstract String getDescription();
}
