import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Day5_2024 {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("src/day5inputRules.txt");
        Scanner s = new Scanner(f);
        ArrayList<String> rules = new ArrayList<String>();
        while (s.hasNextLine()){
            rules.add(s.nextLine());
        }
        File f2 = new File("src/day5input.txt");
        Scanner s2 = new Scanner(f2);
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        while (s2.hasNextLine()){
            String line = s2.nextLine();
            ArrayList<Integer> array = new ArrayList<>();
            for (String l : line.split(",")){
                array.add(Integer.parseInt(l));
            }
            arr.add(array);
        }

        for (int i = 0; i < arr.size();i++){
            for (int n = 0; n < rules.size();n++){
                ArrayList<Integer> rule = new ArrayList<>();
            }
        }

        System.out.println(rules);
        System.out.println(arr);
    }
}
