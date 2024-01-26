package tictactoe;

import java.util.Scanner;

public class Main {

    private static int move = 0;  // move == 0 --> X turn;   move == 1 --> O turn;

    public static void main(String[] args) {

        System.out.print("Enter the cells:");
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println();

        int[][] board = new int[3][3];

        update_array(board, str);

        show_current_board_status(board);

        System.out.print("Enter the coordinates:");

        takeUserInput(sc, board);

        show_current_board_status(board);

        checkWinner(board);

    }

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
                    System.out.println("This cell is occupied! Choose another one!");
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
        move = 1-move;

    }

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

    private static void checkWinner(int[][] arr) {

        int total_moves=0;
        boolean x_wins=false;
        boolean o_wins = false;

        for(int[] x: arr){
            for(int y: x){
                if(y!=0) total_moves++;
            }
        }

        if(arr[0][0] == 1 && arr[0][1] == 1 && arr[0][2] == 1){
            x_wins = true;
        }
        if(arr[0][0] == -1 && arr[0][1] == -1 && arr[0][2] == -1){
            o_wins = true;
        }
        if(arr[1][0] == 1 && arr[1][1] == 1 && arr[1][2] == 1){
            x_wins = true;
        }
        if(arr[1][0] == -1 && arr[1][1] == -1 && arr[1][2] == -1){
            o_wins = true;
        }
        if(arr[2][0] == 1 && arr[2][1] == 1 && arr[2][2] == 1){
            x_wins = true;
        }
        if(arr[2][0] == -1 && arr[2][1] == -1 && arr[2][2] == -1){
            o_wins = true;
        }
        if(arr[0][0] == 1 && arr[1][0] == 1 && arr[2][0] == 1){
            x_wins = true;
        }
        if(arr[0][0] == -1 && arr[1][0] == -1 && arr[2][0] == -1){
            o_wins = true;
        }
        if(arr[0][1] == 1 && arr[1][1] == 1 && arr[2][1] == 1){
            x_wins = true;
        }
        if(arr[0][1] == -1 && arr[1][1] == -1 && arr[2][1] == -1){
            o_wins = true;
        }
        if(arr[0][2] == 1 && arr[1][2] == 1 && arr[2][2] == 1){
            x_wins = true;
        }
        if(arr[0][2] == -1 && arr[1][2] == -1 && arr[2][2] == -1){
            o_wins = true;
        }
        if(arr[0][0] == 1 && arr[1][1] == 1 && arr[2][2] == 1){
            x_wins = true;
        }
        if(arr[0][0] == -1 && arr[1][1] == -1 && arr[2][2] == -1){
            o_wins = true;
        }
        if(arr[0][2] == 1 && arr[1][1] == 1 && arr[2][0] == 1){
            x_wins = true;
        }
        if(arr[0][2] == -1 && arr[1][1] == -1 && arr[2][0] == -1){
            o_wins = true;
        }

        if(x_wins) System.out.println("X wins");
        else if(o_wins) System.out.println("O wins");
        else if(total_moves != 9) System.out.println("Game not finished");
        else System.out.println("Draw");
    }
}
