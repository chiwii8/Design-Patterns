# Composite Pattern – Step by Step Example

The Composite pattern is a **structural design pattern** that allows you to compose objects into **tree-like structures** to represent part–whole hierarchies.

This pattern lets clients treat **individual objects and compositions of objects uniformly**.

---

## 🎯 Use Case

Imagine we are building a system to manage **products in a package**.  
Each product has:

- A way to **read or display information**
- A **total price**

Some products are **simple items** (like a `Painting`), while others can be **composed of multiple products** (a package containing several products).

Using the Composite pattern, both **single products and product groups** can be treated in the same way.

---

## 🛠️ Step-by-Step Explanation

### 1️⃣ Step 1: Define the Component Interface

```java
public interface Component {
    void Read();
    double TotalPrice();
}
```

* This interface defines **common operations** for all components.

Both simple and composite objects will implement this interface.

### 2️⃣ Step 2: Implement Leaf Components

```java
public abstract class Product implements Component{
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
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

public class Paint extends Product{
    private String color;

    public Paint(String name, double price, String color) {
        super(name, price);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return super.toString() + " Paint{" +
                "color='" + color + '\'' +
                '}';
    }
}

```

* Product and Painting are leaf nodes in the composite structure.

* They do not contain other components.

* Painting is a specific type of Product.

### 3️⃣ Step 3: Implement the Composite

```java
public class CompoundPacket implements Component{
    private List<Component> componentList;

    public CompoundPacket(){
        this.componentList = new ArrayList<>();
    }

    public void addComponent(Component product){
        componentList.add(product);
    }

    public void removeComponent(Component component){
        componentList.remove(component);
    }
    @Override
    public void Read() {
        System.out.println(this.toString());
    }

    @Override
    public double TotalPrice() {
        return componentList.stream()
                .mapToDouble(Component::TotalPrice)
                .sum();
    }

    ///Override method to return the list of component in the packet with name and individual price
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder("Packet List:\n");
        if(componentList.isEmpty())
            builder.append("Empty");
        else
            builder.append(
                    componentList.stream()
                    .map(Object::toString)
                            .collect(Collectors.joining("\n"))
            );

        return  builder.toString();
    }
}
```

* The composite contains **other components**.

* It implements the same interface as leaf objects.

* Operations are **delegated to child** components.

### Step 4: Use of Composite
```java
mainPacket = new CompoundPacket();
        secondaryPacket = new CompoundPacket();

        bluePaint = new Paint("Blue-Aquamarine",10.99,"Aquamarine-12434");
        redPaint = new Paint("Red-Blood",15.32,"Red-23421");
        greenPaint = new Paint("Green-wood",5.23,"Green-11111");

        ///Add in the Packet
        mainPacket.addComponent(redPaint);
        secondaryPacket.addComponent(bluePaint);
        secondaryPacket.addComponent(greenPaint);


        mainPacket.addComponent(secondaryPacket);
        mainPacket.addComponent(new CompoundPacket());
        ///Verify Result
        System.out.println("Secundary Packet");
        secondaryPacket.Read();
        System.out.println("Total Price:" + secondaryPacket.TotalPrice() + "\n");

        System.out.println("Main Packet");
        mainPacket.Read();
        System.out.println("Total Price: " +mainPacket.TotalPrice());
```

* The client treats single objects and composites in the same way.

* No special logic is required to handle groups or individual items.

## 🔍 When to Use Composite

* You want to represent part–whole hierarchies.

* You want clients to treat individual and composite objects uniformly.

* You want to work with tree structures.

## 💡 Summary

* **Purpose**: Compose objects into tree structures and work with them uniformly.

* **Benefits**: Simpler client code, easy extensibility, consistent behavior.

* **Typical Use Cases**: File systems, UI components, product catalogs, graphics editors.

* **Key Idea**: Treat individual objects and compositions in the same way.

With the Composite pattern, your code becomes cleaner, more flexible, and easier to extend, especially when working with hierarchical structures.
