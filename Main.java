//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Main {
    public static boolean mazeExplorer(char[][] maze, int x, int y) {
        if (x < 0 || x > maze.length) {
            return false;
        }
        if (y < 0 || y > maze[0].length) {
            return false;
        }
        if (maze[x][y] == 'X' || maze[x][y] == '.' || maze[x][y] == '+') {
            return false;
        }
        if (maze[x][y] == '-') {
            return true;

        }
        maze[x][y] = '+';
        boolean solved = false;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int[] dir : directions) {
            if (mazeExplorer(maze, x + dir[0], y + dir[1])) {
                solved = true;
            }
        }
            if (!solved) {
                maze[x][y] = '.';
            }
            return solved;
    }


        public static void printArr ( char[][] a){
            for (int i = 0; i < a.length; ++i) {
                for (int k = 0; k < a[i].length; ++k) {
                    System.out.print(a[i][k]);
                }
                System.out.println();
            }
        }



    public static void main(String[] args) throws FileNotFoundException {

        //Instantiates 2d array "maze" with characters to represent grid space
        // width and height are defined for usage in other bits of code
        int startingRow = 0;
        int startingColumn = 0;

        //Read lines from text file and initiate a 2d array from file params
        File f = new File("maze.dat");
        Scanner inFile = new Scanner(f);

        int rowNum = 0;
        String line = "";


        int width, height; //will store the width and length of array

        //ASSUME FILE LENGTH > 0 & First line contains two numerals for width and length
        String firstL = inFile.nextLine();
        String[] splitString = firstL.split(" ");

        height = Integer.parseInt(splitString[0]);
        width = Integer.parseInt(splitString[1]);

        char mainMaze[][] = new char[height][width];

        while (inFile.hasNextLine()) {
            line = inFile.nextLine();
            for (int i = 0; i < line.length(); i++) {
                char b = line.charAt(i);
                mainMaze[rowNum][i] = b;
                if (b == '+') {
                    startingColumn = i;
                    startingRow = rowNum;
                }
            }
            rowNum++;
        }

        mainMaze[startingRow][startingColumn] = 'y';
        if (mazeExplorer(mainMaze, startingRow, startingColumn)) {

            System.out.println("Maze is solved!");
            for (char[] row : mainMaze) {
                System.out.println(new String(row));
            }
        } else {
            System.out.println("The Maze is unsolvable.");
        }
    }
}


