import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day6_2024 {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("src/day6input.txt");
        Scanner s = new Scanner(f);
        ArrayList<String> allMatches = new ArrayList<String>();
        while (s.hasNext()) {
            allMatches.add(s.nextLine());
        }
        int rows = allMatches.size();
        int columns = allMatches.get(0).length();
        String[][] grid = new String[rows][columns];
        int startRow = 0;
        int startColumn = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                grid[r][c] = allMatches.get(r).substring(c, c+1);
                if (grid[r][c].equals("^")){
                    startRow = r;
                    startColumn = c;
                }
            }
        }

        // Part One
        int posCount = 0;
        String direction = "up";
        String[][] path = new String[grid.length][grid[0].length];
        for (int r = 0; r < path.length;r++){
            for (int c = 0; c < path[0].length;c++){
                path[r][c] = ".";
            }
        }
        path[startRow][startColumn] = "X";
        while (true){
            if (direction.equals("up")){
                if (startRow - 1 < 0){
                    break;
                }
                if (grid[startRow - 1][startColumn].equals("#")){
                    direction = "right";
                }
                else{
                    startRow--;
                    path[startRow][startColumn] = "X";
                }
            }
            if (direction.equals("right")){
                if (startColumn + 1 == grid[0].length){
                    break;
                }
                if (grid[startRow][startColumn+1].equals("#")){
                    direction = "down";
                }
                else{
                    startColumn++;
                    path[startRow][startColumn] = "X";
                }
            }
            if (direction.equals("down")){
                if (startRow + 1 == grid.length){
                    break;
                }
                if (grid[startRow+1][startColumn].equals("#")){
                    direction = "left";
                }
                else{
                    startRow++;
                    path[startRow][startColumn] = "X";
                }
            }
            if (direction.equals("left")){
                if (startColumn - 1 < 0){
                    break;
                }
                if (grid[startRow][startColumn-1].equals("#")){
                    direction = "up";
                }
                else{
                    startColumn--;
                    path[startRow][startColumn] = "X";
                }
            }
        }
        for (int i = 0; i < path.length; i++){
            for (int n = 0; n < path[0].length;n++){
                if (path[i][n].equals("X")){
                    posCount++;
                }
            }
        }
        System.out.println(posCount);
    }
}
