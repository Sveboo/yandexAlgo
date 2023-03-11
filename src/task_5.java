import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

public class task_5 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            int n = Integer.parseInt(reader.readLine());
            long result = 0;
            int[] charArr = new int[n];
            Set<Integer> levels= new TreeSet<>();
            for(int i = 0; i < n; ++i){
                int countChar = Integer.parseInt(reader.readLine());
                charArr[i] = countChar;
                levels.add(countChar);
            }

            int prevLevel = 0;
            for (Integer level : levels){
                int lenSeq = 0;
                for (int i = 0; i < n - 1; ++i){
                    if (charArr[i] >= level && charArr[i + 1] >= level){
                        ++lenSeq;
                    }
                }

                result += (long) lenSeq * (level - prevLevel);
                prevLevel = level;
            }



            System.out.println(result);
        }
    }
}
