package tictactoe;

import java.util.Scanner;

public class Main {

    private static int move = 0;

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

        while(true){
            String str = sc.nextLine();
//            String str1 = sc.next();
//            String str2 = sc.next();
            try{
                int n1=0, n2=0;

                String temp = "";
                for(int i=0; i<str.length(); i++){
                    if(" ".equals(str.charAt(i))){
                        i++;
                        n1 = Integer.parseInt(temp);
                        temp = "";
                    }
                    temp += str.charAt(i);
                }
                n2 = Integer.parseInt(temp);
//                String[] st = str.split(" ");
//                n1 = Integer.parseInt(st[0]);
//                n2 = Integer.parseInt(st[1]);
//                int n1 = Integer.parseInt(str1);
//                int n2 = Integer.parseInt(str2);
                if(n1<1 || n1>3 || n2<1 || n2>3){
                    System.out.println("Coordinates should be from 1 to 3!");
                    System.out.print("Enter the coordinates:");
                    continue;
                }
                if(board[n1-1][n2-1] != 0){
                    System.out.println("This cell is occupied! Choose another one!");
                    System.out.print("Enter the coordinates:");
                    continue;
                }
                if(move == 0)board[n1-1][n2-1] = 1;
                else board[n1-1][n2-1] = -1;
                move = 1-move;
                break;
            }
            catch (NumberFormatException e){
                System.out.println("You should enter numbers!");
                System.out.print("Enter the coordinates:");
                continue;
            }
        }

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

        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == 'X') {
                board[x1][y1] = 1;
            }else if(str.charAt(i) == 'O') board[x1][y1] = -1;
            y1++;

            if(i%3==2) {
                x1++;
                y1=0;
                continue;
            }
        }

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
        if(arr[0][0] == 0 && arr[0][1] == 0 && arr[0][2] == 0){
            o_wins = true;
        }
        if(arr[1][0] == 1 && arr[1][1] == 1 && arr[1][2] == 1){
            x_wins = true;
        }
        if(arr[1][0] == 0 && arr[1][1] == 0 && arr[1][2] == 0){
            o_wins = true;
        }
        if(arr[2][0] == 1 && arr[2][1] == 1 && arr[2][2] == 1){
            x_wins = true;
        }
        if(arr[2][0] == 0 && arr[2][1] == 0 && arr[2][2] == 0){
            o_wins = true;
        }
        if(arr[0][0] == 1 && arr[1][0] == 1 && arr[2][0] == 1){
            x_wins = true;
        }
        if(arr[0][0] == 0 && arr[1][0] == 0 && arr[2][0] == 0){
            o_wins = true;
        }
        if(arr[0][1] == 1 && arr[1][1] == 1 && arr[2][1] == 1){
            x_wins = true;
        }
        if(arr[0][1] == 0 && arr[1][1] == 0 && arr[2][1] == 0){
            o_wins = true;
        }
        if(arr[0][2] == 1 && arr[1][2] == 1 && arr[2][2] == 1){
            x_wins = true;
        }
        if(arr[0][2] == 0 && arr[1][2] == 0 && arr[2][2] == 0){
            o_wins = true;
        }
        if(arr[0][0] == 1 && arr[1][1] == 1 && arr[2][2] == 1){
            x_wins = true;
        }
        if(arr[0][0] == 0 && arr[1][1] == 0 && arr[2][2] == 0){
            o_wins = true;
        }
        if(arr[0][2] == 1 && arr[1][1] == 1 && arr[2][0] == 1){
            x_wins = true;
        }
        if(arr[0][2] == 0 && arr[1][1] == 0 && arr[2][0] == 0){
            o_wins = true;
        }

        if(x_wins) System.out.println("X Wins");
        else if(o_wins) System.out.println("O Wins");
        else if(total_moves != 9) System.out.println("Game not finished");
        else System.out.println("Draw");
    }
}
