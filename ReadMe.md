# Project Title

This is a simple command line interface connect four game. 

## Description

It is to be played on one computer where Player X goes first and Player O goes second. You can start a new game of load in an existing game. Throughout playing, you always have the option to save the current state of the board by entering '-1'. The player who acheives a four in a row horizontally, vertically, or diagonally wins!

## Getting Started

### Dependencies

* Java 11
* Junit 4.13
* Gradle 7.3/7.4.2

### Executing program

1. Build the program using Gradle.
```
gradle build
```
```
BUILD SUCCESSFUL in 4s
6 actionable tasks: 6 executed
```

2. Execute the gradle run command.
```
gradle run
```
```
> Task :run
To run the program:
java -cp build/classes/java/main connectfour.ConnectFour

BUILD SUCCESSFUL in 944ms
1 actionable task: 1 executed
```
3. Copy and paste the given command from the previous intruction.
```
java -cp build/classes/java/main connectfour.ConnectFour
```
```
-- Welcome to Connect 4! --

Choose one of the following options:
        1. Start a new game!
        2. Load a previous game.
Enter: 
```
And you're done! You can now play connect 4.

## Limitations

When attempting to load a previous game, in order to access saves from anywhere within the A2 folder you must input that file path to the desired save. Ensure you enter the path correctly, meaning from already within the A2 folder. \
An example of a correct path if the file is located within the assets folder is as follows (ensure the '/' at the end is included):
```
Choose one of the following options:
        1. Start a new game!
        2. Load a previous game.
Enter: 2

Enter the file path (the file must be within the A2 folder.): assets/
Enter the name of the file (extension included): exampleboard.csv
```
An example of a correct path if the file is located within the A2 folder, and is not in any sub directory is as follows (do no enter anything, no spaces or charcters; just press enter when prompted for file path):
```
Choose one of the following options:
        1. Start a new game!
        2. Load a previous game.
Enter: 2

Enter the file path (the file must be within the A2 folder.): 
Enter the name of the file (extension included): exampleboard.csv
```
If the file path of the name of the file is entered incorrectly you will be brought back to the menu with this message:
```
Choose one of the following options:
        1. Start a new game!
        2. Load a previous game.
Enter: 2

Enter the file path (the file must be within the A2 folder.): asets/
Enter the name of the file (extension included): exampleboard.csv
Could not find file.

Choose one of the following options:
        1. Start a new game!
        2. Load a previous game.
Enter: 
```
## Author Information

* NAME: Ankush Madharha
* EMAIL: amadharh@uoguelph.ca
* ID: 1172859




