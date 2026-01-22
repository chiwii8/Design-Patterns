# Factory Method Pattern – Step by Step Example

The Factory Method pattern allows a class to **delegate the creation of objects** to subclasses or separate methods, making the code more flexible and scalable.

---

## 🎯 Use Case

We want to create different types of vehicles (`Car`, `Motorcycle`) without directly instantiating them in the client code.

* Each vehicle has a `drive()` and `parking()` method.
* The client should only interact with a common interface `Vehicle`.

---

## 🛠️ Step-by-Step Explanation

### 1️⃣ Step 1: Define a Vehicle Interface

```java
public interface Vehicle {
    public String drive();
    public String parking();
}
```

### 2️⃣ Step 2: Implement Concrete Vehicles

```java
public class Car implements Vehicle {

    @Override
    public String drive(){
        return "I'm driving my new car.";
    }

    @Override
    public String parking() {
        return "My car is parked";
    }
}

public class Motorcycle implements Vehicle{

    @Override
    public String drive() {
        return "I'm driving my new Motorcycle.";
    }

    @Override
    public String parking() {
        return "My Motorcycle is parked";
    }
}
```

### 3️⃣ Step 3: Create the Factory Method

```java
public abstract class CreatorVehicle {
    public abstract Vehicle CreateVehicle();
}

public class CreatorCar extends CreatorVehicle{
    @Override
    public Vehicle CreateVehicle() {
        return new Car();
    }
}

public class CreatorMotorcycle extends CreatorVehicle{
    @Override
    public Vehicle CreateVehicle() {
        return new Motorcycle();
    }
}

```

* The factory method `createVehicle()` is responsible for creating the appropriate vehicle.
* Each factory subclass knows how to create its specific vehicle.

### 4️⃣ Step 4: Use the Factory Method in Client Code

```java
VehicleFactory factory = new CarFactory();
Vehicle car = factory.createVehicle();
car.Drive(); // Driving a car

factory = new BikeFactory();
Vehicle motorcycle = factory.createVehicle();
motorcycle.Parking(); // Riding a bike
```

* The client code **does not know the concrete class**, only the interface.
* Adding new vehicle types requires **creating a new factory**, without changing existing client code.

---

## 💡 Summary

* **Purpose:** Define an interface for creating an object, letting subclasses decide which class to instantiate.
* **Benefits:** Flexible, extensible, follows the Open/Closed Principle.
* **Typical Use Cases:** Vehicle creation, document generation, GUI components, connections.

With the Factory Method pattern, your code is **easier to maintain and extend** while keeping object creation centralized and flexible.
