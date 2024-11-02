import java.util.Scanner;

public class Main {
    static int [][] gametable = new int [10][10];
    static int turn = 1;
    static int row;
    static int col;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        printtable();
        while (checkwin() == false) {
            System.out.print("Enter row and column (e.g., 0 1): ");
            row = kb.nextInt();   
            col = kb.nextInt();
            //check the input value is it vaild. 
            while (row < 0 || row > 9 || col < 0 || col > 9) {
                System.out.println("out of range! Input again.");
                System.out.print("Enter row and column (e.g., 0 1): ");
                row = kb.nextInt(); 
                col = kb.nextInt();
            }
            //Check the move is it vaild. 
            while (gametable[row][col] == 1 || gametable[row][col] == 2) {
                System.out.println("invaild move. Try again.");
                System.out.print("Enter row and column (e.g., 0 1): ");
                row = kb.nextInt(); 
                col = kb.nextInt();
            }


            updataarray(row, col);

            checkwin();
            printtable();
            if (checkwin() == true) {
                System.out.println("Player "+ turn + " wins!");
                break;
            }
        }

    }
    //update the game table 
    public static void updataarray(int row, int col) {
        gametable[row][col] = turn;
        if (turn == 1) {
            turn = 2;
        } else {
            turn = 1;
        }
    }
    //print the game table

    public static boolean checkwin() {
        boolean checkrow = false;
        boolean checkcol = false;
        boolean checkslash = false;
        boolean checkbackslash = false;

        for (int i = 0; i < 4; i++) {
            if (col + i + 1 < gametable[row].length && gametable[row][col + i] == gametable[row][col + i + 1] && turn == gametable[row][col]) {
                checkrow = true;
            } else {
                break;
            }

            if (col - i - 1 >= 0 && gametable[row][col - i] == gametable[row][col - i - 1] && turn == gametable[row][col]) {
                checkrow = true;
            } else {
                break;
            }

            if (checkrow) {
                return true;
            }

            if (row + i + 1 < gametable.length && gametable[row + i][col] == gametable[row + i + 1][col] && turn == gametable[row][col]) {
                checkcol = true;
            } else {
                break;
            }

            if (row - i - 1 >= 0 && gametable[row - i][col] == gametable[row - i - 1][col] && turn == gametable[row][col]) {
                checkcol = true;
            } else {
                break;
            }

            if (checkcol) {
                return true;
            }
            if (row + i + 1 < gametable.length && col + 1 + i < gametable[row].length && gametable[row + i][col + i] == gametable[row + i + 1][col + i + 1] && turn == gametable[row][col]){
                checkbackslash = true;
            } else {
                break;
            }
            if (row-i-1 >= 0 && col-i-1 <=0 && gametable[row-i][col-i] == gametable[row-i-1][col-i-1] && turn == gametable[row][col]) {
                checkbackslash = true; 
            }else {
                break;
            }
            if (row + i + 1 < gametable.length && col -i-1 <=0 && gametable[row+i][col-i] == gametable[row+i+1][col-i-1] && turn == gametable[row][col]){
                checkslash = true; 
            } else {
                break; 
            }
            if (row-i-1 <=0 && col+i+1 < gametable[row].length && gametable[row-i][col+i] == gametable[row-i-1][col+i+1] && turn == gametable[row][col]){
                checkslash = true;
            }else {
                break;
            }
        }
        if (checkcol || checkrow || checkbackslash || checkslash == true){
            return true; 
        } else {
            return false;
        }

    }






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
        System.out.println("Player "+ turn +"'s turn.");



    }
}
