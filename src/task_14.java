import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;

public class task_14 {
    static String isValidTrain(int[] vans){
        if (vans.length == 1){
            return "YES";
        }

        Stack<Integer> stack = new Stack<>();
        int waitVan = 1;
        for (int van : vans){
            if (van != waitVan){
                stack.push(van);
            }

            else{
                ++waitVan;
                while (!stack.isEmpty() && stack.peek() == waitVan){
                    stack.pop();
                    ++waitVan;
                }
            }
        }

        return stack.isEmpty()? "YES" : "NO";
    }
    public static void main(String[] args) throws IOException {
        String result;
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            int n = Integer.parseInt(reader.readLine());
            int[] vans = new int[n];
            String[] line = reader.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                vans[i] = Integer.parseInt(line[i]);
            }

            result = isValidTrain(vans);
        }
        try (FileWriter writer = new FileWriter("output.txt")) {
            writer.write(result);
            writer.flush();
        }
    }
}
