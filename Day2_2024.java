

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


        int safe2 = 0;
        for (int i = 0; i < arr.size();i++){
            ArrayList<Integer> level = arr.get(i);
            // Check if safe
            //First all increasing and differ by 1 <= x <= 3
            boolean allIncreasingSafe = true;
            for (int n = 0; n < level.size() - 1 ; n++){
                if (level.get(n+1) < level.get(n) || level.get(n+1) - level.get(n) > 3 || level.get(n+1) - level.get(n) < 1){
                 allIncreasingSafe = false;
                 break;
                }
            }
            if (allIncreasingSafe){
                System.out.println(level);
                safe2++;
            }
            //Second all decreasing and differ by 1 <= x <= 3
            boolean allDecreasingSafe = true;
            for (int n = 0; n < level.size() - 1; n++){
                if (level.get(n) < level.get(n+1) || level.get(n) - level.get(n+1) > 3 || level.get(n) - level.get(n+1) < 1){
                    allDecreasingSafe = false;
                    break;
                }
            }
            if (allDecreasingSafe){
                System.out.println(level);
                safe2++;
            }

            //Third check unsafe levels for single bad level
            boolean mostlyIncreasing = false;
            boolean mostlyDecreasing = false;
            int incrCount = 0;
            int decrCount = 0;
            for (int n = 0; n < level.size()-1;n++){
                if (level.get(n+1) - level.get(n) > 0){
                    incrCount++;
                }
                if (level.get(n+1) - level.get(n) < 0){
                    decrCount++;
                }
            }
            if (incrCount > decrCount){
                mostlyIncreasing = true;
            } else{
                mostlyDecreasing = true;
            }

            ArrayList<Integer> currentLevel = level;
            if (mostlyIncreasing){
                int removes = 0;
                for (int n = 0; n < currentLevel.size() - 1;n++){
                    if (currentLevel.get(n+1) - currentLevel.get(n) > 3 || currentLevel.get(n) - currentLevel.get(n+1) == 0){
                        currentLevel.remove(n);
                        removes++;
                        n=0;
                    }
                    else if (currentLevel.get(n) > currentLevel.get(n+1)){
                        currentLevel.remove(n+1);
                        removes++;
                        n=0;
                    }
                }
                if (removes == 1){
                    System.out.println(currentLevel);
                    safe2++;
                }
            }
            if (mostlyDecreasing){
                int removes = 0;
                for (int n = 0; n < currentLevel.size() - 1; n++){
                    if (currentLevel.get(n) - currentLevel.get(n+1) > 3 || currentLevel.get(n) - currentLevel.get(n+1) == 0){
                        currentLevel.remove(n);
                        removes++;
                        n=0;
                    }
                    else if (currentLevel.get(n) < currentLevel.get(n+1)){
                        currentLevel.remove(n+1);
                        removes++;
                        n=0;
                    }
                }
                if (removes == 1){
                    System.out.println(currentLevel);
                    safe2++;
                }
            }
        }
        System.out.println(safe2);
    }
}
