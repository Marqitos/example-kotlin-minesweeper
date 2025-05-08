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

### Description

It's no fun when the field has the same setup every time and you know where all the mines are located.
Let's generate a random configuration every time the player wants to play the game.

To improve the program, we need to let the player choose how many mines they want on the field.
The player needs to input the number of mines they want with their keyboard.

## Objectives

Your program should ask the player to define the number of mines to add to a 9×9 field with the message "`How many mines do you want on the field?`".
It should then use the input to initialize the field and display it with the mines.
At this point, the mines are still visible to the player; you will hide them later.

Make sure to use the following marking symbols:

- `X` for mines
- `.` for safe cells

## Examples

The greater-than symbol followed by a space (`> `) represents the user input.
Note that it's not part of the input.

**Example 1:**

```console
How many mines do you want on the field? > 10
........X
........X
......X.X
X........
.........
......X..
XX......X
.........
.....X...
```

**Example 2:**

```console
How many mines do you want on the field? > 10
.........
.X.......
...X...XX
X........
.X.......
.........
.........
X......X.
...X....X
```

**Example 3:**

```console
How many mines do you want on the field? > 20
.X..XX...
.....XX.X
....XX...
....XX.XX
.X......X
.....X...
..X..XX..
.........
.X.....X.
```
