# Minesweeper

This project will teach you how to work with lists in Kotlin.
You will be dealing with algorithms for generating the minefield and processing the player moves.

## About

They say a minesweeper makes only two mistakes in their life: the first is their choice of occupation, and the second one is fatal.
In this project, you will create your own, safe "Minesweeper" – a game that will be a brain teaser for both you and your players.

## What you'll learn

Once you choose a project, we'll provide you with a study plan that includes all the necessary topics from your course to get it built.
Here’s what awaits you:

## Stage (1/5): Lay the groundwork

Generate your first game field with mines!

- Introduction to Kotlin
- Basic literals: numbers, strings and characters
- Writing first program
- Values and variables
- Constants and val variables
- Data types
- Standard output
- Invoking functions
- Standard input with Java Scanner
- String basics
- String templates
- Boolean type and operations. True and false
- Arithmetic operations
- Increment and decrement
- Properties of basic types
- Type conversion
- Reading data with readln
- When different types meet: type coercion
- Integers in action
- Comparing numbers. Relational operators
- If expression
- Loops: repeat statement
- Objects and their properties
- Structural vs referential equality
- Work with MutableLists
- Unicode
- Characters. Char type
- Ranges
- Working with strings
- Introduction to collections
- List
- For loop and ranges
- For loop and lists
- Multi-dimensional list

## Stage (2/5): Flexible mines

- Comments
- Kotlin style guide. Coding conventions
- Naming variables
- IDE
- Random
- IntelliJ IDEA
- IntelliJ IDEA basics
- JetBrains Academy plugin

## Stage (3/5): Look around you

- What is object-oriented programming
- Declaring functions
- Declaring classes
- When expression
- Functional decomposition
- Default arguments
- Named arguments
- Constructors
- Member functions
- Extension functions
- Encapsulation
- Property accessors

### Description

The player needs hints to be able to win, and we want them to have a chance to win!
Let's show the number of mines around the empty cells so that our players have something to work with.

### Objectives

As in the previous step, you need to initialize the field with mines.
Then, calculate how many mines there are around each empty cell.
Check 8 cells if the current cell is in the middle of the field, 5 cells if it's on the side, and 3 cells if it's in the corner.

If there are mines around the cell, display the number of mines (from 1 to 8) instead of the symbol representing an empty cell.
The symbols for empty cells and mines stay the same.

Check all the possibilities carefully.

### Examples

The greater-than symbol followed by a space (> ) represents the user input. Note that it's not part of the input.

**Example 1:**

```console
How many mines do you want on the field? > 10
.........
.111111..
.1X22X211
.112X33X1
...12X211
....1221.
..1111X1.
123X1222.
1XX211X1.
```

**Example 2:**

```console
How many mines do you want on the field? > 15
1221.....
2XX21....
X34X2..11
112X2..2X
11211..3X
1X1....2X
12321..11
12XX11232
X22211XXX
```

**Example 3:**

```console
How many mines do you want on the field? > 20
.2X3X23XX
13X43X3X3
1X3X32211
2232X1...
2X2221...
X32X1..11
X32331.1X
X21XX2.22
1113X2.1X
```
