import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Sorter {
    public void bucketSort(double[] arr) {
        int n = arr.length;

        if (n == 0)
            return;

        // 1) Create n empty buckets
        ArrayList<ArrayList<Double>> buckets = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            buckets.add(new ArrayList<>());
        }

        // 2) Put array elements into different buckets
        double max = Arrays.stream(arr).max().getAsDouble();
        for (double val : arr) {
            double idx = val * n / (max + 1);
            buckets.get((int) idx).add(val);
        }

        // 3) Sort individual buckets and concatenate them into arr
        int index = 0;
        for (ArrayList<Double> bucket : buckets) {
            Collections.sort(bucket);
            for (double value: bucket) {
                arr[index++] = value;
            }
        }
    }
}
