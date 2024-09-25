# Exercise One: Design Patterns Demonstration

This project demonstrates the implementation of six design patterns through coding, showcasing two use cases for each category: behavioral, creational, and structural design patterns.

## Table of Contents
1. [Behavioral Design Patterns](#behavioral-design-patterns)
   - [Observer Pattern](#observer-pattern)
   - [Command Pattern](#command-pattern)
2. [Creational Design Patterns](#creational-design-patterns)
   - [Singleton Pattern](#singleton-pattern)
   - [Factory Method Pattern](#factory-method-pattern)
3. [Structural Design Patterns](#structural-design-patterns)
   - [Adapter Pattern](#adapter-pattern)
   - [Decorator Pattern](#decorator-pattern)
4. [How to Run the Code](#how-to-run-the-code)
5. [Best Practices](#best-practices)

## Behavioral Design Patterns

### Observer Pattern
- **Scenario**: A weather station system that notifies multiple displays (mobile, TV, computer) when the weather changes.
- **Implementation**: 
  - A `WeatherStation` class stores the current weather.
  - The `Observer Pattern` is used to notify display devices when the weather changes. Displays subscribe to the weather station, and when the weather is updated, all displays are notified.

### Command Pattern
- **Scenario**: A remote control that sends commands to devices (like TV, lights, etc.).
- **Implementation**:
  - Create a `Command` interface with methods like `execute()` and `undo()`.
  - Implement concrete commands like `TurnOnTVCommand` and `TurnOffLightCommand`.
  - A `RemoteControl` class holds commands and triggers them when a button is pressed.

## Creational Design Patterns

### Singleton Pattern
- **Scenario**: A logging system where only one instance of the logger should exist across the entire application.
- **Implementation**:
  - Create a `Logger` class with a private constructor and a static method to return the single instance.
  - Ensure that no new logger instance can be created.

### Factory Method Pattern
- **Scenario**: A document editor that can create different types of documents (Word, PDF, Spreadsheet).
- **Implementation**:
  - Create a `DocumentFactory` class that returns different document objects based on input (e.g., `createDocument("PDF")` returns a `PDFDocument`).
  - Each document (like `WordDocument` and `PDFDocument`) is a subclass of a base `Document` class.

## Structural Design Patterns

### Adapter Pattern
- **Scenario**: An application that needs to integrate with two different payment gateways (Stripe and PayPal) but they have different APIs.
- **Implementation**:
  - Use the `Adapter Pattern` to create an adapter that makes both payment gateways work with a unified interface.
  - Implement adapters like `StripeAdapter` and `PayPalAdapter` to convert the requests to each payment system’s API.

### Decorator Pattern
- **Scenario**: A coffee shop where you can add various toppings (milk, sugar, whipped cream) to a coffee order.
- **Implementation**:
  - Create a base `Coffee` class and concrete classes for different types of coffee.
  - Use decorators like `MilkDecorator` and `SugarDecorator` to dynamically add toppings to the coffee.

## How to Run
Each design pattern example can be run independently. Simply compile and execute the corresponding Java file for the specific design pattern you wish to test.

