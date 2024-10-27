//The source file name is :Gomoko_Game.java
//Name: Yeung Wang Sang
//Class: SE1A
//Student NO: 240021235
//description of the program: 10 by 10 4-win Gomoko games, 

import java.util.Scanner;

public class Main {
    int[][] gametable = {
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
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.print("Enter row and column (e.g., 0 1): ");
        int row = kb.nextInt();   
        int col = kb.nextInt();

        int i = 0;
        int turn = 1;
        
        updatearrary();
    public static void updataarray(){
        gametable[row][col] = turn;
    }
    
    public static void printtable(){
        while (i < 10) {
            System.out.print(i + " | ");
            for (int n = 0; n < gametable[i].length; n++) {
                System.out.print(gametable[i][n] + " ");
            }
            System.out.println();
            i++;
        }
        System.out.println("  +--------------------\n    0 1 2 3 4 5 6 7 8 9 ");
        if (turn == 1) {
            System.out.println("Player 1's turn.");
        } else {
            System.out.println("Player 2's turn.");
        }
        System.out.println("Enter row and column (e.g., 0 1): ");
    }
}