import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;

public class task_15 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            int n = Integer.parseInt(reader.readLine());
            int[] meanCost = new int[n];
            int i = 0;
            Stack<Integer> stack = new Stack<>();
            for (String strNumber : reader.readLine().split(" ")) {
                meanCost[i++] = Integer.parseInt(strNumber);
            }
            stack.push(0);

            for(i = 1; i < n; ++i){
                while (!stack.isEmpty() && meanCost[stack.peek()] > meanCost[i]){
                    meanCost[stack.peek()] = i;
                    stack.pop();
                }
                stack.push(i);
            }

            while (!stack.isEmpty()){
                meanCost[stack.pop()] = -1;
            }
            StringBuilder ans = new StringBuilder();
            for (int el : meanCost){
                ans.append(el).append(" ");
            }
            try (FileWriter writer = new FileWriter("output.txt")) {
                writer.write(ans.toString().trim());
                writer.flush();
            }
        }


    }
}
