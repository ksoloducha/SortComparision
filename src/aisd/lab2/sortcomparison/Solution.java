package aisd.lab2.sortcomparison;

public class Solution {

    public static void main(String[] args) {

        FileConstructor fc = new FileConstructor();
        fc.insertSortTime(100, 1000, "..\\AiSD-Lab2-SortComparison\\output_data\\insertSort_time.txt");
        fc.quickSortTime(100, 1000, "..\\AiSD-Lab2-SortComparison\\output_data\\quickSort_time.txt");
    }
}
