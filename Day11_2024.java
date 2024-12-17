import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day11_2024 {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("src/day11input.txt");
        Scanner s = new Scanner(f);
        ArrayList<String> arr = new ArrayList<>();
        while (s.hasNext()){
            arr.add(s.nextLine());
        }
        ArrayList<Integer> stones = new ArrayList<>();
        for (String string: arr.getFirst().split(" ")){
            stones.add(Integer.parseInt(string));
        }
        for (int i = 0; i < 25;i++){
            for (int n = 0; n < stones.size();n++){
                int numDigits = getNumDigits(stones.get(n));
                if (stones.get(n) == 0){
                    stones.set(n, 0);
                }
                if (numDigits % 2 == 0){
                    //make left half and right half
                }
            }
        }
    }
    public static int getNumDigits(int num){
        int digits = 0;
        while (num > 0){
            num /= 10;
            digits++;
        }
        return digits;
    }
}
