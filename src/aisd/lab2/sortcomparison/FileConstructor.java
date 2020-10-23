package aisd.lab2.sortcomparison;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileConstructor {

    public void insertSortTime(int numberOfTests, int maxVectorLength, String outputFile) {

        if (numberOfTests > maxVectorLength) {
            throw new IllegalArgumentException("Vector length has to increase in each test");
        }
        InsertSort insertSort = new InsertSort();
        sortTime(numberOfTests, maxVectorLength, outputFile, insertSort);
    }

    public void quickSortTime(int numberOfTests, int maxVectorLength, String outputFile) {

        if (numberOfTests > maxVectorLength) {
            throw new IllegalArgumentException("Vector length has to increase in each test");
        }
        QuickSortIterative quickSort = new QuickSortIterative();
        sortTime(numberOfTests, maxVectorLength, outputFile, quickSort);
    }

    private void sortTime(int numberOfTests, int maxVectorLength, String outputFile, SortingAlgorithm algorithm) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile, false))) {

            DataGenerator dataGenerator = new DataGenerator();

            writer.flush();

            int step = maxVectorLength / numberOfTests;
            int vectorLength;

            for (vectorLength = step; vectorLength <= maxVectorLength; vectorLength += step) {

                long optimisticAvgTime = 0;
                long pessimisticAvgTime = 0;
                long randomAvgTime = 0;

                for (int i = 1; i <= 10; i++) {
                    double[] optimisticVectorToSort = dataGenerator.optimisticData(vectorLength);
                    double[] pessimisticVectorToSort = dataGenerator.pessimisticData(vectorLength);
                    double[] randomVectorToSort = dataGenerator.randomData(vectorLength);

                    optimisticAvgTime += measureTime(optimisticVectorToSort, algorithm);
                    pessimisticAvgTime += measureTime(pessimisticVectorToSort, algorithm);
                    randomAvgTime += measureTime(randomVectorToSort, algorithm);
                }

                optimisticAvgTime /= 10;
                pessimisticAvgTime /= 10;
                randomAvgTime /= 10;

                writer.write(vectorLength + " " + optimisticAvgTime + " " + pessimisticAvgTime + " " + randomAvgTime + "\n");
            }
        } catch (IOException e) {
        }
    }

    private long measureTime(double[] vectorToSort, SortingAlgorithm algorithm) {
        long startTime;
        long stopTime;

        startTime = System.nanoTime();
        algorithm.sort(vectorToSort);
        stopTime = System.nanoTime();

        return stopTime - startTime;
    }
;
}
