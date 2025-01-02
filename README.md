# Board Game 

This project is a Java-based simple board game simulation I developed as part of my 2nd-year Data Structures and Algorithms course. The game's objective is to create a board and place different types of pieces on it, which can move according to specific rules based on their type.

## Table of Contents
- [Description](#description)
- [Features](#features)
- [Setup](#setup)
- [Usage](#usage)
- [Example Commands](#example-commands)
- [Sample Run](#sample-run)

---

## Description

This project simulates a simple board game on an 8x8 grid using object-oriented programming in Java. Each piece has a name, color, and movement ability based on its type (slow, fast, flexible, etc.). The board can display the positions and types of pieces, which can be moved left, right, up, or down depending on their flexibility and speed.

## Features

- **Piece Classes**: Different classes for pieces that move in various directions.
      - "Fast" pieces can move by any number of steps.
      - "Flexible" pieces can move up, down, left, or right.
      - "Slow" pieces can move only 1 step at a time.
      - "Non-Flexible" pieces are the default, and can only move move left or right.
  These tags can be combined and interchanged to create 4 types of pieces:
      - Slow, Fast, Slow-Flexible, Fast-Flexible
- **Game Board**: An 8x8 grid that tracks the position and type of each piece.
- **User Interaction**: Accepts commands to create pieces, move pieces, display the board, and more.
- **Validation**: Checks if moves are valid and if positions on the board are occupied.

## Setup

## Prerequisites
- Java Development Kit (JDK) version 8 or later.
- A terminal or command prompt to run the program.

### Example Commands

Here are some commands you can use:

    Creating a Piece:
    create 3 3 fast flexible

This will create a fast, flexible piece at location (3, 3) on the board.

    Moving a Piece:
    move 3 3 right 2

Move the piece at (3, 3) two spaces to the right.

    Displaying the Board:
    print

    Getting Help:
    help

    Exiting the Game:
    exit

### Sample Run

    Enter a command (type help for details):
    help
    Possible commands are:
    create location [fast][flexible]
    move location direction [spaces]
    print
    help
    exit
    
    Enter a command (type help for details):
    create 3 3 fast flexible
    Input a name for the new piece:
    Jedi
    Input a colour for the new piece:
    Red
    
    Enter a command (type help for details):
    print
    - - - - - - - -
    - - - JediRedFF - - - -
    - - - - - - - -
    - - - - - - - -
    - - - - - - - -
    
    Enter a command (type help for details):
    move 3 3 up 2
    Piece at (3,3) moved up by 2 spaces
    
    Enter a command (type help for details):
    print
    - - - - - - - -
    - - - - - - - -
    - - - JediRedFF - - - -
    - - - - - - - -
    - - - - - - - -
    
    Enter a command (type help for details):
    exit
    Done.
