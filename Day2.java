import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day2 {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("src/Day2Input.txt");
        Scanner s = new Scanner(f);
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        while (s.hasNextLine()) {
            String line = s.nextLine();
            ArrayList<Integer> level = new ArrayList<>();
            for (String l : line.split(" ")){
                level.add(Integer.parseInt(l));
            }
            arr.add(level);
        }
        System.out.println(arr);


        int safe = 0;
        for (int i = 0; i < arr.size();i++){
            ArrayList<Integer> level = arr.get(i);
            int minMax = arr.get(i).getFirst();
            int errors = 0;
            boolean increasing = true;
            for (int n = 1; n < level.size(); n++){
                if (level.get(n) == minMax){
                    errors++;
                }
                else if (level.get(n) < minMax ){
                    increasing = false;
                }
                if (!increasing){
                    break;
                }
            }
            if (errors == 1){
                safe++;
            }
        }
        System.out.println(safe);
    }
}
