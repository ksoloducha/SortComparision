package aisd.lab2.sortcomparison;

public class InsertSort implements SortingAlgorithm {

    @Override
    public double[] sort(double[] unsortedVector) {
        if (unsortedVector == null) {
            throw new IllegalArgumentException("Unsorted vector cannot be null.");
        }

        double[] vectorToSort = unsortedVector.clone();
        int n = vectorToSort.length;

        int j;
        for (int i = 1; i < n; i++) {
            double valueToInsert = vectorToSort[i];

            j = i - 1;
            while (j >= 0 && vectorToSort[j] > valueToInsert) {
                vectorToSort[j + 1] = vectorToSort[j];
                j--;
            }
            vectorToSort[j + 1] = valueToInsert;
        }
        return vectorToSort;
    }
}
