# Minesweeper Game

## Overview

This is a classic **Minesweeper** game implemented in **Java**, with a graphical user interface built using **JavaFX**. The objective of Minesweeper is to clear a rectangular board containing hidden "mines" without detonating any of them. Using clues about the number of neighboring mines, the player must strategically open cells and flag potential mines to win the game.

## Features

- **Customizable grid size**: Choose between different board sizes for a varying level of difficulty.
- **Flagging system**: Right-click to flag cells that you suspect contain mines.
- **Timer**: Track how long it takes you to solve the puzzle.
- **Game-over detection**: If you click on a mine, the game is over!
- **Winning condition**: The game recognizes when you've successfully cleared the board.

## How to Play

1. **Run the Game**: Execute the Java program to start the game.
   
   ```bash
   java -jar Minesweeper.jar
   ```

2. **Game Rules**:
   - Left-click on cells to reveal them.
   - If you click on a cell containing a mine, the game ends.
   - The number displayed on a revealed cell shows how many mines are adjacent to that cell (up to 8).
   - Left-click the falg button and select cells where you think mines are hidden.
   - The game is won when all non-mine cells have been revealed and all mines are flagged.

## Installation

### Requirements

- **Java 8 or later**: Ensure you have the correct version of Java installed. You can download it [here](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).
- **Maven**: You need to have Maven installed. You can download it from [here](https://maven.apache.org/install.html).
- **JavaFX**: The `pom.xml` should already include the necessary JavaFX dependencies, so you won't need to install it manually.

### Running the Game

1. **Clone the repository** or download the project files.

2. **Navigate to the project folder** where the `pom.xml` is located.

3. **Build the project** using Maven:

   ```bash
   mvn clean install
   ```

4. **Run the game**:

   ```bash
   mvn exec:java -Dexec.mainClass=com.mycompany.campominado.CampoMinado
   ```

This will compile the code, resolve dependencies, and run the Minesweeper game.

If you want to package it into a `.jar` file, you can use the following Maven command:

```bash
mvn package
```

Then run the packaged `.jar` file:

```bash
java -jar target/campominado.jar
```
