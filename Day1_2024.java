import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Day1_2024 {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("src/Day1Input.txt");
        Scanner s = new Scanner(f);
        ArrayList<String> left = new ArrayList<String>();
        ArrayList<String> right = new ArrayList<String>();
        while (s.hasNext()) {
            String line = s.nextLine();
            left.add(line.substring(0,5));
            right.add(line.substring(8,13));
        }
        ArrayList<Integer> leftInt = new ArrayList<Integer>();
        ArrayList<Integer> rightInt = new ArrayList<Integer>();
        for (int i = 0; i < left.size();i++){
            leftInt.add(Integer.parseInt(left.get(i)));
        }
        for (int i = 0; i < right.size();i++){
            rightInt.add(Integer.parseInt(right.get(i)));
        }
        Collections.sort(rightInt);
        Collections.sort(leftInt);
        System.out.println(rightInt);
        System.out.println(leftInt);
        int sum = 0;
        for (int i = 0; i < leftInt.size();i++){
            sum += Math.abs(rightInt.get(i) - leftInt.get(i));
        }
        System.out.println(sum);

        int similarity = 0;
        for (int i = 0; i < leftInt.size();i++){
            int count = 0;
            int num = leftInt.get(i);
            for (int n = 0; n < leftInt.size();n++){
                if (num == rightInt.get(n)){
                    count++;
                }
            }
            similarity += count * num;
        }
        System.out.println(similarity);
    }
}
