# Interface vs Abstract Class in Java

This note explains both `interface` and `abstract class` in a deeper but still beginner-friendly way.
Both are used when we want to create a common structure for multiple classes, but they solve slightly different problems.

## 1. The Core Idea

### Abstract class

An abstract class is used when multiple classes are closely related and should share:

- common data
- common methods
- a common parent-child relationship

It is best when we want to say:

`These classes are different versions of the same kind of thing.`

Example:

- `Payment` can be an abstract class
- `UpiPayment`, `CardPayment`, and `CashPayment` are all kinds of payment

### Interface

An interface is used when we want to describe a capability, rule, or contract that different classes can follow.

It is best when we want to say:

`These classes may be very different, but they can all do this one thing.`

Example:

- `Playable` can be an interface
- `MusicPlayer`, `VideoPlayer`, and `Game` can all be playable

## 2. What They Have in Common

Both `interface` and `abstract class` are used to achieve abstraction.

Abstraction means:

`show the important rule, hide the full internal details`

### Similarities

Both can:

- define methods that child classes must provide
- help create a common design
- be used for code organization
- support polymorphism
- prevent direct use of an incomplete design

### Important shared idea

In both cases, we usually do not create an object from the base design itself.

- We do not create an object of an abstract class directly
- We also do not create an object of an interface directly

Instead, we create objects of classes that extend or implement them.

## 3. The Biggest Difference

The easiest way to remember the difference is this:

### Abstract class

`What something is`

It describes identity or family.

Example:

- `UpiPayment` is a `Payment`

### Interface

`What something can do`

It describes ability or behavior.

Example:

- `MusicPlayer` can `play`

So:

- abstract class = shared parent
- interface = shared ability

## 4. Abstract Class in Detail

An abstract class can contain both complete and incomplete parts.

That means it can have:

- normal methods with body
- abstract methods without body
- fields
- constructors

This makes abstract classes useful when child classes need shared code.

### Example from this project

In [`AbstractClassExample.java`](/Users/rohan/Desktop/Rohan%20Desktop/Classes/ananya%20java%20sessions/ananya-java-sessions/Project%201/src/AbstractClassExample.java), the abstract class is:

```java
abstract class Payment
```

It has:

- a field: `payerName`
- a constructor: `Payment(String payerName)`
- a normal method: `startPayment()`
- an abstract method: `pay(double amount)`

This design says:

- every payment should have payer information
- every payment may use the same starting flow
- every payment must define its own payment logic

That is why `UpiPayment` extends `Payment` and writes its own `pay()` method.

### Why abstract class is useful

Use an abstract class when:

- child classes belong to the same family
- you want code reuse
- you want shared data
- you want some common implementation
- you want to force subclasses to complete missing behavior

## 5. Interface in Detail

An interface mainly defines a contract.

It tells classes:

`If you implement me, you must provide these behaviors.`

An interface is very useful when classes are not strongly related by family, but should all follow the same rule.

### Example from this project

In [`InterfaceExample.java`](/Users/rohan/Desktop/Rohan%20Desktop/Classes/ananya%20java%20sessions/ananya-java-sessions/Project%201/src/InterfaceExample.java), the interface is:

```java
interface Playable
```

It defines:

```java
void play();
```

Then `MusicPlayer` implements `Playable`.

This design says:

- any class that is playable must define `play()`
- the interface does not care whether the object is a song player, game, or video player

### Why interface is useful

Use an interface when:

- you want to define a common ability
- classes are not necessarily from the same family
- you want flexibility
- you want a class to follow multiple contracts

## 6. Side-by-Side Comparison

| Feature | Abstract Class | Interface |
| --- | --- | --- |
| Meaning | Shared parent/base type | Shared ability/contract |
| Relationship | Strong "is-a" relationship | Ability/rule-based relationship |
| Methods | Can have abstract and normal methods | Mainly contract methods |
| Fields | Can have instance variables | Does not store normal object state like a class |
| Constructors | Yes | No |
| Code reuse | Strong support | Limited compared to abstract class |
| Inheritance count | A class can extend only one class | A class can implement multiple interfaces |
| Best for | Closely related classes | Common behavior across different classes |

## 7. Similarities Explained More Deeply

People often think `interface` and `abstract class` are completely different, but they are actually similar in purpose.

Both help us write better object-oriented code by:

- reducing duplication
- setting rules for future classes
- making code easier to expand
- allowing one variable type to refer to many different objects

### Example of shared benefit: polymorphism

Suppose multiple classes implement the same interface, or multiple subclasses extend the same abstract class.

Then we can write flexible code like:

```java
Playable item = new MusicPlayer("Believer");
item.play();
```

or:

```java
Payment payment = new UpiPayment("Ananya");
payment.startPayment();
payment.pay(1500);
```

In both cases, the reference uses the general type, while the object uses the specific implementation.

That is one of the biggest strengths of both concepts.

## 8. Differences Explained More Deeply

### Difference 1: Shared state

An abstract class can store object data such as:

- `name`
- `id`
- `price`
- `payerName`

This is useful when subclasses need the same fields.

An interface is not meant to act like a shared data-holding parent in the same way.

### Difference 2: Shared implementation

An abstract class is ideal when you want to write common code once and let all subclasses reuse it.

Example:

- every payment may start with `startPayment()`

That code is written once in the parent and reused.

An interface is more about requiring behavior than sharing a full common implementation.

### Difference 3: Flexibility

A class can extend only one class, including one abstract class.

But a class can implement multiple interfaces.

This makes interfaces more flexible when a class needs many abilities.

Example:

- a class may be `Playable`, `Downloadable`, and `Shareable` at the same time

That is much harder to represent with abstract classes alone.

### Difference 4: Type of design question

Ask this question:

`Am I defining a family, or am I defining an ability?`

If it is a family:

- use abstract class

If it is an ability:

- use interface

## 9. Real-Life Analogy

### Abstract class analogy

Think of an abstract class like a vehicle blueprint for a specific family.

All vehicles in that family may share:

- engine number
- brand
- start behavior

But some behaviors may differ:

- how they move
- how much load they carry

### Interface analogy

Think of an interface like a skill badge.

If something has the `Flyable` badge, it must know how to fly.

That thing could be:

- a bird
- a drone
- an airplane

They are not the same kind of object, but they share the same ability.

## 10. When to Use Which One

### Use abstract class when

- classes are closely related
- you want shared fields
- you want constructors
- you want shared code
- you want partial implementation

### Use interface when

- you want to define behavior only
- unrelated classes need the same rule
- you want a class to support multiple abilities
- you want a clean contract

## 11. A Simple Decision Trick

Use this memory trick:

- abstract class = common base + shared code
- interface = common ability + rule

Or even shorter:

- abstract class = `is-a`
- interface = `can-do`

## 12. Applied to This Project

### In the abstract class example

[`AbstractClassExample.java`](/Users/rohan/Desktop/Rohan%20Desktop/Classes/ananya%20java%20sessions/ananya-java-sessions/Project%201/src/AbstractClassExample.java) shows `Payment` as a strong base concept.

That means:

- `UpiPayment` is a kind of `Payment`
- shared data belongs naturally in the parent
- shared behavior belongs naturally in the parent

### In the interface example

[`InterfaceExample.java`](/Users/rohan/Desktop/Rohan%20Desktop/Classes/ananya%20java%20sessions/ananya-java-sessions/Project%201/src/InterfaceExample.java) shows `Playable` as an ability.

That means:

- `MusicPlayer` is not a kind of `Playable` in the family sense
- it simply agrees to provide the `play()` behavior

## 13. Final Summary

Both `interface` and `abstract class` help us design better Java programs by creating common rules for multiple classes.

They are similar because both support abstraction, polymorphism, and cleaner code structure.

They are different because:

- an abstract class is for a shared parent with common state and behavior
- an interface is for a shared contract or ability

### One-line summary

`Abstract class` is used when classes are closely related and need shared code.

`Interface` is used when classes need to follow the same behavior rule, even if they are otherwise unrelated.
