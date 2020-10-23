package aisd.lab2.sortcomparison;

import java.util.Random;

public class DataGenerator {

    public double[] optimisticData(int vectorLength) {

        double[] data = new double[vectorLength];
        double step = 1000 / vectorLength;

        for (int i = 0; i < vectorLength; i++) {
            data[i] = 0 + i * step;
        }

        return data;
    }

    public double[] pessimisticData(int vectorLength) {

        double[] data = new double[vectorLength];
        double step = 1000 / vectorLength;

        for (int i = 0; i < vectorLength; i++) {
            data[i] = 1000 - i * step;
        }

        return data;
    }

    public double[] randomData(int vectorLength) {

        double[] data = new double[vectorLength];
        Random rand = new Random();

        for (int i = 0; i < vectorLength; i++) {
            data[i] = 2000 * rand.nextDouble() - 1000;
        }

        return data;
    }

}
