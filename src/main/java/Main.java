    import java.util.Scanner;

    public class Main {
        static int[][] gametable = {
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
        };
        static int turn = 1;

        public static void main(String[] args) {
            Scanner kb = new Scanner(System.in);
            printtable();
            while (checkwin() == false) {
                System.out.print("Enter row and column (e.g., 0 1): ");
                int row = kb.nextInt();   
                int col = kb.nextInt();
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
                printtable();
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
            return false;
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