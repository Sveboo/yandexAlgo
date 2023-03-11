import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class task_4 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            int countStud = Integer.parseInt(reader.readLine());
            int countVar = Integer.parseInt(reader.readLine());
            int row = Integer.parseInt(reader.readLine());
            int position = Integer.parseInt(reader.readLine());

            int nextRow = row + countVar / 2, prevRow = row - countVar / 2;
            int nextPosition = position, prevPosition = position;
            if (countVar % 2 == 1){
                if (position + 1 > 2){
                    ++nextRow;
                    nextPosition = 1;
                }else {
                    nextPosition = 2;
                }

                if(position - 1 < 1){
                    --prevRow;
                    prevPosition = 2;
                }else{
                    prevPosition = 1;
                }
            }

            if (prevRow > 0 && ((nextRow * 2 + nextPosition - 1) < countStud)){
                int tPrev = row - prevRow;
                int tNext = nextRow - row;
                if(tPrev < tNext){
                    System.out.println(prevRow + " " + prevPosition);
                }else{
                    System.out.println(nextRow + " " + nextPosition);
                }
            } else if (prevRow <= 0 && (nextRow * 2 + nextPosition - 1) < countStud) {
                System.out.println(nextRow + " " + nextPosition);
            }else if(prevRow > 0){
                System.out.println(prevRow + " " + prevPosition);
            }else {
                System.out.println(-1);
            }
        }
    }
}
