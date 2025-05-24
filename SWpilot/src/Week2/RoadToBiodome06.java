/*
 * RoadToBiodome06
 * --------------------------
 * 프로그램 목적:
 * - 두 개의 오름차순 정렬된 물 높이 배열을 입력받아 평균값과 중앙값을 계산한다.
 * - 평균값과 중앙값은 소수점 첫째 자리까지 반올림하여 출력한다.
 * - 잘못된 입력값이 있을 경우 사용자에게 안내 메시지를 출력한다.
 *
 * 기능 요구사항:
 * - Command Line Arguments로 두 배열 입력
 * - 평균값 계산: 전체 합계를 구한 후 / 전체 개수
 * - 중앙값 계산: 병합하지 않고 O(log(m+n)) 시간 복잡도로 구현
 * - 평균과 중앙값은 반올림하여 소수점 첫째 자리까지 출력
 * - 보너스: 30 이상인 값들만 대상으로 평균/중앙값 계산
 */
package Week2;
public class RoadToBiodome06 {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("두 개의 배열을 입력해야 합니다.");
            return;
        }
        try {
            int[] array1 = parseInput(args[0]);
            int[] array2 = parseInput(args[1]);

            // 배열 길이 확인
            int n = array1.length;
            int m = array2.length;

            // 이후 로직...
        } catch (IllegalArgumentException e) {
            System.out.println("입력 형식이 올바르지 않습니다: " + e.getMessage());
            return;
        }

        // TODO: args[0], args[1]을 각각 정수 배열로 파싱

        // TODO: 각 배열의 크기를 n, m으로 저장
        // TODO: 잘못된 입력값(음수, 숫자가 아닌 값 등) 처리

        // TODO: 평균 계산 메서드 호출 (모든 값 or 조건 만족 값만)
        // TODO: 중앙값 계산 메서드 호출 (정렬하지 않고 O(log(m+n))에 맞게)

        // TODO: 소수점 첫째 자리까지 반올림하여 출력
    }

    // 입력 문자열을 정수 배열로 변환하는 메서드
    private static int[] parseInput(String input) {
        // TODO: "[1,2,3]" 같은 형식에서 숫자만 추출하여 배열로 반환
        return null;
    }

    // 평균값을 계산하는 메서드 (조건: 전체 또는 30 이상만 포함)
    private static double calculateMean(int[] a, int[] b, boolean filterOver30) {
        // TODO: 두 배열을 순회하며 합과 개수를 계산
        return 0;
    }

    // 중앙값을 O(log(m+n))에 계산하는 메서드
    private static double findMedianSortedArrays(int[] a, int[] b) {
        // TODO: 두 정렬된 배열에서 중앙값을 찾는 이진 탐색 기반 알고리즘
        return 0;
    }

    // 중앙값을 30 이상에 대해서만 구하고 싶은 경우
    private static double findMedianFiltered(int[] a, int[] b) {
        // TODO: 두 배열에서 30 이상 값만 추출 후 중앙값 계산
        return 0;
    }
}
