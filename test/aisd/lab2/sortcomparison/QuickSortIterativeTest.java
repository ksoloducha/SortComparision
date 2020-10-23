package aisd.lab2.sortcomparison;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class QuickSortIterativeTest {

    private QuickSortIterative qsIt;

    @Before
    public void setUp() {
        qsIt = new QuickSortIterative();
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throwIllegalArgumentException_when_unsortedVectorIsNull() {
        double[] unsortedVector = null;

        qsIt.sort(unsortedVector);
    }

    @Test
    public void should_returnEmptyVector_when_unsortedVectorIsEmpty() {
        double[] unsortedVector = {};

        double[] resultArray = qsIt.sort(unsortedVector);
        double[] expectedResultArray = {};

        Assert.assertArrayEquals(expectedResultArray, resultArray, 0);
    }

    @Test
    public void should_returnSortedVector_when_givenUnsortedVector() {
        double[] unsortedVectorWithPivotInTheMiddle = {-3, 1, 0, 5, 1, 6};
        double[] unsortedVectorWithPivotAtFirstPosition = {5, 1, -3, 0, 1, 6};
        double[] unsortedVectorWithPivotAtLastPosition = {6, 1, -3, 0, 1, 5};

        double[] resultArrayForPivotInTheMiddle = qsIt.sort(unsortedVectorWithPivotInTheMiddle);
        double[] resultArrayForPivotAtFirstPosition = qsIt.sort(unsortedVectorWithPivotAtFirstPosition);
        double[] resultArrayForPivotAtLastPosition = qsIt.sort(unsortedVectorWithPivotAtLastPosition);
        double[] expectedResultArray = {-3, 0, 1, 1, 5, 6};

        Assert.assertArrayEquals(expectedResultArray, resultArrayForPivotInTheMiddle, 0);
        Assert.assertArrayEquals(expectedResultArray, resultArrayForPivotAtFirstPosition, 0);
        Assert.assertArrayEquals(expectedResultArray, resultArrayForPivotAtLastPosition, 0);
    }
}
