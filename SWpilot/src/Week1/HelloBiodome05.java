package Week1;

public class HelloBiodome05 {

    public static void main(String[] args) {

        // g,h 메서드 호출
        int[] result = gh();

        int g = result[0];
        int h = result[1];

        // 최종 계산
        int finalResult = calculate(g, h);
        System.out.println("최종 결과: " + finalResult);
    }

    public static int[] gh() {
        for (int g = 0; g < 16; g++) {
            for (int h = 0; h < 16; h++) {
                int first = (((g & (1 >> g)) << 2) | ((h + g) ^ h)) == 1 ? 1 : 0;
                int second = (((g % 2) << h) >> g | ((1 & 0) ^ 0)) == 2 ? 2 : 0;

                if (first == 1 && second == 2) {
                    return new int[]{g, h};
                }
            }
        }

        // 조건을 만족하는 g,h가 없으면 예외 처리
        throw new RuntimeException("조건을 만족하는 g, h를 찾을 수 없습니다.");
    }

    public static int calculate(int g, int h) {
        return (h * h + g) * (h << h) + (g << g);
    }
}