# About

Demonstrate Java nested class useage.

## Nested class are members of the enclosing class

- Nest classes are firstly members of enclosing class, which means:
  - Enclosing class determine the scope and access right of enclosing classes. For example, `private` nested classes can not be instantiated outside of enclosing class. Also, when instantiated out side of the enclosing class for `public` nested classes, `EnclosingClass.NestedClass` convention must be used.
  - Nested classes can access `private` members of enclosing class, just like other members, such as functions.

## Static nested classes

Static nested classes in Java is similar with nested classes in C++:
- Static nested classes do not contain `this` of the enclosing class, which means it can not access non-static members(instance members) of the enclosing class.
- Instantiation of static nested classes do not depend a instance of the enclosing class
- Except for the benifits:
  - Static nested classes can access `private static` memebers of enclosing class
  - Better encapulation inside the enclosing class
  and costs:
  - Outside of the enclosing class, enclosing class name has to be mentioned to instantiate a instance
  static nested classes are just normal classes.
- `static` key word in Java does not mean that it's only instantiated once. Static nested classes are also need instantiation.

## Non-static nested classes

Also called `inner classes`, non-static nested classes extend nested classed concept in C++:
- Inner classes `must` contain a `this` of a instance of the enclosing class, which means a inner class always belongs to a instance of enclosing class.
- Instantiation of inner classes depend a instance of enclosing class.