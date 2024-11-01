# simple-java-boardGame


# Simple Board Game Simulation in Java

This project is a Java-based simple board game simulation developed as part of the **CSCI 2110 Data Structures and Algorithms** course. The objective of the game is to create a board and place different types of pieces on it, which can move according to specific rules based on their type.

## Table of Contents
- [Description](#description)
- [Features](#features)
- [Setup](#setup)
- [Usage](#usage)
- [Example Commands](#example-commands)
- [Sample Run](#sample-run)

---

## Description

This project simulates a simple board game on an 8x8 grid using object-oriented programming in Java. Each piece has a name, color, and movement ability based on its type (slow, fast, flexible, etc.). The board can display the positions and types of pieces, and pieces can be moved left, right, up, or down depending on their flexibility and speed.

## Features

- **Piece Classes**: Different classes for pieces that move in various directions.
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

Moves the piece at (3, 3) two spaces to the right.

    Displaying the Board:
    print

    Getting Help:
    help

    Exiting the Game:
    exit

### Sample Run

Here’s a sample interaction:

    Enter a command (type help for details):
    create 3 3 fast flexible
    Input a name for the new piece:
    Jedi
    Input a colour for the new piece:
    Red
    Enter a command (type help for details):
    print
    - - - - - - - -
    - - - - - - - -
    - - - - - - - -
    - - - JediRedFF - - - -
    - - - - - - - -
    - - - - - - - -
    - - - - - - - -
    - - - - - - - -
    Enter a command (type help for details):
    exit