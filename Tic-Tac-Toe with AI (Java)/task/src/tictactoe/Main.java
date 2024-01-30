package tictactoe;

import java.sql.SQLOutput;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private static int move = 0;  // move == 0 --> X turn;   move == 1 --> O turn
    private static boolean X_WINS = false;   // if X wins then it become true
    private static boolean O_WINS = false;   // if O wins then it become true
    private static boolean DRAW = false;     // if none wins

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Input command:");

        //taking input command
        int command = takeInputCommand(sc);

        String str = "_________";
        int[][] board = new int[3][3];

        // for 'X' update value=1, for 'O' update value=-1 and for vacant places  update value=0;
        update_array(board, str);

        if(command != Constants.START_HARD_USER && command != Constants.START_HARD_HARD) show_current_board_status(board);

        // Calling function according to input commands
        if(command == Constants.START_EASY_EASY){
            playEayEasy(board, sc);
        }else if(command == Constants.START_EASY_USER){
            playEasyUser(board, sc);
        }else if(command == Constants.START_USER_USER){
            playUserUser(board, sc);
        }else if(command == Constants.START_USER_EASY){
            playUserEasy(board, sc);
        }else if(command == Constants.START_USER_MEDIUM){
            playUserMedium(board, sc);
        }else if(command == Constants.START_MEDIUM_USER){
            playMediumUser(board, sc);
        }else if(command == Constants.START_EASY_MEDIUM){
            playEasyMedium(board, sc);
        }else if(command == Constants.START_HARD_USER){
            playHardUser(board, sc);
        }else if(command == Constants.START_USER_HARD){
            playUserHard(board, sc);
        }else if(command == Constants.START_HARD_HARD){
            playHardHard(board, sc);
        }else if(command == 0)return;
    }



    // if programmer given input command as "start user hard" then this function going to implement   player1 = User and player2 = Computer playing at hard level
    private static void playUserHard(int[][] board, Scanner sc) {

        int check = 2;
        while(check==2){

            if(move == 0){
                System.out.print("Enter the coordinates:");
                takeUserInput(sc, board);
                move = 1-move;
            }else{
                System.out.println("Making move level \"hard\"");
                takeComputerHardInput(board, move);
                move = 1-move;
            }

            show_current_board_status(board);

            check = checkWinner(board);
            if(check == 0) System.out.println("Draw");
            else if(check == 1)System.out.println("X wins");
            else if(check == -1)System.out.println("O wins");
        }
    }

    // if programmer given input command as "start hard user" then this function going to implement   player1 = Computer playing at hard level and player2 = User
    private static void playHardUser(int[][] board, Scanner sc) {

        int check = 2;
        while(check==2){

            if(move == 0){
                System.out.println("Making move level \"hard\"");
                takeComputerHardInput(board, move);
                move = 1-move;
            }else{
                //show_current_board_status(board);
                System.out.print("Enter the coordinates:");
                takeUserInput(sc, board);
                move = 1-move;
            }

            show_current_board_status(board);

            check = checkWinner(board);
            if(check == 0) System.out.println("Draw");
            else if(check == 1)System.out.println("X wins");
            else if(check == -1)System.out.println("O wins");
        }
    }

    // if programmer given input command as "start hard hard" then this function going to implement   player1 = Computer playing at hard level and player2 = Computer playing at hard level
    private static void playHardHard(int[][] board, Scanner sc) {

        int check = 2;
        while(check==2){

            if(move == 0){
                System.out.println("Making move level \"hard\"");
                takeComputerHardInput(board, move);
                move = 1-move;
            }else{
                System.out.println("Making move level \"hard\"");
                takeComputerHardInput(board, move);
                move = 1-move;
            }

            show_current_board_status(board);

            check = checkWinner(board);
            if(check == 0) System.out.println("Draw");
            else if(check == 1)System.out.println("X wins");
            else if(check == -1)System.out.println("O wins");
        }
    }

    // if programmer given input command as "start easy user" then this function going to implement   player1 = Computer playing at easy level and player2 = User
    private static void playEasyUser(int[][] board, Scanner sc) {

        int check=2;
        while(check==2){

            if(move == 0){
                System.out.println("Making move level \"easy\"");
                takeComputerEasyInput(board, move);
                move = 1-move;
            }else{
                System.out.print("Enter the coordinates:");
                takeUserInput(sc, board);
                move = 1-move;
            }

            show_current_board_status(board);

            check = checkWinner(board);
            if(check == 0) System.out.println("Draw");
            else if(check == 1)System.out.println("X wins");
            else if(check == -1)System.out.println("O wins");
        }
    }

    // if programmer given input command as "start user medium" then this function going to implement  player1 = User and player2 = Computer playing at medium level
    private static void playUserMedium(int[][] board, Scanner sc) {

        int check=2;
        while(check==2){

            if(move == 0){
                System.out.println("Enter the coordinates:");
                takeUserInput(sc, board);
                move = 1-move;
            }else{
                System.out.println("Making move level \"medium\"");
                takeComputerMediumInput(board, move);
                move = 1-move;
            }

            show_current_board_status(board);

            check = checkWinner(board);
            if(check == 0) System.out.println("Draw");
            else if(check == 1)System.out.println("X wins");
            else if(check == -1)System.out.println("O wins");
        }
    }

    // if programmer given input command as "start medium user" then this function going to implement  player1 = Computer playing at medium level and player2 = User
    private static void playMediumUser(int[][] board, Scanner sc) {

        int check=2;
        while(check==2){

            if(move == 0){
                System.out.println("Making move level \"medium\"");
                takeComputerMediumInput(board, move);
                move = 1-move;
            }else{
                System.out.println("Enter the coordinates:");
                takeUserInput(sc, board);
                move = 1-move;
            }

            show_current_board_status(board);

            check = checkWinner(board);
            if(check == 0) System.out.println("Draw");
            else if(check == 1)System.out.println("X wins");
            else if(check == -1)System.out.println("O wins");
        }
    }

    // if programmer given input command as "start easy medium" then this function going to implement  player1 = Computer playing at easy level and player2 = Computer playing at medium level
    private static void playEasyMedium(int[][] board, Scanner sc) {

        int check=2;
        while(check==2){

            if(move == 0){
                System.out.println("Making move level \"easy\"");
                takeComputerEasyInput(board, move);
                move = 1-move;
            }else{
                System.out.println("Making move level \"medium\"");
                takeComputerMediumInput(board, move);
                move = 1-move;
            }

            show_current_board_status(board);

            check = checkWinner(board);
            if(check == 0) System.out.println("Draw");
            else if(check == 1)System.out.println("X wins");
            else if(check == -1)System.out.println("O wins");
        }
    }

    // if programmer given input command as "start user easy" then this function going to implement  player1 = User and player2 = Computer playing at easy level
    private static void playUserEasy(int[][] board, Scanner sc) {

        int check=2;
        while(check==2){

            if(move == 0){
                System.out.print("Enter the coordinates:");
                takeUserInput(sc, board);
                move = 1-move;
            }else{
                System.out.println("Making move level \"easy\"");
                takeComputerEasyInput(board, move);
                move = 1-move;
            }

            show_current_board_status(board);

            check = checkWinner(board);
            if(check == 0) System.out.println("Draw");
            else if(check == 1)System.out.println("X wins");
            else if(check == -1)System.out.println("O wins");
        }
    }

    // if programmer given input command as "start easy easy" then this function going to implement  player1 = Computer playing at easy level and player2 = Computer playing at easy level
    private static void playEayEasy(int[][] board, Scanner sc) {

        int check=2;
        while(check==2){

            if(move == 0){
                System.out.println("Making move level \"easy\"");
                takeComputerEasyInput(board, move);
                move = 1-move;
            }else{
                System.out.println("Making move level \"easy\"");
                takeComputerEasyInput(board, move);
                move = 1-move;
            }

            show_current_board_status(board);

            check = checkWinner(board);
            if(check == 0) System.out.println("Draw");
            else if(check == 1)System.out.println("X wins");
            else if(check == -1)System.out.println("O wins");
        }

    }

    // if programmer given input command as "start user user" then this function going to implement  player1 = User and player2 = User
    private static void playUserUser(int[][] board, Scanner sc) {

        int check=2;
        while(check==2){

            if(move == 0){
                System.out.print("Enter the coordinates:");
                takeUserInput(sc, board);
                move = 1-move;
            }else{
                System.out.print("Enter the coordinates:");
                takeUserInput(sc, board);
                move = 1-move;
            }

            show_current_board_status(board);

            check = checkWinner(board);
            if(check == 0) System.out.println("Draw");
            else if(check == 1)System.out.println("X wins");
            else if(check == -1)System.out.println("O wins");
        }

    }




    // It analyzes whether command user input is correct and if it is so then return constant accordingly
    private static int takeInputCommand(Scanner sc) {

        String player1 = null, player2 = null;

        while(true){
            String str = sc.nextLine();

            if(str.equals("exit"))return 0;

            int cnt=0;
            String s1 = "";
            int i=0;
            while(i<str.length()){
                while(i<str.length() && str.charAt(i) != ' '){
                    s1 += str.charAt(i);
                    i++;
                }
                while(i<str.length() && str.charAt(i) == ' ')i++;

                if(cnt == 0){
                    cnt++;
                    s1 = "";
                    continue;
                }
                else if(cnt == 1){
                    cnt++;
                    player1 = s1;
                    s1 = "";
                }
                else if(cnt == 2){
                    cnt++;
                    player2 = s1;
                }
            }

            if(cnt == 3)break;
            else{
                System.out.println("Bad parameters!");
                System.out.print("Input command:");
                continue;
            }
        }

        if(player1.equals("easy")){
            if(player2.equals("user")) return Constants.START_EASY_USER;
            else if(player2.equals("easy")) return Constants.START_EASY_EASY;
            else if(player2.equals("medium")) return Constants.START_EASY_MEDIUM;
        }else if(player1.equals("user")){
            if(player2.equals("user")) return Constants.START_USER_USER;
            else if(player2.equals("easy")) return Constants.START_USER_EASY;
            else if(player2.equals("medium")) return Constants.START_USER_MEDIUM;
            else if(player2.equals("hard")) return Constants.START_USER_HARD;
        }else if(player1.equals("medium")){
            if(player2.equals("user")) return Constants.START_MEDIUM_USER;
        }else if(player1.equals("hard")){
            if(player2.equals("user")) return Constants.START_HARD_USER;
            else if(player2.equals("hard")) return Constants.START_HARD_HARD;
        }

        return 0;

    }

    // It checks whether coordinate input by user is correct or not (i.e: between 1 and 3 or not Eg: 1 3 )
    private static void takeUserInput(Scanner sc, int[][] board) {

        int count=0;           // To count number of input tokens
        boolean check1 = true; // To keep the record of the entered incorrect number to avoid double printing
        boolean check2 = true; // To keep the record of the entered incorrect word to avoid double printing
        boolean first = true;  // To instantiate x and y coordinate correspondingly
        int x_coordinate = -1, y_coordinate = -1;
        boolean check=true;    // To handle the situation in which if user input like "one"

        while(count != 2){
            String str = sc.next();
            int n = 0;

            if(!check & first){
                check2 = true;
                check = true;
            }

            try{
                n = Integer.parseInt(str);
            }
            catch (NumberFormatException e){
                if(check2){
                    System.out.println("You should enter numbers!");
                    System.out.print("Enter the coordinates:");
                    if(first){
                        check = false;
                        check2 = false;
                    }
                    first = true;
                    count=0;
                    continue;
                }else{
                    check = true;
                    check2 = true;
                    continue;
                }
            }

            if(n<1 || n>3) {
                if(check1){
                    System.out.println("Coordinates should be from 1 to 3!");
                    System.out.print("Enter the coordinates:");
                    if(first)check1 = false;
                    first = true;
                    count=0;
                    continue;
                }else{
                    check1 = true;
                    continue;
                }

            }else{
                if(check1 && check2){
                    if(first){
                        first=false;
                        x_coordinate = n;
                        count++;
                    }else{
                        count++;
                        y_coordinate = n;
                        first = true;
                    }
                }else{
                    check1=true;
                    check2 = true;
                }
            }

            if(count==2){
                if(board[x_coordinate-1][y_coordinate-1] != 0){
                    //show_current_board_status(board);
                    System.out.println("This cell is occupied! Choose another one!");
                    //show_current_board_status(board);
                    System.out.print("Enter the coordinates:");
                    count=0;
                    first = true;
                    continue;
                }else{
                    break;
                }

            }

        };

        if(move == 0)board[x_coordinate-1][y_coordinate-1] = 1;
        else board[x_coordinate-1][y_coordinate-1] = -1;

    }

    // It prints out the current status of tic-tac-toe board
    private static void show_current_board_status(int[][] board) {

        System.out.println("---------");
        for(int i=0; i<3; i++){
            System.out.print("| ");
            for(int j=0; j<3; j++){
                if(board[i][j] == 1)System.out.print("X ");
                else if(board[i][j] == -1) System.out.print("O ");
                else System.out.print("  ");
            }
            System.out.println("|");
        }
        System.out.println("---------");

    }

    // It updates the value of array according to 'X' and 'O' moves  for 'X' places 1, for 'O' places -1 and at 'vacant places' place 0
    private static void update_array(int[][] board, String str) {

        int x1=0,y1=0;
        int no_of_x = 0, no_of_o = 0;

        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == 'X') {
                no_of_x++;
                board[x1][y1] = 1;
            }else if(str.charAt(i) == 'O'){
                no_of_o++;
                board[x1][y1] = -1;
            }
            y1++;

            if(i%3==2) {
                x1++;
                y1=0;
                continue;
            }
        }

        if(no_of_x > no_of_o) move = 1-move;
    }




    // It gets called when ask for computer to play at easier level
    private static void takeComputerEasyInput(int[][] board, int move) {

        Random r = new Random();

        while(true){

            int computer_x_coordinate = r.nextInt(3) + 1;
            int computer_y_coordinate = r.nextInt(3) + 1;

            if(board[computer_x_coordinate-1][computer_y_coordinate-1] != 0){
                continue;
            }else{
                if(move == 0)
                    board[computer_x_coordinate-1][computer_y_coordinate-1] = 1;
                else board[computer_x_coordinate-1][computer_y_coordinate-1] = -1;
                break;
            }
        }

    }

    // It gets called when ask for computer to play at medium level
    private static void takeComputerMediumInput(int[][] board, int move) {

        int computer_x_coordinate = -1;
        int computer_y_coordinate = -1;
        Random r = new Random();

        int[] check = checkMediumMoves(board, computer_x_coordinate, computer_y_coordinate, move);

        if(check[0] != -1 && check[1] != -1){
            computer_x_coordinate = check[0];
            computer_y_coordinate = check[1];
            if(move == 0)
                board[computer_x_coordinate][computer_y_coordinate] = 1;
            else board[computer_x_coordinate][computer_y_coordinate] = -1;
        }else{
            while(true){

                computer_x_coordinate = r.nextInt(3) + 1;
                computer_y_coordinate = r.nextInt(3) + 1;

                if(board[computer_x_coordinate-1][computer_y_coordinate-1] != 0){
                    continue;
                }else{
                    if(move == 0)
                        board[computer_x_coordinate-1][computer_y_coordinate-1] = 1;
                    else board[computer_x_coordinate-1][computer_y_coordinate-1] = -1;
                    break;
                }
            }
        }

    }

    // This algo implemented to make computer play at medium level
    private static int[] checkMediumMoves(int[][] arr, int x_coordinate, int y_coordinate, int move) {

        x_coordinate = -1;
        y_coordinate = -1;

        if(move == 0){
            if((arr[0][0] == 1 && arr[0][1] == 1) || (arr[0][1] == 1 && arr[0][2] == 1) || (arr[0][0] == 1 && arr[0][2] == 1)){
                if(arr[0][0] == 1 && arr[0][1] == 1){
                    x_coordinate = 0;
                    y_coordinate = 2;
                    return new int[]{x_coordinate, y_coordinate};
                }else if(arr[0][1] == 1 && arr[0][2] == 1){
                    x_coordinate = 0;
                    y_coordinate = 0;
                    return new int[]{x_coordinate, y_coordinate};
                }else{
                    x_coordinate = 0;
                    y_coordinate = 1;
                    return new int[]{x_coordinate, y_coordinate};
                }
            }
            if((arr[1][0] == 1 && arr[1][1] == 1) || (arr[1][1] == 1 && arr[1][2] == 1) || (arr[1][0] == 1 && arr[1][2] == 1)){
                if(arr[1][0] == 1 && arr[1][1] == 1){
                    x_coordinate = 1;
                    y_coordinate = 2;
                    return new int[]{x_coordinate, y_coordinate};
                }else if(arr[1][1] == 1 && arr[1][2] == 1){
                    x_coordinate = 1;
                    y_coordinate = 0;
                    return new int[]{x_coordinate, y_coordinate};
                }else{
                    x_coordinate = 1;
                    y_coordinate = 1;
                    return new int[]{x_coordinate, y_coordinate};
                }
            }
            if((arr[2][0] == 1 && arr[2][1] == 1) || (arr[2][1] == 1 && arr[2][2] == 1) || (arr[2][0] == 1 && arr[2][2] == 1)){
                if(arr[2][0] == 1 && arr[2][1] == 1){
                    x_coordinate = 2;
                    y_coordinate = 2;
                    return new int[]{x_coordinate, y_coordinate};
                }else if(arr[2][1] == 1 && arr[2][2] == 1){
                    x_coordinate = 2;
                    y_coordinate = 0;
                    return new int[]{x_coordinate, y_coordinate};
                }else{
                    x_coordinate = 2;
                    y_coordinate = 1;
                    return new int[]{x_coordinate, y_coordinate};
                }
            }
            if((arr[0][0] == 1 && arr[1][0] == 1) || (arr[1][0] == 1 && arr[2][0] == 1) || (arr[0][0] == 1 && arr[2][0] == 1)){
                if(arr[0][0] == 1 && arr[1][0] == 1){
                    x_coordinate = 2;
                    y_coordinate = 0;
                    return new int[]{x_coordinate, y_coordinate};
                }else if(arr[1][0] == 1 && arr[2][0] == 1){
                    x_coordinate = 0;
                    y_coordinate = 0;
                    return new int[]{x_coordinate, y_coordinate};
                }else{
                    x_coordinate = 1;
                    y_coordinate = 0;
                    return new int[]{x_coordinate, y_coordinate};
                }
            }
            if((arr[0][1] == 1 && arr[1][1] == 1) || (arr[1][1] == 1 && arr[2][1] == 1) || (arr[2][1] == 1 && arr[0][1] == 1)){
                if(arr[0][1] == 1 && arr[1][1] == 1){
                    x_coordinate = 2;
                    y_coordinate = 1;
                    return new int[]{x_coordinate, y_coordinate};
                }else if(arr[1][1] == 1 && arr[2][1] == 1){
                    x_coordinate = 0;
                    y_coordinate = 1;
                    return new int[]{x_coordinate, y_coordinate};
                }else{
                    x_coordinate = 1;
                    y_coordinate = 1;
                    return new int[]{x_coordinate, y_coordinate};
                }
            }
            if((arr[0][2] == 1 && arr[1][2] == 1) || (arr[1][2] == 1 && arr[2][2] == 1) || (arr[2][2] == 1 && arr[0][2] == 1)){
                if(arr[0][2] == 1 && arr[1][2] == 1){
                    x_coordinate = 2;
                    y_coordinate = 2;
                    return new int[]{x_coordinate, y_coordinate};
                }else if(arr[1][2] == 1 && arr[2][2] == 1){
                    x_coordinate = 0;
                    y_coordinate = 2;
                    return new int[]{x_coordinate, y_coordinate};
                }else{
                    x_coordinate = 1;
                    y_coordinate = 2;
                    return new int[]{x_coordinate, y_coordinate};
                }
            }
            if((arr[0][0] == 1 && arr[1][1] == 1) || (arr[1][1] == 1 && arr[2][2] == 1) || (arr[2][2] == 1 && arr[0][0] == 1)){
                if(arr[0][0] == 1 && arr[1][1] == 1){
                    x_coordinate = 2;
                    y_coordinate = 2;
                    return new int[]{x_coordinate, y_coordinate};
                }else if(arr[1][1] == 1 && arr[2][2] == 1){
                    x_coordinate = 0;
                    y_coordinate = 0;
                    return new int[]{x_coordinate, y_coordinate};
                }else{
                    x_coordinate = 1;
                    y_coordinate = 1;
                    return new int[]{x_coordinate, y_coordinate};
                }
            }
            if((arr[0][2] == 1 && arr[1][1] == 1) || (arr[1][1] == 1 && arr[2][0] == 1) || (arr[2][0] == 1 && arr[0][2] == 1)){
                if(arr[0][2] == 1 && arr[1][1] == 1){
                    x_coordinate = 2;
                    y_coordinate = 0;
                    return new int[]{x_coordinate, y_coordinate};
                }else if(arr[1][1] == 1 && arr[2][0] == 1){
                    x_coordinate = 0;
                    y_coordinate = 2;
                    return new int[]{x_coordinate, y_coordinate};
                }else{
                    x_coordinate = 1;
                    y_coordinate = 1;
                    return new int[]{x_coordinate, y_coordinate};
                }
            }
            if((arr[0][0] == -1 && arr[0][1] == -1) || (arr[0][1] == -1 && arr[0][2] == -1) || (arr[0][0] == -1 && arr[0][2] == -1)){
                if(arr[0][0] ==-1 && arr[0][1] == -1){
                    x_coordinate = 0;
                    y_coordinate = 2;
                    return new int[]{x_coordinate, y_coordinate};
                }else if(arr[0][1] == -1 && arr[0][2] == -1){
                    x_coordinate = 0;
                    y_coordinate = 0;
                    return new int[]{x_coordinate, y_coordinate};
                }else{
                    x_coordinate = 0;
                    y_coordinate = 1;
                    return new int[]{x_coordinate, y_coordinate};
                }
            }
            if((arr[1][0] == -1 && arr[1][1] == -1) || (arr[1][1] == -1 && arr[1][2] == -1) || (arr[1][0] == -1 && arr[1][2] == -1)){
                if(arr[1][0] == -1 && arr[1][1] == -1){
                    x_coordinate = 1;
                    y_coordinate = 2;
                    return new int[]{x_coordinate, y_coordinate};
                }else if(arr[1][1] == -1 && arr[1][2] == -1){
                    x_coordinate = 1;
                    y_coordinate = 0;
                    return new int[]{x_coordinate, y_coordinate};
                }else{
                    x_coordinate = 1;
                    y_coordinate = 1;
                    return new int[]{x_coordinate, y_coordinate};
                }
            }
            if((arr[2][0] == -1 && arr[2][1] == -1) || (arr[2][1] == -1 && arr[2][2] == -1) || (arr[2][0] == -1 && arr[2][2] == -1)){
                if(arr[2][0] == -1 && arr[2][1] == -1){
                    x_coordinate = 2;
                    y_coordinate = 2;
                    return new int[]{x_coordinate, y_coordinate};
                }else if(arr[2][1] == -1 && arr[2][2] == -1){
                    x_coordinate = 2;
                    y_coordinate = 0;
                    return new int[]{x_coordinate, y_coordinate};
                }else{
                    x_coordinate = 2;
                    y_coordinate = 1;
                    return new int[]{x_coordinate, y_coordinate};
                }
            }
            if((arr[0][0] == -1 && arr[1][0] == -1) || (arr[1][0] == -1 && arr[2][0] == -1) || (arr[0][0] == -1 && arr[2][0] == -1)){
                if(arr[0][0] == -1 && arr[1][0] == -1){
                    x_coordinate = 2;
                    y_coordinate = 0;
                    return new int[]{x_coordinate, y_coordinate};
                }else if(arr[1][0] == -1 && arr[2][0] == -1){
                    x_coordinate = 0;
                    y_coordinate = 0;
                    return new int[]{x_coordinate, y_coordinate};
                }else{
                    x_coordinate = 1;
                    y_coordinate = 0;
                    return new int[]{x_coordinate, y_coordinate};
                }
            }
            if((arr[0][1] == -1 && arr[1][1] == -1) || (arr[1][1] == -1 && arr[2][1] == -1) || (arr[2][1] == -1 && arr[0][1] == -1)){
                if(arr[0][1] == -1 && arr[1][1] == -1){
                    x_coordinate = 2;
                    y_coordinate = 1;
                    return new int[]{x_coordinate, y_coordinate};
                }else if(arr[1][1] == -1 && arr[2][1] == -1){
                    x_coordinate = 0;
                    y_coordinate = 1;
                    return new int[]{x_coordinate, y_coordinate};
                }else{
                    x_coordinate = 1;
                    y_coordinate = 1;
                    return new int[]{x_coordinate, y_coordinate};
                }
            }
            if((arr[0][2] == -1 && arr[1][2] == -1) || (arr[1][2] == -1 && arr[2][2] == -1) || (arr[2][2] == -1 && arr[0][2] == -1)){
                if(arr[0][2] == -1 && arr[1][2] == -1){
                    x_coordinate = 2;
                    y_coordinate = 2;
                    return new int[]{x_coordinate, y_coordinate};
                }else if(arr[1][2] == -1 && arr[2][2] == -1){
                    x_coordinate = 0;
                    y_coordinate = 2;
                    return new int[]{x_coordinate, y_coordinate};
                }else{
                    x_coordinate = 1;
                    y_coordinate = 2;
                    return new int[]{x_coordinate, y_coordinate};
                }
            }
            if((arr[0][0] == -1 && arr[1][1] == -1) || (arr[1][1] == -1 && arr[2][2] == -1) || (arr[2][2] == -1 && arr[0][0] == -1)){
                if(arr[0][0] == -1 && arr[1][1] == -1){
                    x_coordinate = 2;
                    y_coordinate = 2;
                    return new int[]{x_coordinate, y_coordinate};
                }else if(arr[1][1] == -1 && arr[2][2] == -1){
                    x_coordinate = 0;
                    y_coordinate = 0;
                    return new int[]{x_coordinate, y_coordinate};
                }else{
                    x_coordinate = 1;
                    y_coordinate = 1;
                    return new int[]{x_coordinate, y_coordinate};
                }
            }
            if((arr[0][2] == -1 && arr[1][1] == -1) || (arr[1][1] == -1 && arr[2][0] == -1) || (arr[2][0] == -1 && arr[0][2] == -1)){
                if(arr[0][2] == -1 && arr[1][1] == -1){
                    x_coordinate = 2;
                    y_coordinate = 0;
                    return new int[]{x_coordinate, y_coordinate};
                }else if(arr[1][1] == -1 && arr[2][0] == -1){
                    x_coordinate = 0;
                    y_coordinate = 2;
                    return new int[]{x_coordinate, y_coordinate};
                }else{
                    x_coordinate = 1;
                    y_coordinate = 1;
                    return new int[]{x_coordinate, y_coordinate};
                }
            }

        }
        else{
            if((arr[0][0] == -1 && arr[0][1] == -1) || (arr[0][1] == -1 && arr[0][2] == -1) || (arr[0][0] == -1 && arr[0][2] == -1)){
                if(arr[0][0] ==-1 && arr[0][1] == -1){
                    x_coordinate = 0;
                    y_coordinate = 2;
                    return new int[]{x_coordinate, y_coordinate};
                }else if(arr[0][1] == -1 && arr[0][2] == -1){
                    x_coordinate = 0;
                    y_coordinate = 0;
                    return new int[]{x_coordinate, y_coordinate};
                }else{
                    x_coordinate = 0;
                    y_coordinate = 1;
                    return new int[]{x_coordinate, y_coordinate};
                }
            }
            if((arr[1][0] == -1 && arr[1][1] == -1) || (arr[1][1] == -1 && arr[1][2] == -1) || (arr[1][0] == -1 && arr[1][2] == -1)){
                if(arr[1][0] == -1 && arr[1][1] == -1){
                    x_coordinate = 1;
                    y_coordinate = 2;
                    return new int[]{x_coordinate, y_coordinate};
                }else if(arr[1][1] == -1 && arr[1][2] == -1){
                    x_coordinate = 1;
                    y_coordinate = 0;
                    return new int[]{x_coordinate, y_coordinate};
                }else{
                    x_coordinate = 1;
                    y_coordinate = 1;
                    return new int[]{x_coordinate, y_coordinate};
                }
            }
            if((arr[2][0] == -1 && arr[2][1] == -1) || (arr[2][1] == -1 && arr[2][2] == -1) || (arr[2][0] == -1 && arr[2][2] == -1)){
                if(arr[2][0] == -1 && arr[2][1] == -1){
                    x_coordinate = 2;
                    y_coordinate = 2;
                    return new int[]{x_coordinate, y_coordinate};
                }else if(arr[2][1] == -1 && arr[2][2] == -1){
                    x_coordinate = 2;
                    y_coordinate = 0;
                    return new int[]{x_coordinate, y_coordinate};
                }else{
                    x_coordinate = 2;
                    y_coordinate = 1;
                    return new int[]{x_coordinate, y_coordinate};
                }
            }
            if((arr[0][0] == -1 && arr[1][0] == -1) || (arr[1][0] == -1 && arr[2][0] == -1) || (arr[0][0] == -1 && arr[2][0] == -1)){
                if(arr[0][0] == -1 && arr[1][0] == -1){
                    x_coordinate = 2;
                    y_coordinate = 0;
                    return new int[]{x_coordinate, y_coordinate};
                }else if(arr[1][0] == -1 && arr[2][0] == -1){
                    x_coordinate = 0;
                    y_coordinate = 0;
                    return new int[]{x_coordinate, y_coordinate};
                }else{
                    x_coordinate = 1;
                    y_coordinate = 0;
                    return new int[]{x_coordinate, y_coordinate};
                }
            }
            if((arr[0][1] == -1 && arr[1][1] == -1) || (arr[1][1] == -1 && arr[2][1] == -1) || (arr[2][1] == -1 && arr[0][1] == -1)){
                if(arr[0][1] == -1 && arr[1][1] == -1){
                    x_coordinate = 2;
                    y_coordinate = 1;
                    return new int[]{x_coordinate, y_coordinate};
                }else if(arr[1][1] == -1 && arr[2][1] == -1){
                    x_coordinate = 0;
                    y_coordinate = 1;
                    return new int[]{x_coordinate, y_coordinate};
                }else{
                    x_coordinate = 1;
                    y_coordinate = 1;
                    return new int[]{x_coordinate, y_coordinate};
                }
            }
            if((arr[0][2] == -1 && arr[1][2] == -1) || (arr[1][2] == -1 && arr[2][2] == -1) || (arr[2][2] == -1 && arr[0][2] == -1)){
                if(arr[0][2] == -1 && arr[1][2] == -1){
                    x_coordinate = 2;
                    y_coordinate = 2;
                    return new int[]{x_coordinate, y_coordinate};
                }else if(arr[1][2] == -1 && arr[2][2] == -1){
                    x_coordinate = 0;
                    y_coordinate = 2;
                    return new int[]{x_coordinate, y_coordinate};
                }else{
                    x_coordinate = 1;
                    y_coordinate = 2;
                    return new int[]{x_coordinate, y_coordinate};
                }
            }
            if((arr[0][0] == -1 && arr[1][1] == -1) || (arr[1][1] == -1 && arr[2][2] == -1) || (arr[2][2] == -1 && arr[0][0] == -1)){
                if(arr[0][0] == -1 && arr[1][1] == -1){
                    x_coordinate = 2;
                    y_coordinate = 2;
                    return new int[]{x_coordinate, y_coordinate};
                }else if(arr[1][1] == -1 && arr[2][2] == -1){
                    x_coordinate = 0;
                    y_coordinate = 0;
                    return new int[]{x_coordinate, y_coordinate};
                }else{
                    x_coordinate = 1;
                    y_coordinate = 1;
                    return new int[]{x_coordinate, y_coordinate};
                }
            }
            if((arr[0][2] == -1 && arr[1][1] == -1) || (arr[1][1] == -1 && arr[2][0] == -1) || (arr[2][0] == -1 && arr[0][2] == -1)){
                if(arr[0][2] == -1 && arr[1][1] == -1){
                    x_coordinate = 2;
                    y_coordinate = 0;
                    return new int[]{x_coordinate, y_coordinate};
                }else if(arr[1][1] == -1 && arr[2][0] == -1){
                    x_coordinate = 0;
                    y_coordinate = 2;
                    return new int[]{x_coordinate, y_coordinate};
                }else{
                    x_coordinate = 1;
                    y_coordinate = 1;
                    return new int[]{x_coordinate, y_coordinate};
                }
            }
            if((arr[0][0] == 1 && arr[0][1] == 1) || (arr[0][1] == 1 && arr[0][2] == 1) || (arr[0][0] == 1 && arr[0][2] == 1)){
                if(arr[0][0] == 1 && arr[0][1] == 1){
                    x_coordinate = 0;
                    y_coordinate = 2;
                    return new int[]{x_coordinate, y_coordinate};
                }else if(arr[0][1] == 1 && arr[0][2] == 1){
                    x_coordinate = 0;
                    y_coordinate = 0;
                    return new int[]{x_coordinate, y_coordinate};
                }else{
                    x_coordinate = 0;
                    y_coordinate = 1;
                    return new int[]{x_coordinate, y_coordinate};
                }
            }
            if((arr[1][0] == 1 && arr[1][1] == 1) || (arr[1][1] == 1 && arr[1][2] == 1) || (arr[1][0] == 1 && arr[1][2] == 1)){
                if(arr[1][0] == 1 && arr[1][1] == 1){
                    x_coordinate = 1;
                    y_coordinate = 2;
                    return new int[]{x_coordinate, y_coordinate};
                }else if(arr[1][1] == 1 && arr[1][2] == 1){
                    x_coordinate = 1;
                    y_coordinate = 0;
                    return new int[]{x_coordinate, y_coordinate};
                }else{
                    x_coordinate = 1;
                    y_coordinate = 1;
                    return new int[]{x_coordinate, y_coordinate};
                }
            }
            if((arr[2][0] == 1 && arr[2][1] == 1) || (arr[2][1] == 1 && arr[2][2] == 1) || (arr[2][0] == 1 && arr[2][2] == 1)){
                if(arr[2][0] == 1 && arr[2][1] == 1){
                    x_coordinate = 2;
                    y_coordinate = 2;
                    return new int[]{x_coordinate, y_coordinate};
                }else if(arr[2][1] == 1 && arr[2][2] == 1){
                    x_coordinate = 2;
                    y_coordinate = 0;
                    return new int[]{x_coordinate, y_coordinate};
                }else{
                    x_coordinate = 2;
                    y_coordinate = 1;
                    return new int[]{x_coordinate, y_coordinate};
                }
            }
            if((arr[0][0] == 1 && arr[1][0] == 1) || (arr[1][0] == 1 && arr[2][0] == 1) || (arr[0][0] == 1 && arr[2][0] == 1)){
                if(arr[0][0] == 1 && arr[1][0] == 1){
                    x_coordinate = 2;
                    y_coordinate = 0;
                    return new int[]{x_coordinate, y_coordinate};
                }else if(arr[1][0] == 1 && arr[2][0] == 1){
                    x_coordinate = 0;
                    y_coordinate = 0;
                    return new int[]{x_coordinate, y_coordinate};
                }else{
                    x_coordinate = 1;
                    y_coordinate = 0;
                    return new int[]{x_coordinate, y_coordinate};
                }
            }
            if((arr[0][1] == 1 && arr[1][1] == 1) || (arr[1][1] == 1 && arr[2][1] == 1) || (arr[2][1] == 1 && arr[0][1] == 1)){
                if(arr[0][1] == 1 && arr[1][1] == 1){
                    x_coordinate = 2;
                    y_coordinate = 1;
                    return new int[]{x_coordinate, y_coordinate};
                }else if(arr[1][1] == 1 && arr[2][1] == 1){
                    x_coordinate = 0;
                    y_coordinate = 1;
                    return new int[]{x_coordinate, y_coordinate};
                }else{
                    x_coordinate = 1;
                    y_coordinate = 1;
                    return new int[]{x_coordinate, y_coordinate};
                }
            }
            if((arr[0][2] == 1 && arr[1][2] == 1) || (arr[1][2] == 1 && arr[2][2] == 1) || (arr[2][2] == 1 && arr[0][2] == 1)){
                if(arr[0][2] == 1 && arr[1][2] == 1){
                    x_coordinate = 2;
                    y_coordinate = 2;
                    return new int[]{x_coordinate, y_coordinate};
                }else if(arr[1][2] == 1 && arr[2][2] == 1){
                    x_coordinate = 0;
                    y_coordinate = 2;
                    return new int[]{x_coordinate, y_coordinate};
                }else{
                    x_coordinate = 1;
                    y_coordinate = 2;
                    return new int[]{x_coordinate, y_coordinate};
                }
            }
            if((arr[0][0] == 1 && arr[1][1] == 1) || (arr[1][1] == 1 && arr[2][2] == 1) || (arr[2][2] == 1 && arr[0][0] == 1)){
                if(arr[0][0] == 1 && arr[1][1] == 1){
                    x_coordinate = 2;
                    y_coordinate = 2;
                    return new int[]{x_coordinate, y_coordinate};
                }else if(arr[1][1] == 1 && arr[2][2] == 1){
                    x_coordinate = 0;
                    y_coordinate = 0;
                    return new int[]{x_coordinate, y_coordinate};
                }else{
                    x_coordinate = 1;
                    y_coordinate = 1;
                    return new int[]{x_coordinate, y_coordinate};
                }
            }
            if((arr[0][2] == 1 && arr[1][1] == 1) || (arr[1][1] == 1 && arr[2][0] == 1) || (arr[2][0] == 1 && arr[0][2] == 1)){
                if(arr[0][2] == 1 && arr[1][1] == 1){
                    x_coordinate = 2;
                    y_coordinate = 0;
                    return new int[]{x_coordinate, y_coordinate};
                }else if(arr[1][1] == 1 && arr[2][0] == 1){
                    x_coordinate = 0;
                    y_coordinate = 2;
                    return new int[]{x_coordinate, y_coordinate};
                }else{
                    x_coordinate = 1;
                    y_coordinate = 1;
                    return new int[]{x_coordinate, y_coordinate};
                }
            }
        }
        return new int[] {-1, -1};
    }

    // It gets called when ask for computer to play at harder level
    private static void takeComputerHardInput(int[][] board, int turn) {

        int bestScore = Integer.MIN_VALUE;
        int[] moves = new int[2];
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(board[i][j] == 0){
                    board[i][j] = turn==0?1:-1;
                    int score = minimax(board, 0, false, 1-turn);
                    board[i][j] = 0;
                    if(score > bestScore){
                        bestScore = score;
                        moves = new int[] {i, j};
                    }
                }
            }
        }
        board[moves[0]][moves[1]] = turn==0?1:-1;
    }

    // This is the algo implemented to make computer play hard
    private static int minimax(int[][] board, int depth, boolean isMaximising, int turn) {
        int result = checkWinner(board);
        if(result == 1){
            if(move == 0){
                return 1;
            }else return -1;
        }else if(result == -1){
            if(move == 0){
                return -1;
            }else return 1;
        }else if(result == 0)return 0;

        if(isMaximising){
            int bestScore = Integer.MIN_VALUE;
            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    if(board[i][j] == 0){
                        board[i][j] = turn==0?1:-1;
                        int score = minimax(board, depth+1, false, 1-turn);
                        board[i][j] = 0;
                        if(score > bestScore){
                            bestScore = score;
                        }
                    }
                }
            }
            return bestScore;
        }else{
            int bestScore = Integer.MAX_VALUE;
            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    if(board[i][j] == 0){
                        board[i][j] = turn==0?1:-1;
                        int score = minimax(board, depth+1, true, 1-turn);
                        board[i][j] = 0;
                        if(score < bestScore){
                            bestScore = score;
                        }
                    }
                }
            }
            return bestScore;
        }
    }




    // This is called to check what player wins, whether 'X' wins or 'O'
    private static int checkWinner(int[][] arr) {

        int total_moves=0;

        for(int[] x: arr){
            for(int y: x){
                if(y!=0) total_moves++;
            }
        }

        if(arr[0][0] == 1 && arr[0][1] == 1 && arr[0][2] == 1){
            return 1;
        }
        if(arr[0][0] == -1 && arr[0][1] == -1 && arr[0][2] == -1){
            return -1;
        }
        if(arr[1][0] == 1 && arr[1][1] == 1 && arr[1][2] == 1){
            return 1;
        }
        if(arr[1][0] == -1 && arr[1][1] == -1 && arr[1][2] == -1){
            return -1;
        }
        if(arr[2][0] == 1 && arr[2][1] == 1 && arr[2][2] == 1){
            return 1;
        }
        if(arr[2][0] == -1 && arr[2][1] == -1 && arr[2][2] == -1){
            return -1;
        }
        if(arr[0][0] == 1 && arr[1][0] == 1 && arr[2][0] == 1){
            return 1;
        }
        if(arr[0][0] == -1 && arr[1][0] == -1 && arr[2][0] == -1){
            return -1;
        }
        if(arr[0][1] == 1 && arr[1][1] == 1 && arr[2][1] == 1){
            return 1;
        }
        if(arr[0][1] == -1 && arr[1][1] == -1 && arr[2][1] == -1){
            return -1;
        }
        if(arr[0][2] == 1 && arr[1][2] == 1 && arr[2][2] == 1){
            return 1;
        }
        if(arr[0][2] == -1 && arr[1][2] == -1 && arr[2][2] == -1){
            return -1;
        }
        if(arr[0][0] == 1 && arr[1][1] == 1 && arr[2][2] == 1){
            return 1;
        }
        if(arr[0][0] == -1 && arr[1][1] == -1 && arr[2][2] == -1){
            return -1;
        }
        if(arr[0][2] == 1 && arr[1][1] == 1 && arr[2][0] == 1){
            return 1;
        }
        if(arr[0][2] == -1 && arr[1][1] == -1 && arr[2][0] == -1){
            return -1;
        }

        if(total_moves == 9){
            return 0;
        }

        return 2;
    }
}
