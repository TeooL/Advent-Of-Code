import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day7_2024 {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("src/day7input.txt");
        Scanner s = new Scanner(f);
        ArrayList<String> arr = new ArrayList<String>();
        while(s.hasNext()){
            arr.add(s.nextLine());
        }

        int sum = 0;
        for (String string : arr){
            ArrayList<String> currentLine = convertLineInput(string);
            int lineTotal = lineTotal(currentLine);
            currentLine.removeFirst();
            ArrayList<Integer> inputs = new ArrayList<>();
            for (String i : currentLine){
                inputs.add(Integer.parseInt(i));
            }
            if (isTrue(inputs, 0, lineTotal)){
                sum += lineTotal;
            }
        }

        //Finding operators for the lines
    }

    public static ArrayList<String> convertLineInput(String line){
        ArrayList<String> arr = new ArrayList<>();
        for (String i : line.split(" ")){
            arr.add(i);
        }
        return arr;
    }
    public static int lineTotal(ArrayList<String> arr){
        return Integer.parseInt(arr.get(0).substring(0,arr.get(0).indexOf(":")));
    }
    public static boolean isTrue(ArrayList<Integer> arr, int index, int total){
        if (index < arr.size() - 1){
            if (arr.get(index) + arr.get(index+1) == total){
                return true;
            }
            else if (arr.get(index) * arr.get(index+1) == total){
                return true;
            }
            else{
                //
            }
        }
        return false;
    }
}
