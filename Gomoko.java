import java.util.Scanner;

public class Gomoko {
    static int[][] gametable = new int[10][10];//create the game board data
    static int turn = 1;//set the user turn 
    static double row;//create the variable that user input the row
    static double col;//create the variable that user input the column

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        printtable();
        System.out.println("Player " + turn + "'s turn.");
        //repeat the input value and output the game table
        while (true) {
            System.out.print("Enter row and column (e.g., 0 1): ");
            row = kb.nextDouble();
            col = kb.nextDouble();

            // Check the input value is valid
            while (row < 0 || row > 9 || col < 0 || col > 9) {
                System.out.println("Out of range! Input again.");
                System.out.print("Enter row and column (e.g., 0 1): ");
                row = kb.nextDouble();
                col = kb.nextDouble();
            }
            //check the value it is the float
            while (row % 1 != 0 || col % 1 != 0) {
                System.out.println("Can not input float! Input again.");
                System.out.print("Enter row and column (e.g., 0 1): ");
                row = kb.nextDouble();
                col = kb.nextDouble();
            }

            // Check the move is valid
            while (gametable[(int)row][(int)col] == 1 || gametable[(int)row][(int)col] == 2) {
                System.out.println("Invalid move. Try again.");
                System.out.print("Enter row and column (e.g., 0 1): ");
                row = kb.nextDouble();
                col = kb.nextDouble();
            }

            // Update the game table
            updatearray(row, col);
            // Check if current player has won.
            if (checkwin(row, col)) {
                printtable();
                System.out.println("Player " + gametable[(int)row][(int)col] + " wins!");
                break;
            }
            // Check if the game is a draw.
            if (checkdraw()) {
                printtable();
                System.out.println("The game is a draw!");
                break;
            }
            printtable();
            System.out.println("Player " + turn + "'s turn.");

        }
        kb.close();
    }
    //update the array and change the turn.
    public static void updatearray(double row, double col) {
        gametable[(int)row][(int)col] = turn;
        //check the turn is it == 1, if yes turn = 2, if not then = 1
        turn = (turn == 1) ? 2 : 1;
    }
    //check the player has won in any direction.
    public static boolean checkwin(double row, double col) {
        return checkrow(row, col) || checkcol(row, col) || checkslash(row, col);
    }
    //check the row have the same value.
    public static boolean checkrow(double row, double col) {
        //set the count if the count == 4 that mean have the 4 same value.
        int count = 0;
        //check the gametable row have the same value
        for (int i = 0; i < 10; i++) {
            //check the col and the i it is the same value. if yes than count++
            if (gametable[(int)row][i] == gametable[(int)row][(int)col]) {
                count++;
                //if have the 4 same value than return true
                if (count == 4) return true;
            } else {
                count = 0;//reset the count
            }
        }//if not return false
        return false;
    }

    public static boolean checkcol(double row, double col) {
        //set the count if the count == 4 that mean have the 4 same value.
        int count = 0;
        //check the gametable col have the same value
        for (int i = 0; i < 10; i++) {
            //check the row and the i it is the same value. if yes than count++
            if (gametable[i][(int)col] == gametable[(int)row][(int)col]) {
                count++;
                //if have the 4 same value than return true
                if (count == 4) return true;
            } else {
                count = 0;//reset the count
            }
        }//if not return false
        return false;
    }

    public static boolean checkslash(double row, double col) {
        //set the count if the count == 4 that mean have the 4 same value.
        int count = 0;
        //set the count if the count == 4 that mean have the 4 same value.
        for (int i = -3; i <= 3; i++) {
            ////cal the diagonal to the row and col left bottom to right top 
            int r = (int)row + i, c = (int) col + i;
            //check the same value 
            if (r >= 0 && r < 10 && c >= 0 && c < 10 && gametable[r][c] == gametable[(int)row][(int)col]) {
                count++;
                //if have the 4 same value than return true
                if (count == 4) return true;
            } else {
                count = 0;
            }
        }

        count = 0;
        //set the count if the count == 4 that mean have the 4 same value.
        for (int i = -3; i <= 3; i++) {
            ////cal the diagonal to the row and col right bottom to left top 
            int r = (int)row + i, c = (int)col - i;
            //check the same value 
            if (r >= 0 && r < 10 && c >= 0 && c < 10 && gametable[r][c] == gametable[(int)row][(int)col]) {
                count++;
                //if have the 4 same value than return true
                if (count == 4) return true;
            } else {
                count = 0;
            }
        }
        //if not return false
        return false;
    }

    // Check if the game is a draw
    public static boolean checkdraw() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (gametable[i][j] == 0) {
                    return false; // If there's at least one empty cell, it's not a draw
                }
            }
        }
        return true; // All cells are filled, it's a draw
    }
    
    //print the game table and the player turn.
    public static void printtable() {
        //for loop i and print the table chessboard border
        for (int i = 0; i < 10; i++) {
            System.out.print(i + " | ");
            //print the chessboard data
            for (int n = 0; n < gametable[i].length; n++) {
                System.out.print(gametable[i][n] + " ");
            }
            System.out.println();
        }
        //print the bottom side of the table chessboard border and the next round which the user can play. 
        System.out.println("  +--------------------");
        System.out.println("    0 1 2 3 4 5 6 7 8 9 ");
    }
}