package notes.装饰者模式;

/**
 * 抽象组件
 * <p>
 * 饮料
 */
public abstract class Beverage {

    String description = "Unknow Beverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();

}
