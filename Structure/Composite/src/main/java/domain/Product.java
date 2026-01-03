package domain;

/**
 * Product.java
 * <p>
 * Description: Leaf class
 *
 * @author aleja
 * @since 02/01/2026
 */

public abstract class Product implements Component{
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public void Read() {
        System.out.println(this.toString());
    }

    @Override
    public double TotalPrice() {
        return getPrice();
    }

    @Override
    public String toString(){
        return "Product name: " + this.name + " Price: " + this.price;
    }
}
