import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;

public class task_12 {

    static String isValid(String input) {
        Stack<Character> stack = new Stack<>();
        char[] temp = input.toCharArray();

        for (char el : temp) {
            switch (el) {
                case '(', '[', '{' -> stack.push(el);
                case ')' -> {
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return "no";
                    }
                }

                case '}' -> {
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return "no";
                    }
                }

                case ']' -> {
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return "no";
                    }
                }
            }
        }

        return stack.isEmpty()? "yes" : "no";
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String line = reader.readLine();

            try (FileWriter writer = new FileWriter("output.txt")) {
                writer.write(isValid(line));
                writer.flush();
            }
        }
    }
}

