# Java Ecommerce System

## Overview

This project is a simple yet robust **Ecommerce System** implemented in Java. It demonstrates strong **Object-Oriented Programming (OOP)** principles, adherence to **SOLID** design principles, and the use of classic **Design Patterns**. The system models a shopping cart, products (with expirable and shippable behaviors), customers, and a checkout process.

---

## Features

- **Product Management:** Supports products with different behaviors (expirable, shippable, or both).
- **Cart System:** Customers can add/remove products, and the cart validates stock and expiry.
- **Checkout Process:** Calculates subtotal, shipping fees, and total; handles payment and balance deduction.
- **Shipping Service:** Collects and displays shippable items and their weights.
- **Extensible Design:** Easily add new product behaviors or services.

---

## OOP Principles

- **Encapsulation:** Each class manages its own state and exposes only necessary methods.
- **Abstraction:** Interfaces (`IExpirable`, `IShippable`) abstract product behaviors.
- **Inheritance & Polymorphism:** Concrete classes (`ExpirableProduct`, `NotExpirable`, `ShippableProduct`, `NotShippable`) implement interfaces, allowing flexible behavior assignment.
- **Composition:** Products are composed with behavior objects (Strategy Pattern).

---

## SOLID Principles

- **Single Responsibility:** Each class has one responsibility (e.g., `CartDisplay` only handles displaying cart info).
- **Open/Closed:** New behaviors (e.g., new shipping or expiry logic) can be added without modifying existing code.
- **Liskov Substitution:** All implementations of interfaces can be used interchangeably.
- **Interface Segregation:** Interfaces are specific and focused (`IExpirable`, `IShippable`).
- **Dependency Inversion:** High-level modules depend on abstractions, not concrete implementations.

---

## Design Patterns Used

- **Strategy Pattern:** Products delegate expirable and shippable behavior to strategy objects (`IExpirable`, `IShippable`).
- **Controller Pattern:** `CustomerController` manages customer actions, separating logic from data.
- **Builder Pattern:** `ShippingListBuilder` constructs lists of shippable items.
- **Service Pattern:** `ShippingService` encapsulates shipping-related operations.

---

## Example Usage

```java
Customer customer = new Customer("Youssef", 5000);

Product cheese = new Product("Cheese", 2.5, 15);
cheese.setExpirableBehavior(new ExpirableProduct(cheese.getName(), LocalDate.of(2025, 1, 23)));
cheese.setShippableBehavior(new ShippableProduct(cheese.getName(), 400));

CustomerController.addToCart(customer, cheese, 2);
App.checkout(customer, customer.getCart());
```

## Project Structure

- `src/cart` – Cart logic, display, validation, and calculation
- `src/customer` – Customer and controller logic
- `src/products` – Product base class and behaviors (expirable, shippable)
- `src/shipping` – Shipping services, builders, and views
- `src/App.java` – Main application entry point

---

## Conclusion

This project demonstrates clean, extensible, and maintainable Java code, following best practices in OOP, SOLID, and design patterns. It serves as a solid foundation for building more advanced ecommerce