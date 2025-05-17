package Week2;

import java.util.ArrayList;
import java.util.List;

public class RoadToBiodome01 {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();

        for (String arg : args) {
            try {
                int num = Integer.parseInt(arg);
                if (num < 0 || num > 1000) {
                    System.out.println("입력된 값의 범위가 올바르지 않습니다. 0에서 1000까지의 값을 입력해주세요.");
                    return;
                }
                numbers.add(num);
            } catch (NumberFormatException e) {
                System.out.println("입력된 값의 범위가 올바르지 않습니다. 0에서 1000까지의 값을 입력해주세요.");
                return;
            }
        }

        int[] counts = new int[1001];
        for (int num : numbers) {
            counts[num]++;
        }

        for (int num : numbers) {
            if (counts[num] == 1) {
                System.out.println(num);
                return;
            }
        }
    }
}