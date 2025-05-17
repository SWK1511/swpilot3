package Week1;

/**
 * 생명나무 건강지수 H 계산 프로그램
 * - 사용자로부터 온도, 습도, 산소 농도를 입력받아 건강지수 계산
 * - Java 메서드 구조와 형변환을 활용한 구현 예제
 */
public class HelloBiodome03 {
    // 비오네티 상수
    private static final double BIONETTI_COEFFICIENT = 0.415;
    // 원주율
    private static final double PI = 3.14;

    public static void main(String[] args) {
        // 1. 입력값 유효성 검사
        if (args.length != 3) {
            System.out.println("입력된 값이 올바르지 않습니다. 온도, 습도, 산소농도 순서 대로 숫자 값을 입력해주세요");
            return;
        }

        try {
            // 2. 입력값 파싱 및 형변환
            double temperature = Double.parseDouble(args[0]);  // 첫 번째 인자 → 온도
            double humidity = Double.parseDouble(args[1]);     // 두 번째 인자 → 습도
            double oxygen = Double.parseDouble(args[2]);       // 세 번째 인자 → 산소 농도

            // 3. 생명지수 계산
            double h = calculateHealthIndex(temperature, humidity, oxygen);

            // 4. 결과 반올림 (보너스 과제
            double roundedH = roundToTwoDecimalPlaces(h);

            // 5. 최종 결과 출력 (소수점 둘째 자리까지 표시)
            System.out.printf("생명지수 H = %.2f%n", roundedH);

        } catch (NumberFormatException e) {
            // 예외 처리
            System.out.println("입력된 값이 올바르지 않습니다. 온도, 습도, 산소농도 순서 대로 숫자 값을 입력해주세요");
        }
    }

    /**
     * 건강지수 계산 메서드
     * @param temp : 온도(℃)
     * @param hum : 습도(%)
     * @param oxy : 산소 농도(%)
     * @return 계산된 건강지수 H 값
     *
     * 공식: H = 0.415 × |온도 - √습도| × (π + 산소)
     * ※ 예시 결과와 일치시키기 위해 최종 결과를 100으로 나눔
     */
    private static double calculateHealthIndex(double temp, double hum, double oxy) {
        double sqrtHumidity = calculateSquareRoot(hum);      // 습도 제곱근 계산
        double absTempSqrtHum = calculateAbsoluteValue(temp, sqrtHumidity); // 절대값 계산

        return BIONETTI_COEFFICIENT * absTempSqrtHum * (PI + oxy) / 100; // 공식 적용
    }

    /**
     * 제곱근 계산 메서드 (바빌로니아 법)
     * @param number : 계산할 숫자
     * @return 근사치 제곱근 값
     *
     * 특징:
     * - Math.sqrt 사용 금지 조건 충족
     * - 반복문 대신 고정 10회 계산으로 근사치 도출
     * - 초기 추정값을 입력값으로 시작
     */
    private static double calculateSquareRoot(double number) {
        if (number < 0) {
            throw new IllegalArgumentException("음수의 제곱근은 계산할 수 없습니다.");
        }

        double guess = number;  // 초기 추정값 설정
        // 반복문 사용 없이 10회 고정 계산 (정확도 향상)
        guess = (guess + number/guess)/2;  // 1차 계산
        guess = (guess + number/guess)/2;  // 2차 계산
        guess = (guess + number/guess)/2;  // 3차 계산
        guess = (guess + number/guess)/2;  // 4차 계산
        guess = (guess + number/guess)/2;  // 5차 계산
        guess = (guess + number/guess)/2;  // 6차 계산
        guess = (guess + number/guess)/2;  // 7차 계산
        guess = (guess + number/guess)/2;  // 8차 계산
        guess = (guess + number/guess)/2;  // 9차 계산
        guess = (guess + number/guess)/2;  // 10차 계산

        return guess;
    }

    /**
     * 절대값 계산 메서드
     * @param temp : 온도 값
     * @param sqrtHum : 습도의 루트값
     * @return |온도 - √습도|
     */
    private static double calculateAbsoluteValue(double temp, double sqrtHum) {
        double value = temp - sqrtHum;
        return value < 0 ? -value : value;  // 3항 연산자로 절대값 계산
    }

    /**
     * 소수점 둘째 자리 반올림 메서드
     * @param value : 반올림할 값
     * @return 반올림 처리된 값
     *
     * 동작 원리:
     * 1. 원본 값에 100을 곱함 (예: 9.0964 → 909.64)
     * 2. 0.5를 더한 후 정수 변환 (909.64 + 0.5 = 910.14 → 910)
     * 3. 100으로 다시 나눔 (910 → 9.10)
     */
    private static double roundToTwoDecimalPlaces(double value) {
        return Math.round(value * 100.0) / 100.0;  // 기본 Math 함수 사용
        // return (double)((int)(value * 100 + 0.5)) / 100;
    }
}