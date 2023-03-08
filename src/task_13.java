import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;

public class task_13 {

    static private boolean IsOperator(String c)
    {
        return  ("+-*".contains(c));
    }


    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String[] line = reader.readLine().split(" ");
            int result = 0;
            for (String el : line){
                if (IsOperator(el)) {
                    int a = stack.pop();
                    int b = stack.pop();
                    switch (el.charAt(0)) {
                        case '+' -> result = b + a;
                        case '-' -> result = b - a;
                        case '*' -> result = b * a;
                    }
                    stack.push(result);
                }

                else{
                    stack.push(Integer.parseInt(el));
                }
            }
        }

        String result = Integer.toString(stack.pop());
        try (FileWriter writer = new FileWriter("output.txt")) {
            writer.write(result);
            writer.flush();
        }
    }
}

