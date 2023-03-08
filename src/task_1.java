import java.io.*;

public class task_1 {
    public static void main(String[] args) throws IOException {
        try(BufferedReader reader = new BufferedReader(new FileReader("input.txt"))){
            String line;
            int[] dict = new int['z'+1];
            int max = 0;
            StringBuilder sb = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                char[] chars = line.toCharArray();
                for (char symb : chars) {
                    if (symb != ' ') {
                        int count = dict[symb]+ 1;
                        dict[symb] = count;
                        if (count > max){
                            max = count;
                        }
                    }
                }
            }
            for (int i = 0; i < max; i++) {
                for (int cnt_symb : dict) {
                    if (cnt_symb != 0) {
                        if (cnt_symb > max - i - 1) {
                            sb.append('#');
                        } else {
                            sb.append(' ');
                        }
                    }
                }
                sb.append('\n');
            }

            for (int i = 0; i < dict.length; ++i) {
                if (dict[i] != 0){
                    sb.append((char)i);
                }
            }

            try (FileWriter writer = new FileWriter("output.txt")) {
                writer.write(sb.toString());
                writer.flush();
            }

        }
    }
}
