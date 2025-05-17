package Week1;

public class HelloBiodome06 {
    public static void main(String[] args) {

        // 1. 입력값이 두 개인지 확인
        if (args.length != 2) {
            // 두 개가 아니라면 안내 메시지 출력 후 종료
            System.out.println("두 개의 유전자 코드를 입력해주세요.");
            return; // 프로그램 종료
        }

        // 2. 입력된 유전자 코드 두 개를 문자열로 저장
        String gene1 = args[0];
        String gene2 = args[1];

        if (!isValidGene(gene1) || !isValidGene(gene2)) {
            System.out.println("유전자 코드는 5~20자의 소문자와 숫자로 구성되어야 합니다.");
            return;
        }

        boolean isEqual = true; // 기본값: 같다고 가정
        int index = 0; // 문자열 비교에 사용할 인덱스 변수

        // 두 문자열 길이가 다르면 바로 false 처리
        if (gene1.length() != gene2.length()) {
            isEqual = false;
        } else {
            // while 반복문으로 문자 하나씩 비교
            while (index < gene1.length()) {
                // 하나라도 다르면 isEqual = false
                if (gene1.charAt(index) != gene2.charAt(index)) {
                    isEqual = false;
                    break; // 더 이상 비교할 필요 없음
                }
                index++; // 다음 문자로 이동
            }
        }
        // 3. 비교 결과 출력
        if (isEqual) {
            System.out.println("동일한 유전자 코드입니다.");
        } else {
            System.out.println("일치하지 않습니다.");
        }
    }

    public static boolean isValidGene(String gene) {
        // 길이가 5 이상 20 이하인지 확인
        if (gene.length() < 5 || gene.length() > 20) {
            return false;
        }
        // 한글자씩 문자 확인
        int i = 0;
        while (i < gene.length()) {
            char c = gene.charAt(i);
            if (!(Character.isLowerCase(c) || Character.isDigit(c))) {
                return false; // 조건에 맞지 않으면 false
            }
            i++; // 다음 문자로 이동
        }
        return true; // 모든 문자가 조건에 맞으면 true
    }
}