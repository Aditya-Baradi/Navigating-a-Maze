//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Main {
    public static void printArr(char[][] a) {
        for(int i = 0; i < a.length; ++i) {
            for(int k = 0; k < a[i].length; ++k) {
                System.out.print(a[i][k]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        //Instantiates 2d array "maze" with characters to represent gridspace
        // width and height are defined for usage in other bits of code
        try {
            //Read lines from text file and initiate a 2d array from file params
            File f = new File("mazein.txt");
            Scanner inFile = new Scanner(f);

            int rowNum = 0;
            String line= "";

            int width, height; //will store the width and length of array

            //ASSUME FILE LENGTH > 0 & First line contains two numerals for width and length
            String firstL = inFile.nextLine();
            String[] splitString = firstL.split(" ");

            height = Integer.parseInt(splitString[0]);
            width = Integer.parseInt(splitString[1]);

            char maze[][] = new char[height][width];

            while (inFile.hasNextLine() ){
                line = inFile.nextLine();
                for(int i=0; i < line.length(); i++){
                    char a = line.charAt(i);
                    maze[rowNum][i] = a;
                }
                rowNum++;
            }

            printArr(maze);

        } catch (FileNotFoundException e) {
            ;
        }


        //TODO implement algo
        

        
    }

}