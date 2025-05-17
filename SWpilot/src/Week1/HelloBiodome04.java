package Week1;

public class HelloBiodome04 {
    public static void main(String[] args) {
        // 1. 입력값 개수 검증
        /* 커맨드 라인 인자 3개 입력 확인 */
        if (args.length != 3) {
            System.out.println("입력된 값이 올바르지 않습니다. [온도][습도][산소농도] 순서대로 숫자 값을 입력해주세요");
            return;
        }

        double temperature, humidity, oxygen;
        try {
            // 2. 숫자 형식 변환
            /* 문자열을 double 타입으로 변환 (NumberFormatException 가능성) */
            temperature = Double.parseDouble(args[0]);
            humidity = Double.parseDouble(args[1]);
            oxygen = Double.parseDouble(args[2]);
        } catch (NumberFormatException e) {
            // 3. 숫자 변환 실패 처리
            /* 문자 포함 등 유효하지 않은 입력 시 예외 처리 */
            System.out.println("입력된 값이 올바르지 않습니다. [온도][습도][산소농도] 순서대로 숫자 값을 입력해주세요");
            return;
        }

        // 4. 유효 범위 검증 메서드 호출
        /* 개별 환경값 검증 (온도 ≥10 && <27.5, 습도 >40 && <60, 산소 ≥19.5 && ≤23.5) */
        boolean tempValid = isTemperatureValid(temperature);
        boolean humidityValid = isHumidityValid(humidity);
        boolean oxygenValid = isOxygenValid(oxygen);

        // 5. 검증 결과 처리
        /* 단 하나의 요소만 범위 이탈 가능하다는 문제 조건 반영 */
        if (!tempValid) {
            System.out.println("온도값이 정상 범위를 벗어났습니다. 확인이 필요합니다.");
        } else if (!humidityValid) {
            System.out.println("습도값이 정상 범위를 벗어났습니다. 확인이 필요합니다.");
        } else if (!oxygenValid) {
            System.out.println("산소 농도값이 정상 범위를 벗어났습니다. 확인이 필요합니다.");
        } else {
            // 6. 건강 지수 계산 (보너스 과제)
            /* H = (온도 × 산소) / 습도 → 소수점 셋째 자리 반올림 */
            double hValue = (temperature * oxygen) / humidity;
            hValue = (double) Math.round(hValue * 100) / 100.0;  // 소수점 둘째 자리까지 표현
            System.out.printf("생명의 나무는 안정적인 상태입니다 :) 건강지수는 %.2f입니다.%n", hValue);
        }
    }

    // 7. 온도 검증 메서드
    /* 10°C 이상 27.5°C 미만 범위 체크 */
    private static boolean isTemperatureValid(double temp) {
        return temp >= 10.0 && temp < 27.5;
    }

    // 8. 습도 검증 메서드
    /* 40% 초과 60% 미만 범위 체크 */
    private static boolean isHumidityValid(double humidity) {
        return humidity > 40.0 && humidity < 60.0;
    }

    // 9. 산소 농도 검증 메서드
    /* 19.5% 이상 23.5% 이하 범위 체크 */
    private static boolean isOxygenValid(double oxygen) {
        return oxygen >= 19.5 && oxygen <= 23.5;
    }
}