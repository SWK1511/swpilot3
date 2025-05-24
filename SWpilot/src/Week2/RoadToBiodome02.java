package Week2;

import java.util.ArrayList;
import java.util.List;

public class RoadToBiodome02 {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("올바른 문장을 입력해주세요.");
            return;
        }

        String input = args[0];

        if (input.length() < 2 || input.length() > 1_000_000) {
            System.out.println("올바른 문장을 입력해주세요.");
            return;
        }

        if (input.trim().isEmpty()) {
            System.out.println("올바른 문장을 입력해주세요.");
            return;
        }

        if (isPalindrome(input)) {
            System.out.println(input);
            return;
        }

        List<Character> stack = new ArrayList<>();
        for (char c : input.toCharArray()) {
            push(stack, c);
        }

        char[] reversed = new char[stack.size()];
        for (int i = 0; i < reversed.length; i++) {
            reversed[i] = pop(stack);
        }

        System.out.println(new String(reversed));
    }
    private static boolean isPalindrome(String s) {
        int n = s.length();
        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    private static void push(List<Character> stack, char c) {
        stack.add(c);
    }

    private static char pop(List<Character> stack) {
        if (stack.isEmpty()) {
            throw new RuntimeException("Stack underflow");
        }
        return stack.remove(stack.size() - 1);
    }
}

//pop이 거꾸로 나오는거라 reversed를 꼭 할 필요없음. Stack 라이브러리를 만들고....