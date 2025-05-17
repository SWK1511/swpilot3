package Week2;

public class RoadToBiodome05 {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("두 개의 배열을 입력해야 합니다.");
            return;
        }

        int[] array1 = parseArray(args[0]);
        int[] array2 = parseArray(args[1]);

        if (array1 == null || array2 == null) {
            return;
        }

        int[] mergedArray = mergeArrays(array1, array2);
        quickSort(mergedArray, 0, mergedArray.length - 1);

        System.out.println(arrayToString(mergedArray));
    }

    private static int[] parseArray(String input) {
        if (!input.startsWith("[") || !input.endsWith("]")) {
            System.out.println("배열 형식이 올바르지 않습니다.");
            return null;
        }

        String content = input.substring(1, input.length() - 1).trim();
        if (content.isEmpty()) {
            return new int[0];
        }

        String[] elements = content.split(",");
        int[] array = new int[elements.length];

        try {
            for (int i = 0; i < elements.length; i++) {
                String element = elements[i].trim();
                int value = Integer.parseInt(element);
                if (value < 0) {
                    System.out.println("물 높이는 0 이상이어야 합니다.");
                    return null;
                }
                array[i] = value;
            }
        } catch (NumberFormatException e) {
            System.out.println("숫자가 아닌 값이 포함되어 있습니다.");
            return null;
        }

        return array;
    }

    private static int[] mergeArrays(int[] array1, int[] array2) {
        int[] merged = new int[array1.length + array2.length];
        System.arraycopy(array1, 0, merged, 0, array1.length);
        System.arraycopy(array2, 0, merged, array1.length, array2.length);
        return merged;
    }

    private static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                swap(array, i, j);
            }
        }

        swap(array, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}