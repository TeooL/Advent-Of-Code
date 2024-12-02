import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day2_2024 {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("src/Day2Input.txt");
        Scanner s = new Scanner(f);
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        while (s.hasNext()) {
            String line = s.nextLine();
            ArrayList<Integer> level = new ArrayList<Integer>();
            for (String l: line.split(" ")){
                level.add(Integer.parseInt(l));
            }
            arr.add(level);
        }
        System.out.println(arr);
        int safe = 0;
        for (int i = 0; i < arr.size();i++){
            int count = 0;
            for (int n = 0; n < arr.get(i).size()-1;n ++){
                if (arr.get(i).get(n) > arr.get(i).get(n+1)){
                    if (arr.get(i).get(n) - arr.get(i).get(n+1) <= 3){
                        count++;
                    }
                }
            }
            if (count == arr.get(i).size()-1){
                safe++;
            }
        }
        for (int i = 0; i < arr.size();i++){
            int count = 0;
            for (int n = 0; n < arr.get(i).size()-1;n ++) {
                if (arr.get(i).get(n) < arr.get(i).get(n + 1)) {
                    if (arr.get(i).get(n + 1) - arr.get(i).get(n) <= 3) {
                        count++;
                    }
                }
            }
            if (count == arr.get(i).size()-1){
                safe++;
            }
        }
        System.out.println(safe);


        int dampener = 0;
        for (int i = 0; i < arr.size();i++){
            int count = 0;
            int wrongLevel = 0;
            for (int n = 0; n < arr.get(i).size()-1;n ++) {
                    if (arr.get(i).get(n) > arr.get(i).get(n + 1)) {
                        if (arr.get(i).get(n) - arr.get(i).get(n + 1) <= 3) {
                            count++;
                        } else {
                            wrongLevel++;
                        }
                    }
                    else {
                        break;
                    }
                }
            if (wrongLevel == 1){
                dampener++;
            }
        }
        for (int i = 0; i < arr.size();i++){
            int count = 0;
            int wrongLevel = 0;
            for (int n = 0; n < arr.get(i).size()-1;n ++) {
                    if (arr.get(i).get(n) < arr.get(i).get(n + 1)) {
                        if (arr.get(i).get(n + 1) - arr.get(i).get(n) <= 3) {
                            count++;
                        }
                        else{
                            wrongLevel++;
                        }
                    }
                    else if (arr.get(i).get(n) == arr.get(i).get(n + 1)) {
                        wrongLevel++;
                    }
                    else {
                        break;
                    }
                }
            if (wrongLevel == 1){
                dampener++;
            }
        }
        System.out.println(dampener);
    }
}
