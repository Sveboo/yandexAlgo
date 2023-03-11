import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class task_3 {

    static int binSearch(int[] arr, int target, int right) {
        int left = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] >= target) {
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            int n = Integer.parseInt(reader.readLine());
            String varMarks = reader.readLine();
            int countCollector = Integer.parseInt(reader.readLine());
            String varCollect = reader.readLine();

            if(n == 0){
                for (int i = 0; i < countCollector; ++i){
                    System.out.println(0);
                }
                return;
            }

            if(countCollector == 0){
                return;
            }
                int[] marks = new int[n];
                int i = 0, count = 1;
                for (String el : varMarks.split(" ")) {
                    marks[i++] = Integer.parseInt(el);
                }

                int[] newMarks = new int[n];
                Arrays.sort(marks);
                newMarks[0] = marks[0];
                for (i = 1; i < n; ++i) {
                    if (marks[i] != marks[i - 1]) {
                        newMarks[count++] = marks[i];
                    }
                }


                for (String el : varCollect.split(" ")) {
                        int mark = Integer.parseInt(el);
                        int result = binSearch(newMarks, mark, count - 1);
                    System.out.println(result);
                }

        }
    }
}
