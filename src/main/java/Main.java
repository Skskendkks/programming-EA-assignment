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
            System.out.print("Enter row and column (e.g., 0 1): ");
            int row = kb.nextInt();   
            int col = kb.nextInt();

            updataarray(row, col);
            printtable();
        }

        public static void updataarray(int row, int col) {
            gametable[row][col] = turn;
            if (turn == 1) {
                turn = 2;
            } else {
                turn = 1;
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
            if (turn == 1) {
                System.out.println("Player 1's turn.");
            } else {
                System.out.println("Player 2's turn.");
            }
        }
    }