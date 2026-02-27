# Proxy Pattern – Step by Step Example

The Proxy pattern is a **structural design pattern** that provides a **placeholder or surrogate object** to control access to another object.

Instead of interacting directly with the real object, the client communicates through a proxy that can add additional behavior such as:

- Access control
- Logging
- Lazy initialization
- Caching

---

## 🎯 Use Case

Imagine we are working with a system that loads high-resolution paintings from disk.

Loading an image is expensive, so we don’t want to load it until it is really needed.

We create:

- `Shop` → Component interface
- `GameShop` → Game object seller
- `GameShopProxy` → Controls access and loads the Gameshop only when required

---

## 🛠️ Step-by-Step Explanation

---

### 1️⃣ Step 1: Define the Subject Interface

```java
public interface Shop {
    void buy(String item, double price);
}
```

* This is the common interface

* Both the real object and the proxy implement it

* The client depends only on this abstraction

### 2️⃣ Step 2: Create the Real Object

```java
public class GameShop implements Shop{

    @Override
    public void buy(String item, double price) {
        System.out.println("You buy " + item + " sucessfully with the cost of " + price);
    }
}
```

### 3️⃣ Step 3: Create the Proxy

```java
public class GameShopProxy implements Shop{
    private GameShop realShop;
    private double buyerMoney;

    public GameShopProxy(double buyerMoney) {
        this.buyerMoney = buyerMoney;
    }

    @Override
    public void buy(String item, double price) {
        if(buyerMoney>=price){
            realShop = new GameShop();
            realShop.buy(item,price);
            buyerMoney-=price;
            System.out.println("The player has " + buyerMoney + " left");
        }
        else
            System.out.println("You dont have enough money to buy that item");
    }
}
```

* The proxy controls acces to the real object.
* It implements lazy initialization(only calculate when needed)

### 4️⃣ Step 4: Use the Proxy
```java
public class Main {
    public static void main(String [] args){
        ///Define variables
        GameShopProxy gameShopProxy;
        double playerMoney;

        ///Initialize variables
        playerMoney = 20;
        gameShopProxy = new GameShopProxy(playerMoney);

        ///Buy
        gameShopProxy.buy("Wood",15);

    }
}
```

* The client interacts with the proxy as if it were the real shop
* The proxy handles object buy and access control.

### 🔍 Types of Proxies

Common variations of the Proxy pattern:

* Virtual Proxy → Lazy loading (like this example)

* Protection Proxy → Access control(like this example, required had the money to enter)

* Remote Proxy → Represents an object in another address space

* Cache Proxy → Stores results to avoid repeated work

### 🔍 When to Use Proxy

* You need lazy initialization

* You want to control or restrict access

* You need logging or monitoring

* You want to add caching behavior

### 💡 Summary

* **Purpose**: Control access to an object.

* **Benefits**: Performance optimization, security, separation of concerns.

* **Typical Use Cases**: Image loading, database connections, remote services, security layers.

* **Key Idea**: Wrap the real object with a proxy that adds control logic.