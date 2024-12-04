import java.io.File;
import java.io.FileNotFoundException;
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
        for (int i = 0; i < grid.length - 3;i++){
            for (int c = 0;c < grid[i].length - 3;c++){
                if ((grid[i][c] + grid[i][c + 1] + grid[i][c + 2] + grid[i][c + 3]).equals("XMAS") || (grid[i][c] + grid[i][c + 1] + grid[i][c + 2] + grid[i][c + 3]).equals("SAMX")){
                    num++;
                }
                if ((grid[i][c] + grid[i+1][c] + grid[i+2][c] + grid[i+3][c]).equals("XMAS") || (grid[i][c] + grid[i+1][c] + grid[i+2][c] + grid[i+3][c]).equals("SAMX")){
                    num++;
                }
                if ((grid[i][c] + grid[i + 1][c + 1] + grid[i + 2][c + 2] + grid[i + 3][c + 3]).equals("XMAS") || (grid[i][c] + grid[i + 1][c + 1] + grid[i + 2][c + 2] + grid[i + 3][c + 3]).equals("SAMX")) {
                    num++;
                }
            }
        }
        System.out.println(num);

    }
}
