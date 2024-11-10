import java.util.Scanner;

public class Main {
    static int[][] gametable = new int[10][10];//create the game board data
    static int turn = 1;//set the user turn 
    static double row;//create the varible that user input the row
    static double col;//create the varible that user input the column

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        printtable();
        while (true) {
            System.out.print("Enter row and column (e.g., 0 1): ");
            row = kb.nextDouble();
            col = kb.nextDouble();
            if (row<0 || row>9 && col<0 && col>9) {
                row = kb.nextDouble();
                col = kb.nextDouble();
             
            }
            

            // Check the input value is valid 
            while (row < 0 || row > 9 || col < 0 || col > 9) {
                System.out.println("Out of range! Input again.");
                System.out.print("Enter row and column (e.g., 0 1): ");
                row = kb.nextDouble();
                col = kb.nextDouble();
            }
            
            //check the user not input float. 
            while (row % 1 != 0 || col % 1 != 0){
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
                System.out.println("Player " + gametable[(int)row][(int)col] + " wins!");
                break;
            }
            printtable();

            
            
        }
        kb.close();
    }
    //update the array and change the turn. 
    public static void updatearray(double row, double col) {
        gametable[(int)row][(int)col] = turn;
        turn = (turn == 1) ? 2 : 1;
    }
    //check the player has won in any direction. 
    public static boolean checkwin(double row, double col) {
        return checkrow(row, col) || checkcol(row, col) || checkslash(row, col);
    }
    //check the row hava the same value. 
    public static boolean checkrow(double row, double col) {
        int count = 0;//set the count if the count == 4 that mean hava the 4 same value. 
        for (int i = 0; i < 10; i++) {
            //check the col and the i it is the same value. 
            if (gametable[(int)row][i] == gametable[(int)row][(int)col]) {
                count++;
                if (count == 4) return true;
            } else {
                count = 0;
            }
        }
        return false;
    }

    public static boolean checkcol(double row, double col) {
        int count = 0;
        for (int i = 0; i < 10; i++) {
            if (gametable[i][(int)col] == gametable[(int)row][(int)col]) {
                count++;
                if (count == 4) return true;
            } else {
                count = 0;
            }
        }
        return false;
    }

    public static boolean checkslash(double row, double col) {
        int count = 0;
        
        for (int i = -3; i <= 3; i++) {
            int r = (int)row + i, c = (int) col + i;
            if (r >= 0 && r < 10 && c >= 0 && c < 10 && gametable[r][c] == gametable[(int)row][(int)col]) {
                count++;
                if (count == 4) return true;
            } else {
                count = 0;
            }
        }

        count = 0;
        
        for (int i = -3; i <= 3; i++) {
            int r = (int)row + i, c = (int)col - i;
            if (r >= 0 && r < 10 && c >= 0 && c < 10 && gametable[r][c] == gametable[(int)row][(int)col]) {
                count++;
                if (count == 4) return true;
            } else {
                count = 0;
            }
        }

        return false;
    }
    //print the game table and the player turn.
    public static void printtable() {
        for (int i = 0; i < 10; i++) {
            System.out.print(i + " | ");
            for (int n = 0; n < gametable[i].length; n++) {
                System.out.print(gametable[i][n] + " ");
            }
            System.out.println();
        }
        System.out.println("  +--------------------");
        System.out.println("    0 1 2 3 4 5 6 7 8 9 ");
        System.out.println("Player " + turn + "'s turn.");
    }
}
