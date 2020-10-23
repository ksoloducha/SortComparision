package aisd.lab2.sortcomparison;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InsertSortTest {

    private InsertSort insertSort;

    @Before
    public void setUp() {
        insertSort = new InsertSort();
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throwIllegalArgumentException_when_unsortedVectorIsNull() {
        double[] unsortedVector = null;

        insertSort.sort(unsortedVector);
    }

    @Test
    public void should_returnEmptyVector_when_unsortedVectorIsEmpty() {
        double[] unsortedVector = {};

        double[] resultArray = insertSort.sort(unsortedVector);
        double[] expectedResultArray = {};

        Assert.assertArrayEquals(expectedResultArray, resultArray, 0);
    }

    @Test
    public void should_returnSortedVector_when_givenUnsortedVector() {
        double[] unsortedVector = {6, 1, -3, 0, 5, 1};

        double[] resultArray = insertSort.sort(unsortedVector);
        double[] expectedResultArray = {-3, 0, 1, 1, 5, 6};

        Assert.assertArrayEquals(expectedResultArray, resultArray, 0);
    }
}
