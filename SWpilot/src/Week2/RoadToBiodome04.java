package Week2;

import java.text.DecimalFormat;

public class RoadToBiodome04 {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No input provided.");
            return;
        }

        int[] numbers = parseArguments(args);
        if (numbers == null) return;

        selectionSort(numbers);

        double average = computeAverage(numbers);
        double median = computeMedian(numbers);

        System.out.printf("평균값 : %s, 중앙값 : %s%n",
                formatNumber(average), formatNumber(median));
    }

    private static int[] parseArguments(String[] args) {
        int[] numbers = new int[args.length];
        try {
            for (int i = 0; i < args.length; i++) {
                numbers[i] = Integer.parseInt(args[i]);
            }
            return numbers;
        } catch (NumberFormatException e) {
            System.out.println("Invalid input detected.");
            return null;
        }
    }

    private static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) minIndex = j;
            }
            swap(arr, i, minIndex);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static double computeAverage(int[] arr) {
        int sum = 0;
        for (int num : arr) sum += num;
        return (double)sum / arr.length;
    }

    private static double computeMedian(int[] arr) {
        int n = arr.length;
        if (n % 2 == 1) return arr[n/2];
        return (arr[(n/2)-1] + arr[n/2]) / 2.0;
    }

    private static String formatNumber(double num) {
        return new DecimalFormat("#.##").format(num);
    }
}