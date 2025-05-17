package Week1;

public class HelloBiodome07 {
    public static void main(String[] args) {
        // 입력 유효성 검사
        if (args.length == 0 || args[0].trim().isEmpty()) {
            System.out.println("염기서열이 입력되지 않았습니다.");
            return;
        }

        String rawInput = args[0];
        String cleanInput = removeExtraSpaces(rawInput);

        if (!isValidSequence(cleanInput.toUpperCase())) {
            System.out.println("염기서열은 C,J,H,E,Y 다섯가지만 입력 가능합니다.");
            return;
        }

        String compressed = compressDNA(cleanInput.toUpperCase());
        System.out.println(compressed);
    }

    public static String compressDNA(String sequence) {

        return "";
    }

    public static String removeExtraSpaces(String input) {
        return input.trim().replaceAll("\\s+", " ");
    }

    public static boolean isValidSequence(String input) {
        for (int i = 0; i < input.length(); i++) {
            char c = Character.toUpperCase(input.charAt(i));
            if (!(c == 'C' || c == 'J' || c == 'H' || c == 'E' || c == 'Y' || c == ' ')) {
                return false;
            }
        }
        return true;
    }
}