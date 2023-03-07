import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class SorterTest {
    private static Sorter sorter;

    @BeforeAll
    static void start() {
        SorterTest.sorter = new Sorter();
    }

    @Test
    public void testEmpty(){
        double[] test_arr = new double[0];
        double[] expected_arr = new double[0];

        sorter.bucketSort(test_arr);

        Assertions.assertArrayEquals(expected_arr, test_arr, 0);
    }

    @Test
    public void testExpectedException(){
        double[] test_arr = {-10};

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> sorter.bucketSort(test_arr));
    }

    @Test
    public void testInRangeFromZeroToOne(){
        double[] test_arr = { 0.897, 0.565, 0.656, 1.0, 0.1234, 0.665, 0.3434, 0.0 };
        double[] expected_arr = { 0.0, 0.1234, 0.3434, 0.565, 0.656, 0.665, 0.897, 1.0 };

        sorter.bucketSort(test_arr);

        Assertions.assertArrayEquals(expected_arr, test_arr, 0);
    }

    @Test
    public void testDescending(){
        double[] test_arr = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
        double[] expected_arr = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        sorter.bucketSort(test_arr);

        Assertions.assertArrayEquals(expected_arr, test_arr, 0);
    }

    @Test
    public void testAscending(){
        double[] test_arr = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        double[] expected_arr = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        sorter.bucketSort(test_arr);

        Assertions.assertArrayEquals(expected_arr, test_arr, 0);
    }

    @Test
    public void testRandomInRangeFromZeroToThousand(){
        double[] test_arr = new double[100];
        double[] expected_arr = new double[100];

        for (int i = 0; i < 100; i++) {
            test_arr[i] = Math.random() * 1000;
            expected_arr[i] = test_arr[i];
        }

        Arrays.sort(expected_arr);
        sorter.bucketSort(test_arr);

        Assertions.assertArrayEquals(expected_arr, test_arr, 0);
    }
}
