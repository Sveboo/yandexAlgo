import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class task_2 {
    public static void main(String[] args) throws IOException {
        try(BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            int k = Integer.parseInt(reader.readLine());
            char[] line = reader.readLine().toCharArray();
            int[] dict = new int[26];
            int maxCnt = 0;
            int ind = 0;
            for (int i = 0; i < line.length; i++) {
                maxCnt = Math.max(maxCnt, ++dict[line[i] - 'a']);
                if (maxCnt + k - 1 < i - ind){
                    dict[line[ind++] - 'a']--;
                }
            }
            String result = Integer.toString(line.length - ind);
            try (FileWriter writer = new FileWriter("output.txt")) {
                writer.write(result);
                writer.flush();
            }


        }
    }
}
