import java.util.Scanner;

public class Main {
    static int[][] gametable = new int[10][10];//create the game board data
    static int turn = 1;//set the user turn 
    static int row;//create the varible that user input the row
    static int col;//create the varible that user input the column

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        printtable();
        while (true) {
            System.out.print("Enter row and column (e.g., 0 1): ");
            row = kb.nextInt();
            col = kb.nextInt();
            if (row<0 || row>9 && col<0 && col>9) {
                row = kb.nextInt();
                col = kb.nextInt();
             
            }
            

            // Check the input value is valid 
            while (row < 0 || row > 9 || col < 0 || col > 9) {
                System.out.println("Out of range! Input again.");
                System.out.print("Enter row and column (e.g., 0 1): ");
                row = kb.nextInt();
                col = kb.nextInt();
            }

            // Check the move is valid
            while (gametable[row][col] == 1 || gametable[row][col] == 2) {
                System.out.println("Invalid move. Try again.");
                System.out.print("Enter row and column (e.g., 0 1): ");
                row = kb.nextInt();
                col = kb.nextInt();
            }

            // Update the game table
            updatearray(row, col);
            // Check if current player has won. 
            if (checkwin(row, col)) {
                System.out.println("Player " + gametable[row][col] + " wins!");
                break;
            }
            printtable();

            
            
        }
        kb.close();
    }
    //update the array and change the turn. 
    public static void updatearray(int row, int col) {
        gametable[row][col] = turn;
        turn = (turn == 1) ? 2 : 1;
    }
    //check the player has won in any direction. 
    public static boolean checkwin(int row, int col) {
        return checkrow(row, col) || checkcol(row, col) || checkslash(row, col);
    }
    //check the row hava the same value. 
    public static boolean checkrow(int row, int col) {
        int count = 0;//set the count if the count == 4 that mean hava the 4 same value. 
        for (int i = 0; i < 10; i++) {
            //check the col and the i it is the same value. 
            if (gametable[row][i] == gametable[row][col]) {
                count++;
                if (count == 4) return true;
            } else {
                count = 0;
            }
        }
        return false;
    }

    public static boolean checkcol(int row, int col) {
        int count = 0;
        for (int i = 0; i < 10; i++) {
            if (gametable[i][col] == gametable[row][col]) {
                count++;
                if (count == 4) return true;
            } else {
                count = 0;
            }
        }
        return false;
    }

    public static boolean checkslash(int row, int col) {
        int count = 0;
        
        for (int i = -3; i <= 3; i++) {
            int r = row + i, c = col + i;
            if (r >= 0 && r < 10 && c >= 0 && c < 10 && gametable[r][c] == gametable[row][col]) {
                count++;
                if (count == 4) return true;
            } else {
                count = 0;
            }
        }

        count = 0;
        
        for (int i = -3; i <= 3; i++) {
            int r = row + i, c = col - i;
            if (r >= 0 && r < 10 && c >= 0 && c < 10 && gametable[r][c] == gametable[row][col]) {
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
