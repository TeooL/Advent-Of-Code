import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3_2024 {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("src/day3input.txt");
        Scanner s = new Scanner(f);
        ArrayList<String> allMatches = new ArrayList<String>();
        while (s.hasNext()) {
            String line = s.nextLine();
            String regex = "mul\\([1-9][0-9]{0,2},[1-9][0-9]{0,2}\\)";
            Matcher m = Pattern.compile(regex).matcher(line);
            while (m.find()) {
                allMatches.add(m.group());
            }
        }

        int total = 0;
        for (int i = 0; i < allMatches.size(); i++) {
            int num1Start = allMatches.get(i).indexOf("(");
            int num1End = allMatches.get(i).indexOf(",");
            int num2End = allMatches.get(i).indexOf(")");
            int firstNum = Integer.parseInt(allMatches.get(i).substring(num1Start + 1, num1End));
            int secNum = Integer.parseInt(allMatches.get(i).substring(num1End + 1, num2End));
            total += firstNum * secNum;
        }
        System.out.println(allMatches);
        System.out.println(total);
    }
}
