package Week1;

public class HelloBiodome02 {
    public static void main(String[] args) {

        // 입력 인자 수가 정확히 3개가 아닐 경우
        if (args.length != 3) {
            System.out.println("태양광, 풍력, 지열을 숫자만 순서대로 입력.");
            return;
        }

        int solar = 0;   // 태양광
        int wind = 0;    // 풍력
        int geo = 0;     // 지열

        try {
            // 문자열 → 정수형으로 변환 (형변환 사용)
            solar = Integer.parseInt(args[0]);
            wind = Integer.parseInt(args[1]);
            geo = Integer.parseInt(args[2]);

            // 음수 값 체크
            if (solar < 0 || wind < 0 || geo < 0) {
                System.out.println("에너지 생산량은 음수가 될 수 없습니다.");
                return;
            }

            // 최대값 제한 (30,000)
            if (solar > 30000 || wind > 30000 || geo > 30000) {
                System.out.println("각 에너지 생산량은 30,000을 초과할 수 없습니다.");
                return;
            }

        } catch (NumberFormatException e) {
            // 숫자가 아닌 값을 입력했을 때 예외 처리
            System.out.println("에너지 생산량은 숫자로 입력해야 합니다.");
            return;
        }

        // 총합 계산 (자동 형변환 발생)
        int total = solar + wind + geo;
        System.out.println("총 에너지 사용량은 " + total + "입니다.");

        // 보너스: 비율 계산 및 출력
        double solarRate = (double) solar / total * 100;
        double windRate = (double) wind / total * 100;
        double geoRate = (double) geo / total * 100;

        System.out.printf("태양광 %.9f%%, 풍력 %.9f%%, 지열 %.9f%%%n", solarRate, windRate, geoRate);
    }
}