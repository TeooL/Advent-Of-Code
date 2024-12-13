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
        int columns = allMatches.getFirst().length();
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
        boolean notRepeating = true;
        String direction = "up";
        ArrayList<String> positions = new ArrayList<>();
        while (notRepeating){
            positions.add(startRow + "|" + startColumn);
            if (direction.equals("up")){
                if (grid[startRow - 1][startColumn].equals("#")){
                    direction = "right";
                }
                else{
                    startRow--;
                }
            }
            if (direction.equals("right")){
                if (grid[startRow][startColumn+1].equals("#")){
                    direction = "down";
                }
                else{
                    startColumn++;
                }
            }
            if (direction.equals("down")){
                if (grid[startRow+1][startColumn].equals("#")){
                    direction = "left";
                }
                else{
                    startRow++;
                }
            }
            if (direction.equals("left")){
                if (grid[startRow][startColumn-1].equals("#")){
                    direction = "up";
                }
                else{
                    startColumn--;
                }
            }
            for (int i = 0; i<positions.size();i++){
            }
        }
    }
}
