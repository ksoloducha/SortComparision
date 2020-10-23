package aisd.lab2.sortcomparison;

import java.util.Random;

public class QuickSortIterative implements SortingAlgorithm {

    @Override
    public double[] sort(double[] unsortedVector) {
        if (unsortedVector == null) {
            throw new IllegalArgumentException("Input data cannot be null");
        }

        double[] vectorToSort = unsortedVector.clone();

        quicksort(vectorToSort);

        return vectorToSort;
    }

    private void quicksort(double[] data) {
        int[] starts = new int[data.length];
        int[] ends = new int[data.length];

        Integer left = 0;
        Integer right = data.length - 1;

        starts[0] = left;
        ends[0] = right;

        int n = 1;
        int pivot;

        if (left < right) {

            while (n > 0) {

                n--;
                left = starts[n];
                right = ends[n];
                pivot = splitData(data, left, right);

                if (pivot - 1 > left) {
                    starts[n] = left;
                    ends[n] = pivot - 1;
                    n++;
                }

                if (pivot + 1 < right) {
                    starts[n] = pivot + 1;
                    ends[n] = right;
                    n++;
                }
            }
        }
    }

    private int splitData(double[] data, int start, int end) {
        int pivot = choosePivot(data, start, end);

        int left = start != pivot ? start : start + 1;
        int right = end != pivot ? end : end - 1;

        while (left < right) {
            while (left < right && data[left] < data[pivot]) {
                left++;
            }

            while (left < right && data[right] >= data[pivot]) {
                right--;
            }

            swap(data, left, right);
        }

        if (left > pivot && data[left] >= data[pivot] && left > 0) {
            left--;
        }

        swap(data, pivot, left);

        return left;
    }

    private static int choosePivot(double[] data, int first, int last) {

        double firstValue = data[first];
        double lastValue = data[last];

        if ((last - first) == 1) {
            return first;
        } else {

            Random rand = new Random();
            int randomIndex = first + 1 + rand.nextInt(last - first - 1);
            double randomValue = data[randomIndex];

            if ((firstValue - randomValue) * (lastValue - firstValue) >= 0) {
                return first;
            } else if ((randomValue - firstValue) * (lastValue - randomValue) >= 0) {
                return randomIndex;
            } else {
                return last;
            }
        }
    }

    private void swap(double[] data, int firstId, int secondId) {
        if (firstId != secondId) {
            double firstValue = data[firstId];
            data[firstId] = data[secondId];
            data[secondId] = firstValue;
        }
    }
}
