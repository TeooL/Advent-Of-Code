import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Executable;
import java.util.ArrayList;
import java.util.Scanner;

public class Day4_2024 {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("src/day4input.txt");
        Scanner s = new Scanner(f);
        ArrayList<String> allMatches = new ArrayList<String>();
        while (s.hasNext()) {
            allMatches.add(s.nextLine());
        }
        int rows = allMatches.size();
        int columns = allMatches.getFirst().length();
        String[][] grid = new String[rows][columns];
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                grid[r][c] = allMatches.get(r).substring(c, c+1);
            }
        }

        int num = 0;

        for (int i = 0; i < grid.length;i++){
            for (int c = 0;c < grid[0].length;c++){
                    try {
                        if ((grid[i][c] + grid[i][c + 1] + grid[i][c + 2] + grid[i][c + 3]).equals("XMAS")) { //XMAS RIGHT
                            num++;
                        }
                    } catch(Exception e){
                        System.out.println("");
                    }
                    try {
                        if ((grid[i][c] + grid[i][c - 1] + grid[i][c - 2] + grid[i][c - 3]).equals("XMAS")) { //XMAS LEFT
                            num++;
                        }
                    } catch (Exception e){
                        System.out.println("");
                    }
                    try {
                        if ((grid[i][c] + grid[i + 1][c] + grid[i + 2][c] + grid[i + 3][c]).equals("XMAS")) { //XMAS DOWN
                            num++;
                        }
                    } catch (Exception e){
                        System.out.println("");
                    }
                    try {
                        if ((grid[i][c] + grid[i - 1][c] + grid[i - 2][c] + grid[i - 3][c]).equals("XMAS")) { // XMAS UP
                            num++;
                        }
                    } catch (Exception e){
                        System.out.println("");
                    }
                    try {
                        if ((grid[i][c] + grid[i + 1][c + 1] + grid[i + 2][c + 2] + grid[i + 3][c + 3]).equals("XMAS")) { //XMAS DOWN RIGHT
                            num++;
                        }
                    } catch (Exception e){
                        System.out.println("");
                    }
                    try {
                        if ((grid[i][c] + grid[i - 1][c + 1] + grid[i - 2][c + 2] + grid[i - 3][c + 3]).equals("XMAS")) { //XMAS UP RIGHT
                            num++;
                        }
                    } catch (Exception e){
                        System.out.println("");
                    }
                    try {
                        if ((grid[i][c] + grid[i - 1][c - 1] + grid[i - 2][c - 2] + grid[i - 3][c - 3]).equals("XMAS")) { //XMAS UP LEFT
                            num++;
                        }
                    } catch (Exception e){
                        System.out.println("");
                    }
                    try {
                        if ((grid[i][c] + grid[i + 1][c - 1] + grid[i + 2][c - 2] + grid[i + 3][c - 3]).equals("XMAS")) { //XMAS DOWN LEFT
                            num++;
                        }
                    } catch (Exception e){
                        System.out.println("");
                    }
            }
        }
        System.out.println(num);
    }
}
