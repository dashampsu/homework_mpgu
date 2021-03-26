package QuadraticSort;
import java.util.Arrays;

public class QuadraticSort {
    public void sort(int[] data)
    {
        for (int i = 1; i < data.length; i++){

            int prev = i - 1;
            int temp = data[i];

            while (prev >= 0 && temp < data[prev]){
                data[prev+1] = data[prev];
                prev--;
            }
            data[prev + 1] = temp;
        }
    }
}
