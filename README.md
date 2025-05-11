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

## Stage (4/5): Prepare for battle

- Secondary constructor
- Enum

## Stage (5/5): Battle!

### Description

In this stage, you will upgrade your program to act just like the original Minesweeper game!
We won't show all the hints from the beginning anymore, but we will allow the player to explore the minefield by themselves, which is much more challenging and fun.
The game starts with an unexplored minefield that has a user-defined number of mines.
The player can:

- Mark unexplored cells as cells that potentially have a mine, and also remove those marks. Any empty cell can be marked, not just the cells that contain a mine. The mark is removed by marking the previously marked cell.
- Explore a cell if they think it does not contain a mine.

There are three possibilities after exploring a cell:

1. If the cell is empty and has no mines around, all the cells around it, including the marked ones, can be explored, and it should be done automatically.
Also, if next to the explored cell there is another empty one with no mines around, all the cells around it should be explored as well, and so on, until no more can be explored automatically.
2. If a cell is empty and has mines around it, only that cell is explored, revealing a number of mines around it.
3. If the explored cell contains a mine, the game ends and the player loses.

There are two possible ways to win:

1. Marking all the cells that have mines correctly.
2. Opening all the safe cells so that only those with unexplored mines are left.

### Objectives

In this final stage, your program should contain the following additional functionality:

1. Print the current state of the minefield starting with all unexplored cells at the beginning, ask the player for their next move with the message “`Set/unset mine marks or claim a cell as free:`”, treat the player's move according to the rules, and print the new minefield state.
Ask for the player's next move until the player wins or steps on a mine. The player's input contains a pair of cell coordinates and a command: `mine` to mark or unmark a cell, `free` to explore a cell.
2. If the player explores a mine, print the field in its current state, with mines shown as X symbols. After that, output the message “`You stepped on a mine and failed!`”.
3. Generate mines like in the original game: the first cell explored with the `free` command cannot be a mine; it should always be empty.
You can achieve this in many ways – it's up to you.

Use the following symbols to represent each cell’s state:

- `.` as unexplored cells
- `/` as explored free cells without mines around it
- Numbers from 1 to 8 as explored free cells with 1 to 8 mines around them, respectively
- `X` as mines
- `*` as unexplored marked cells

### Examples

The greater-than symbol followed by a space (`> `) represents the user input.
Note that it's not part of the input.

**Example 1:** *the user loses after exploring a cell that contains a mine*

```console
How many mines do you want on the field? > 10

 │123456789│
—│—————————│
1│.........│
2│.........│
3│.........│
4│.........│
5│.........│
6│.........│
7│.........│
8│.........│
9│.........│
—│—————————│
Set/unset mines marks or claim a cell as free: > 3 2 free

 │123456789│
—│—————————│
1│.1///1...│
2│.1//12...│
3│11//1....│
4│////1....│
5│11111....│
6│.........│
7│.........│
8│.........│
9│.........│
—│—————————│
Set/unset mines marks or claim a cell as free: > 1 1 free


 │123456789│
—│—————————│
1│11///1...│
2│.1//12...│
3│11//1....│
4│////1....│
5│11111....│
6│.........│
7│.........│
8│.........│
9│.........│
—│—————————│
Set/unset mines marks or claim a cell as free: > 1 2 mine

 │123456789│
—│—————————│
1│11///1...│
2│*1//12...│
3│11//1....│
4│////1....│
5│11111....│
6│.........│
7│.........│
8│.........│
9│.........│
—│—————————│
Set/unset mines marks or claim a cell as free: > 8 8 free


 │123456789│
—│—————————│
1│11///1...│
2│*1//12...│
3│11//1....│
4│////1....│
5│11111....│
6│.........│
7│.........│
8│.......1.│
9│.........│
—│—————————│
Set/unset mines marks or claim a cell as free: > 7 8 free

 │123456789│
—│—————————│
1│11///1...│
2│*1//12...│
3│11//1....│
4│////1....│
5│11111....│
6│.........│
7│.........│
8│......11.│
9│.........│
—│—————————│
Set/unset mines marks or claim a cell as free: > 6 8 free

 │123456789│
—│—————————│
1│11///1...│
2│*1//12...│
3│11//1....│
4│////1....│
5│11111....│
6│.........│
7│.........│
8│.....211.│
9│.........│
—│—————————│
Set/unset mines marks or claim a cell as free: > 2 7 free

 │123456789│
—│—————————│
1│11///1...│
2│*1//12...│
3│11//1....│
4│////1....│
5│11111....│
6│.........│
7│.3.......│
8│.....211.│
9│.........│
—│—————————│
Set/unset mines marks or claim a cell as free: > 5 6 free

 │123456789│
—│—————————│
1│11///1X..│
2│X1//12...│
3│11//1X...│
4│////1....│
5│11111....│
6│.X..X....│
7│.3X...X..│
8│.X..X211.│
9│...X.....│
—│—————————│
You stepped on a mine and failed!
```

**Example 2:** *the user wins by marking all mines correctly*

```console
How many mines do you want on the field? > 8

 │123456789│
—│—————————│
1│.........│
2│.........│
3│.........│
4│.........│
5│.........│
6│.........│
7│.........│
8│.........│
9│.........│
—│—————————│
Set/unset mines marks or claim a cell as free: > 5 5 free

 │123456789│
—│—————————│
1│..1//1...│
2│111//2...│
3│/////1...│
4│/////11..│
5│//////1..│
6│/111//1..│
7│23.1//111│
8│..21/////│
9│..1//////│
—│—————————│
Set/unset mines marks or claim a cell as free: > 2 1 mine

 │123456789│
—│—————————│
1│.*1//1...│
2│111//2...│
3│/////1...│
4│/////11..│
5│//////1..│
6│/111//1..│
7│23.1//111│
8│..21/////│
9│..1//////│
—│—————————│
Set/unset mines marks or claim a cell as free: > 3 7 mine

 │123456789│
—│—————————│
1│.*1//1...│
2│111//2...│
3│/////1...│
4│/////11..│
5│//////1..│
6│/111//1..│
7│23*1//111│
8│..21/////│
9│..1//////│
—│—————————│
Set/unset mines marks or claim a cell as free: > 2 8 mine

 │123456789│
—│—————————│
1│.*1//1...│
2│111//2...│
3│/////1...│
4│/////11..│
5│//////1..│
6│/111//1..│
7│23*1//111│
8│.*21/////│
9│..1//////│
—│—————————│
Set/unset mines marks or claim a cell as free: > 1 8 mine

 │123456789│
—│—————————│
1│.*1//1...│
2│111//2...│
3│/////1...│
4│/////11..│
5│//////1..│
6│/111//1..│
7│23*1//111│
8│**21/////│
9│..1//////│
—│—————————│
Set/unset mines marks or claim a cell as free: > 7 3 mine

 │123456789│
—│—————————│
1│.*1//1...│
2│111//2...│
3│/////1*..│
4│/////11..│
5│//////1..│
6│/111//1..│
7│23*1//111│
8│**21/////│
9│..1//////│
—│—————————│
Set/unset mines marks or claim a cell as free: > 8 3 free

 │123456789│
—│—————————│
1│.*1//1...│
2│111//2...│
3│/////1*1.│
4│/////11..│
5│//////1..│
6│/111//1..│
7│23*1//111│
8│**21/////│
9│..1//////│
—│—————————│
Set/unset mines marks or claim a cell as free: > 9 3 free

 │123456789│
—│—————————│
1│.*1//1...│
2│111//2.31│
3│/////1*1/│
4│/////111/│
5│//////111│
6│/111//1..│
7│23*1//111│
8│**21/////│
9│..1//////│
—│—————————│
Set/unset mines marks or claim a cell as free: > 8 6 mine

 │123456789│
—│—————————│
1│.*1//1...│
2│111//2.31│
3│/////1*1/│
4│/////111/│
5│//////111│
6│/111//1*.│
7│23*1//111│
8│**21/////│
9│..1//////│
—│—————————│
Set/unset mines marks or claim a cell as free: > 7 2 free

 │123456789│
—│—————————│
1│.*1//1...│
2│111//2231│
3│/////1*1/│
4│/////111/│
5│//////111│
6│/111//1*.│
7│23*1//111│
8│**21/////│
9│..1//////│
—│—————————│
Set/unset mines marks or claim a cell as free: > 7 1 mine

 │123456789│
—│—————————│
1│.*1//1*..│
2│111//2231│
3│/////1*1/│
4│/////111/│
5│//////111│
6│/111//1*.│
7│23*1//111│
8│**21/////│
9│..1//////│
—│—————————│
Set/unset mines marks or claim a cell as free: > 9 1 mine

 │123456789│
—│—————————│
1│.*1//1*.*│
2│111//2231│
3│/////1*1/│
4│/////111/│
5│//////111│
6│/111//1*.│
7│23*1//111│
8│**21/////│
9│..1//////│
—│—————————│
Congratulations! You found all the mines!
```

**Example 3:** *the user wins by exploring all safe cells*

```console
How many mines do you want on the field? > 5

 │123456789│
—│—————————│
1│.........│
2│.........│
3│.........│
4│.........│
5│.........│
6│.........│
7│.........│
8│.........│
9│.........│
—│—————————│
Set/unset mines marks or claim a cell as free: > 5 5 free

 │123456789│
—│—————————│
1│/////////│
2│/////111/│
3│111//1.1/│
4│..1//1.21│
5│111//1...│
6│/////1.21│
7│/////111/│
8│111//////│
9│..1//////│
—│—————————│
Set/unset mines marks or claim a cell as free: > 1 9 free

 │123456789│
—│—————————│
1│/////////│
2│/////111/│
3│111//1.1/│
4│..1//1.21│
5│111//1...│
6│/////1.21│
7│/////111/│
8│111//////│
9│1.1//////│
—│—————————│
Set/unset mines marks or claim a cell as free: > 1 4 free

 │123456789│
—│—————————│
1│/////////│
2│/////111/│
3│111//1.1/│
4│1.1//1.21│
5│111//1...│
6│/////1.21│
7│/////111/│
8│111//////│
9│1.1//////│
—│—————————│
Set/unset mines marks or claim a cell as free: > 7 4 free

 │123456789│
—│—————————│
1│/////////│
2│/////111/│
3│111//1.1/│
4│1.1//1121│
5│111//1...│
6│/////1.21│
7│/////111/│
8│111//////│
9│1.1//////│
—│—————————│
Set/unset mines marks or claim a cell as free: > 7 5 free

 │123456789│
—│—————————│
1│/////////│
2│/////111/│
3│111//1.1/│
4│1.1//1121│
5│111//11..│
6│/////1.21│
7│/////111/│
8│111//////│
9│1.1//////│
—│—————————│
Set/unset mines marks or claim a cell as free: > 8 5 free

 │123456789│
—│—————————│
1│/////////│
2│/////111/│
3│111//1.1/│
4│1.1//1121│
5│111//112.│
6│/////1.21│
7│/////111/│
8│111//////│
9│1.1//////│
—│—————————│
Congratulations! You found all the mines!
```
