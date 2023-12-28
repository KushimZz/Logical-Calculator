# Logical-Calculator
This is a basic Logical Calculator Created in Java by using AWT and Swing for GUI.

## Class and Main Structure:

The code defines a class named GUI that extends JFrame and implements ActionListener.
The GUI() constructor initializes the GUI components and sets up event listeners.
The main method is not explicitly shown, but it would typically create an instance of the GUI class to launch the application.

## GUI Components:

JTextField for displaying entered numbers and results.
JRadioButton for selecting the number system (binary, decimal, hexadecimal).
Various JButton objects representing numbers, operators, and functions.

## Handling Button Clicks:

The actionPerformed method is the core of the calculator's functionality.
It identifies the clicked button and calls appropriate methods to perform operations or modify the displayed values.

## Operations and Logic:

The code defines separate methods for handling decimal, hexadecimal, and binary operations.
These methods perform arithmetic and bitwise operations based on the selected number system.
The currentOperation variable tracks the active operation.
The memory variable stores intermediate results.

## Key Points:

The code effectively demonstrates basic GUI programming and event handling in Java.
It showcases the use of radio buttons for user input and separate methods for handling different number systems.
The code could be further improved by:
Completing the handleBinaryOperations() method.
Implementing error handling for invalid input or operations.
Adding features like parentheses support, scientific notation, and memory functions.

## Dependencies
   -Java awt
     -Java Swing
   
