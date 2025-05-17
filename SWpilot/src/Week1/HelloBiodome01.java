package Week1;

public class HelloBiodome01 {
    public static void main(String[] args) {
        // 사용자 입력이 없는 경우 또는 공백만 있는 경우
        if (args.length == 0 || args[0].trim().isEmpty()) {
            System.out.println("이름을 입력해주세요.");
            return;
        }

        StringBuilder nameBuilder = new StringBuilder();
        for (String arg : args) {
            nameBuilder.append(arg).append(" ");
        }

        String name = nameBuilder.toString().trim(); // 마지막 공백 제거
        System.out.println(name + "님, 환영합니다!");
    }
}