
# Logical Calculator Code Analysis

## Overview

This Java code implements a basic graphical calculator with support for decimal, hexadecimal, and binary calculations.

## Key Components

- GUI Class:
- GUI extends JFrame and handles the overall GUI layout and user interactions.
- Components:
- JTextField: Displays entered numbers and results.
- JRadioButton: Selects the desired number system.
- JButton: Represents numbers, operators, and functions.
- Event Handling:
- The actionPerformed method responds to button clicks.
- Operations:
- Separate methods handle calculations for each number system:
- handleDecimalOperations()
- handleHexadecimalOperations()
- handleBinaryOperations() (currently incomplete)
- State Tracking:
- currentOperation: Tracks the active operation.
- memory: Stores intermediate results.

## Points to Consider

Demonstrates basic GUI programming and event handling.
Uses radio buttons for user input and separate methods for number systems.
Missing implementation for binary operations.
   
