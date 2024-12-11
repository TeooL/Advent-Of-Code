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

        //Part 1

        ArrayList<ArrayList<Integer>> correctList = new ArrayList<>();
        ArrayList<ArrayList<Integer>> incorrectList = new ArrayList<>();
        for (int i = 0; i < arr.size();i++){
            ArrayList<Integer> array = arr.get(i);
            boolean correct = true;
            for (int n = 0; n < rules.size();n++){
                String rule = rules.get(n);
                int rule1 = Integer.parseInt(rule.substring(0,2));
                int rule2 = Integer.parseInt(rule.substring(3,5));
                if (array.contains(rule1) && array.contains(rule2)) {
                    if (array.indexOf(rule1) > array.indexOf(rule2)) {
                        correct = false;
                    }

                }
            }
            if (correct){
                correctList.add(array);
            }
            else {
                incorrectList.add(array);
            }
        }

        int sum = 0;
        for (int i = 0; i < correctList.size(); i++){
            ArrayList<Integer> correctArr = correctList.get(i);
            System.out.println(correctArr.get(((correctArr.size()/2))));
            sum += correctArr.get(((correctArr.size()/2)));
        }
        System.out.println(sum);

        //Part 2
        int part2Sum = 0;
        ArrayList<ArrayList<Integer>> renewedList = new ArrayList<>();
        for (int i = 0; i < incorrectList.size();i++){
            ArrayList<Integer> currentList = incorrectList.get(i);
            for (int n = 0; n < rules.size(); n++){
                String rule = rules.get(n);
                int rule1 = Integer.parseInt(rule.substring(0,2));
                int rule2 = Integer.parseInt(rule.substring(3,5));
                if (currentList.contains(rule1) && currentList.contains(rule2)){
                    if (currentList.indexOf(rule1) > currentList.indexOf(rule2)) {
                        int temp = currentList.indexOf(rule2);
                        currentList.set(currentList.indexOf(rule1), rule2);
                        currentList.set(temp, rule1);
                        n = 0;
                    }
                }
            }
            renewedList.add(currentList);
        }


        for (int i = 0; i < renewedList.size(); i++){
            ArrayList<Integer> correctArr = renewedList.get(i);
            part2Sum += correctArr.get(((correctArr.size()/2)));
        }
        System.out.println(part2Sum);
    }
}

