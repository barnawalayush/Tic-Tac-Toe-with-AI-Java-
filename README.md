# Tic-Tac-Toe with AI

The Tic Tac Toe Game Project is a classic implementation of the popular two-player board game. The game follows the traditional rules of Tic Tac Toe, where two players take turns on a 3x3 grid with their respective symbols, usually 'X' and 'O', aiming to create a row, column, or diagonal of their symbols.

## Description


Two players will be involved, that can be either 
- User play against other user
- User play against AI
- AI play against AI

### Different level at which AI plays
For computer to play, there are three level we have defined which computer can choose and that choice is entered by user.
- AI play at easy level
- AI play at medium level
- AI play at hard level

Following are the algorithms which is implemented at different levels for AI:

#### At Easy level 
AI chooses any random values for both coordinates between 1 and 3
For random selection of values, I implemented Random class 
````
  Random r = new Random();
  int computer_x_coordinate = r.nextInt(3) + 1;
````
#### At Medium level 
Here AI goes one step ahead to check its probability of winning

When the AI is playing at medium difficulty level, it makes moves using the following logic:

- If it already has two in a row and can win with one further move, it does so.
- If its opponent can win with one move, it plays the move necessary to block this.
- Otherwise, it makes a random move.
#### At Hard level 
Unlike medium, when the AI is playing at hard level, it doesn't just look one move ahead to see an immediate win or prevent an immediate loss. At this level, it can look two moves ahead, three moves ahead, and even further. It can calculate all possible moves that might be played during the game, and choose the best one based on the assumption that its opponent will also play perfectly. So, it doesn't rely on the mistakes of its opponent and plays the game without fault from start to finish regardless of the opponent's skill!

The algorithm that implements this is called `minimax`. It's a recursive brute force algorithm that maximizes the value of the AI's position and minimizes the worth of its opponent's.

### Input Command 
Input commands for providing player information are:

- User play against user

```
  Input command: > start user user
```
- User play against AI(easy level)

```
  Input command: > start user easy
```
- User play against AI(medium)

```
  Input command: > start user medium
```
- User play against AI(hard)

```
  Input command: > start user hard
```
- AI(easy) play against user

```
  Input command: > start easy user
```
- AI(medium) play against user

```
  Input command: > start medium user
```
- AI(hard) play against user

```
  Input command: > start hard user
```
- AI(easy) play against AI(hard)

```
  Input command: > start easy hard
```
- AI(easy) play against AI(easy)

```
  Input command: > start easy easy
```
- AI(hard) play against AI(hard)

```
  Input command: > start hard hard
```

#### On giving wrong input, it will again ask for input
```
  Input command: > start
  Bad parameters!
  Input command: > 
```

### How to Use it

-  Coordinates to be input by User
```
  Input command: > start user user 
  ---------
  |       |
  |       |
  |       |
  ---------
```
User can select number from 1(inclusive) to 3(inclusive) 
```
  Enter the coordinates: > 1 3
  ---------
  |     X |
  |       |
  |       |
  ---------
```
If he select wrong input then it again ask for coordinates

```
  Enter the coordinates: > 1 4
  Coordinates should be from 1 to 3!
```
If he/she inputs the coordinates which are already occupied
```
  Enter the coordinates: > 1 3
  This cell is occupied! Choose another one!
  Enter the coordinates: >
```
If user enter any letter instead of number
```
  Enter the coordinates: > one three
  You should enter numbers!
  Enter the coordinates: > one
  You should enter numbers!
  Enter the coordinates: >
```

## Link of project

 - [HyperSkill Tic-Tac_Toe with AI (Medium Level Project)](https://hyperskill.org/projects/81)

  - [Github](https://github.com/barnawalayush/Tic-Tac-Toe-with-AI-Java-)
