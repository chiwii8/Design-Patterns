# Decorator Pattern – Step by Step Example

The Decorator pattern is a **structural design pattern** that allows you to **add new behavior to objects dynamically** by wrapping them with decorator classes.

This pattern provides a flexible alternative to subclassing for extending functionality.

---

## 🎯 Use Case

Imagine we are building a system to do **drink**, such as cafe.  
Each product has:

- A way to **read or display information**
- A **base price**

We want to add optional features to a product, such as:

- **Milk**
- **Chocolate**

These features should be **combinable**, and we want to avoid creating many subclasses like `CafeWithChocolateAndMilk`.

---

## 🛠️ Step-by-Step Explanation

### 1️⃣ Step 1: Define the Component Interface

```java
public interface Drink {
    String getDescription();
    double getPrice();
}
```

* This interface defines the base behavior.

* Both concrete components and decorators will implement this interface.

### 2️⃣ Step 2: Implement a Concrete Component

```java
public class Cafe implements Drink{
    @Override
    public String getDescription() {
        return "Cafe";
    }

    @Override
    public double getPrice() {
        return 1.5;
    }
}

```

* This is the core object that can be decorated.

* It provides the default behavior.

### 3️⃣ Step 3: Create the Base Decorator
```java
public abstract class DrinkDecorator implements Drink{
    protected Drink drink;

    public DrinkDecorator(Drink drink) {
        this.drink = drink;
    }

}

```
* The decorator wraps a component.

* It delegates calls to the wrapped object.

* Concrete decorators will extend this class.

### 4️⃣ Step 4: Implement Concrete Decorators

```java
public class Chocolate extends DrinkDecorator{
    public Chocolate(Drink drink) {
        super(drink);
    }

    @Override
    public String getDescription() {
        return drink.getDescription() + ", chocolate";
    }

    @Override
    public double getPrice() {
        return drink.getPrice() + 0.75;
    }
}
public class Milk extends DrinkDecorator{

    public Milk(Drink drink) {
        super(drink);
    }

    @Override
    public String getDescription() {
        return drink.getDescription() + ", milk";
    }

    @Override
    public double getPrice() {
        return drink.getPrice() + 0.5;
    }
}

```

* Each decorator adds extra behavior or cost.

* Decorators can be stacked in any order.

### 5️⃣ Step 5: Use the Decorator
```java
    Drink cafe = new Cafe();
    System.out.println(cafe.getDescription() + "-> " + cafe.getPrice());

    cafe = new Milk(cafe);
    cafe = new Chocolate(cafe);

    System.out.println(cafe.getDescription() + "-> " + cafe.getPrice());

```
* The client dynamically adds responsibilities to objects.

* No subclass explosion is needed.

* Behavior is added at runtime.

### 🔍 When to Use Decorator

* You want to add behavior to objects dynamically

* You want to avoid large inheritance hierarchies

* You want to combine behaviors in different ways

### 💡 Summary

* **Purpose**: Add responsibilities to objects dynamically.

* **Benefits**: Flexible design, open/closed principle, composability.

* **Typical Use Cases**: UI components, pricing systems, logging, streaming APIs.

* **Key Idea**: Wrap objects to extend behavior instead of subclassing.

With the Decorator pattern, your system becomes flexible, extensible, and easy to maintain, even when features grow over time.