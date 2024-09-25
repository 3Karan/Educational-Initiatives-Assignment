# Exercise Two: Mars Rover Simulation

## Overview
This project simulates a Mars rover's movement on a grid, allowing users to input commands and obstacles. The rover follows a set of commands to navigate the grid while avoiding obstacles and staying within bounds.

## Features
- Input for grid size, starting position, commands, and obstacles.
- Movement commands: Move Forward, Turn Left, Turn Right.
- Obstacle detection to prevent the rover from colliding with obstacles.
- Boundary checks to ensure the rover does not move out of the grid.

## How It Works
1. **User Input**: The program prompts the user for:
   - Grid size (width and height)
   - Starting position (coordinates and direction)
   - Movement commands (sequence of commands)
   - Number of obstacles and their positions

2. **Rover Movement**: The rover processes each command in sequence:
   - **Move Forward**: Moves the rover one step in the current direction unless obstructed.
   - **Turn Left/Right**: Changes the rover's direction.

3. **Obstacle and Boundary Handling**: If the rover encounters an obstacle or attempts to move out of bounds, the program logs the event and stops execution.



## How to Run
1. Compile the Java files in the project directory.
2. Execute the `Main` class to start the simulation.

### Example Command
```bash
javac Main.java
java Main
