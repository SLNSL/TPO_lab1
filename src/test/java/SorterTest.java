import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class SorterTest {
    private Sorter sorter;
    private ListAppender<ILoggingEvent> listAppender;

    @BeforeEach
    public void start() {
        Logger logger = (Logger) LoggerFactory.getLogger(Sorter.class);
        this.listAppender = new ListAppender<>();
        listAppender.start();
        logger.addAppender(listAppender);

        this.sorter = new Sorter();
    }

    @Test
    public void testEmpty(){
        double[] test_arr = new double[0];
        double[] expected_arr = new double[0];

        sorter.bucketSort(test_arr);

        Assertions.assertEquals("Array is empty.", listAppender.list.get(0).getMessage());
        Assertions.assertArrayEquals(expected_arr, test_arr, 0);
    }

    @Test
    public void testExpectedException(){
        double[] test_arr = {-10};

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> sorter.bucketSort(test_arr));
        Assertions.assertEquals("Created empty list of buckets.", listAppender.list.get(0).getMessage());
        Assertions.assertEquals("Added 1 buckets.", listAppender.list.get(1).getMessage());
    }

    @Test
    public void testInRangeFromZeroToOne(){
        double[] test_arr = { 0.897, 0.565, 0.656, 1.0, 0.1234, 0.665, 0.3434, 0.0 };
        double[] expected_arr = { 0.0, 0.1234, 0.3434, 0.565, 0.656, 0.665, 0.897, 1.0 };

        sorter.bucketSort(test_arr);

        Assertions.assertEquals("Created empty list of buckets.", listAppender.list.get(0).getMessage());
        Assertions.assertEquals("Added 8 buckets.", listAppender.list.get(1).getMessage());
        Assertions.assertEquals("0.897 -> buckets[3].", listAppender.list.get(2).getMessage());
        Assertions.assertEquals("0.565 -> buckets[2].", listAppender.list.get(3).getMessage());
        Assertions.assertEquals("0.656 -> buckets[2].", listAppender.list.get(4).getMessage());
        Assertions.assertEquals("1.0 -> buckets[4].", listAppender.list.get(5).getMessage());
        Assertions.assertEquals("0.1234 -> buckets[0].", listAppender.list.get(6).getMessage());
        Assertions.assertEquals("0.665 -> buckets[2].", listAppender.list.get(7).getMessage());
        Assertions.assertEquals("0.3434 -> buckets[1].", listAppender.list.get(8).getMessage());
        Assertions.assertEquals("0.0 -> buckets[0].", listAppender.list.get(9).getMessage());


        Assertions.assertArrayEquals(expected_arr, test_arr, 0);
    }

    @Test
    public void testDescending(){
        double[] test_arr = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
        double[] expected_arr = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        sorter.bucketSort(test_arr);

        Assertions.assertArrayEquals(expected_arr, test_arr, 0);

        Assertions.assertEquals("Created empty list of buckets.", listAppender.list.get(0).getMessage());
        Assertions.assertEquals("Added 11 buckets.", listAppender.list.get(1).getMessage());
        Assertions.assertEquals("10.0 -> buckets[10].", listAppender.list.get(2).getMessage());
        Assertions.assertEquals("9.0 -> buckets[9].", listAppender.list.get(3).getMessage());
        Assertions.assertEquals("8.0 -> buckets[8].", listAppender.list.get(4).getMessage());
        Assertions.assertEquals("7.0 -> buckets[7].", listAppender.list.get(5).getMessage());
        Assertions.assertEquals("6.0 -> buckets[6].", listAppender.list.get(6).getMessage());
        Assertions.assertEquals("5.0 -> buckets[5].", listAppender.list.get(7).getMessage());
        Assertions.assertEquals("4.0 -> buckets[4].", listAppender.list.get(8).getMessage());
        Assertions.assertEquals("3.0 -> buckets[3].", listAppender.list.get(9).getMessage());
        Assertions.assertEquals("2.0 -> buckets[2].", listAppender.list.get(10).getMessage());
        Assertions.assertEquals("1.0 -> buckets[1].", listAppender.list.get(11).getMessage());
        Assertions.assertEquals("0.0 -> buckets[0].", listAppender.list.get(12).getMessage());
    }

    @Test
    public void testAscending(){
        double[] test_arr = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        double[] expected_arr = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        sorter.bucketSort(test_arr);

        Assertions.assertArrayEquals(expected_arr, test_arr, 0);

        Assertions.assertEquals("Created empty list of buckets.", listAppender.list.get(0).getMessage());
        Assertions.assertEquals("Added 11 buckets.", listAppender.list.get(1).getMessage());
        Assertions.assertEquals("0.0 -> buckets[0].", listAppender.list.get(2).getMessage());
        Assertions.assertEquals("1.0 -> buckets[1].", listAppender.list.get(3).getMessage());
        Assertions.assertEquals("2.0 -> buckets[2].", listAppender.list.get(4).getMessage());
        Assertions.assertEquals("3.0 -> buckets[3].", listAppender.list.get(5).getMessage());
        Assertions.assertEquals("4.0 -> buckets[4].", listAppender.list.get(6).getMessage());
        Assertions.assertEquals("5.0 -> buckets[5].", listAppender.list.get(7).getMessage());
        Assertions.assertEquals("6.0 -> buckets[6].", listAppender.list.get(8).getMessage());
        Assertions.assertEquals("7.0 -> buckets[7].", listAppender.list.get(9).getMessage());
        Assertions.assertEquals("8.0 -> buckets[8].", listAppender.list.get(10).getMessage());
        Assertions.assertEquals("9.0 -> buckets[9].", listAppender.list.get(11).getMessage());
        Assertions.assertEquals("10.0 -> buckets[10].", listAppender.list.get(12).getMessage());
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
