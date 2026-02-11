# Builder Pattern – Step by Step Example

The Builder pattern is a **creational design pattern** that allows you to construct **complex objects step by step**, separating the construction process from the final representation.

This pattern is especially useful when an object has **many optional parameters** or when different representations of the same object are needed.

---

## 🎯 Use Case

Imagine we want to create a `House` object with multiple optional parts. This is a simplified example:

* `material`
* `garden`
* `pool`
* `garage`

Not every house has all these elements, and using a constructor with many parameters would make the code hard to read and difficult to maintain.

---

## 🛠️ Step-by-Step Explanation

### 1️⃣ Step 1: Define the Product and the Builder

```java
public class House {

    private String direction;
    private String material;
    private boolean hasGarden;
    private boolean hasPool;
    private boolean hasGarage;

    private House(HouseBuilder builder) {
        this.direction = builder.direction;
        this.material = builder.material;
        this.hasGarden = builder.hasGarden;
        this.hasPool = builder.hasPool;
        this.hasGarage = builder.hasGarage;
    }

    public static class HouseBuilder {

        private String direction;
        private String material;
        private boolean hasGarden;
        private boolean hasPool;
        private boolean hasGarage;

        public HouseBuilder direction(String direction) {
            this.direction = direction;
            return this;
        }

        public HouseBuilder material(String material) {
            this.material = material;
            return this;
        }

        public HouseBuilder garden(boolean hasGarden) {
            this.hasGarden = hasGarden;
            return this;
        }

        public HouseBuilder pool(boolean hasPool) {
            this.hasPool = hasPool;
            return this;
        }

        public HouseBuilder garage(boolean hasGarage) {
            this.hasGarage = hasGarage;
            return this;
        }

        public House build() {
            return new House(this);
        }
    }
}
```

* `House` is the **complex object** we want to build.
* The constructor is private and receives a `HouseBuilder`.
* The static `HouseBuilder` class contains all the construction logic.
* Method chaining makes the creation process clear and readable.

---

### 2️⃣ Step 2: (Optional) Director

```java
public class HouseDirector {

    public static House createHouse(String typeHouse) {

        House.HouseBuilder builder = new House.HouseBuilder();

        switch (typeHouse.toLowerCase()) {
            case "luxuryhouse":
                return builder
                        .direction("North")
                        .material("Bricks")
                        .garage(true)
                        .garden(true)
                        .pool(true)
                        .build();

            case "lowpricehouse":
                return builder
                        .direction("South")
                        .material("Wood")
                        .garage(false)
                        .garden(false)
                        .pool(false)
                        .build();

            default:
                throw new IllegalArgumentException("Unknown house type");
        }
    }
}
```

* The Director defines **predefined construction sequences**.
* It is optional but useful when you need standard or reusable configurations.

---

### 3️⃣ Step 3: Use the Builder

```java
House house = new House.HouseBuilder()
        .direction("East")
        .material("Concrete")
        .garage(true)
        .garden(true)
        .build();
```

* The client controls **which parts are built**.
* No complex constructors are needed.
* The resulting code is expressive and easy to understand.

---

## 🔍 When to Use Builder

* Objects have **many optional parameters**
* You need different representations of the same object
* You want better control over the construction process

---

## 💡 Summary

* **Purpose:** Build complex objects step by step.
* **Benefits:** Readability, flexibility, better separation of concerns.
* **Typical Use Cases:** Configuration objects, complex domain models, immutable objects.
* **Key Idea:** Separate object construction from its representation.

With the Builder pattern, object creation becomes **clear, flexible, and maintainable**.
