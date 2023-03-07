import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Sorter {

    static final Logger LOGGER = LoggerFactory.getLogger(Sorter.class);

    public void bucketSort(double[] arr) {
        int n = arr.length;

        if (n == 0){
            LOGGER.info("Array is empty.");
            return;
        }

        // 1) Create n empty buckets
        ArrayList<ArrayList<Double>> buckets = new ArrayList<>();
        LOGGER.info("Created empty list of buckets.");

        for (int i = 0; i < n; i++) {
            buckets.add(new ArrayList<>());
        }
        LOGGER.info("Added " + buckets.size() +" buckets.");

        // 2) Put array elements into different buckets
        double max = Arrays.stream(arr).max().getAsDouble();
        for (double val : arr) {
            double idx = val * n / (max + 1);
            buckets.get((int) idx).add(val);
            LOGGER.info(val + " -> buckets[" + (int) idx + "].");
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
