시간의 복잡도 보고서

작성자
JAVA 1팀 김시원

I.시간 복잡도의 정의와 필요성
-	정의
     시간복잡도(Time Complexity)는 알고리즘이 실행되는데 걸리는 시간의 입력 크기 사이의 관계를 수학적으로 표현한 것.

프로그램이 처리해야 할 입력이 크면 클수록 얼마나 더 많은 연산을 수행해야 하는지 예측할 수 있는 지표.

일반적으로 시간 복잡도는 빅오 표기법(Big O Notation)을 사용하여 표현함.

-	필요성
1.	성능 예측
-	입력이 커질수록 프로그램이 얼마나 느려지는지 미리 예측 가능.
     Ex) O(n) 알고리즘은 입력이 10배 커지면 연산도 10배, O(n^2)알고리즘은 입력이 10배 커지면 연산은 100배 커진다.

2.	알고리즘 비교
-	여러 알고리즘 중에서 가장 효율적인 방법을 선택할 수 있음.
-	같은 기능을 하더라도 시간 복잡도에 따라 성능차이가 크게 날 수 있음.
3.	병목 지점 파악
-	어떤 코드 부분이 전체 속도를 느리게 만드는지 찾아냄.
-	최적화가 필요한 위치를 판단할 수 있음.
4.	확장성 확보
-	알고리즘이 대량 데이터를 처리할 수 있을지, 서비스 수준 유지가 가능한지 결정할 수 있음.
5.	이론적 확장성
-	코드 실행 시간은 환경(컴퓨터 사양, 언어, 인터프리터)에 따라 달라질 수 있지만, 시간복잡도는 알고리즘 자체의 근본적인 효율성을 나타냄.

-	정리
     시간 복잡도는 알고리즘의 효율성을 수학적으로 표현하는 방법으로, 프로그램의 성능 예측과 최적화에 필수적인 개념.

II.

Big O 표기법의 개념과 상황별 예시.

O(1) - 상수시간. 항상 일정하다.
int[] arr = {1, 2, 3};
System.out.println(arr[0]); // 항상 1회 실행

O(log n) - 이진 탐색. 천천히 증가한다.

int binarySearch(int[] arr, int target) {
int left = 0, right = arr.length - 1;
while (left <= right) {
int mid = (left + right) / 2;
if (arr[mid] == target) return mid;
else if (arr[mid] < target) left = mid + 1;
else right = mid - 1;
}
return -1;
}

O(n) - 선형 탐색. 선형적으로 증가한다.

for (int i = 0; i < arr.length; i++) {
if (arr[i] == target) {
return i;
}
}

O(N^2) - 버블정렬. 급격히 증가한다.
for (int i = 0; i < arr.length; i++) {
for (int j = 0; j < arr.length - i - 1; j++) {
if (arr[j] > arr[j + 1]) {
// swap
}
}
}

O(2^n) 피보나치(재귀) 지수적으로 폭증한다. (천천히 증가한다)

int fib(int n) {
if (n <= 1) return n;
return fib(n - 1) + fib(n - 2);
}

III. 문제01의 시간복잡도 분석.

1. for(string arg:args)
입력값을 모두 정수로 파싱하며 검증 -> O(n)
n은 args.length

2. int[]counts = newint[1001];
배열 선언 -> O(1) 고정적인 크기.

3. for (int num: numbers) {counts[num]++;}
입력 리스트 순회하며 각 숫자의 빈도를 기록 -> O(n)

4. for(int num: numbers) {if (counts[num] ==1 ...)}
리스트를 순회하여 중복되지 않은 숫자를 찾음 O(n)
총 시간 복잡도 : O(n)

IV. 문제 02코드의 시간복잡도 분석 

if (input.length() < 2 || input.length() > 1_000_000) { ... }
if (input.trim().isEmpty()) { ... }

input.length() -> O(1)
input.trim() -> O(n) (n은 입력 문자열의 길이)

for (int i = 0; i < n / 2; i++) {
if (s.charAt(i) != s.charAt(n - 1 - i)) return false;
}
최대 n/2번 문자 비교 ->O(n)

for (char c : input.toCharArray()) {
push(stack, c); // 내부적으로 ArrayList.add → O(1) amortized
}

총 n번 -> O(n)

for (int i = 0; i < reversed.length; i++) {
reversed[i] = pop(stack); // ArrayList.remove(size - 1) → O(1) amortized
}
총 n번 -> O(n)

System.out.println(new String(reversed));

new String(char[]) -> O(n)

따라서 전체 시간 복잡도는 O(n) 입니다.


V. 병목 현상 분석 및 최적화 방안.

RoadToBiodome01 : 

List<interger> numbers = new ArrayList<>();

숫자를 한번 저장했다가 다시 세는데 사용된다. 이중 순회 필요
공간은 O(n), 시간은 중복 탐색으로 인해 2n 순회

for (int num : numbers) {
counts[num]++;
}
for (int num : numbers) {
if (counts[num] == 1) {
System.out.println(num);
return;
}
}

첫번째 루프: 각 숫자의 등장 횟수 기록 -> O(n)
두번째 루프: 처음 등장한 중복되지 않은 수 출력 -> O(n)
총 O(2n) ≈ **O(n)**이지만, 불필요하게 리스트를 두 번 순회

최적화 방안 

개선1: 입력 단계에서 바로 처리.

입력을 받으면서 동시에 첫 중복 없는 값을 결정할 수 있도록 변경 가능.

하지만 순서를 유지하면서 중복 여부 확인이 필요하므로 LinkedHashMap<Interger, Interger>을 사용할 수 있음. (순서+빈도 유지)

개선2: 리스트 제거+ 순서 유지 가능한 Map 사용
Map<Integer, Integer> counts = new LinkedHashMap<>();

for (String arg : args) {
try {
int num = Integer.parseInt(arg);
if (num < 0 || num > 1000) {
System.out.println("입력된 값의 범위가 올바르지 않습니다. 0에서 1000까지의 값을 입력해주세요.");
return;
}
counts.put(num, counts.getOrDefault(num, 0) + 1);
} catch (NumberFormatException e) {
System.out.println("입력된 값의 범위가 올바르지 않습니다. 0에서 1000까지의 값을 입력해주세요.");
return;
}
}

// LinkedHashMap은 입력 순서 유지
for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
if (entry.getValue() == 1) {
System.out.println(entry.getKey());
return;
}
}

결론
시간복잡도는 O(n)으로 동일하지만, 공간 절약과 루프 중복 제거 측면에서 제거 가능.

LinkedHashMap을 활용하면 순서를 유지하면서 중복 체크도 한번에 해결 가능.
입력 검증과 처리 흐름도 더 깔끔해짐.


RoadToBiodome02 : 

ArrayList 기반 스택 구조를 ArrayDeque로 최적화하여 push와 pop 연산을 더 빠르게 처리하도록 수정 가능. 
스택연산은 안정적인 O(1) 시간 복잡도로 수행됨. 

