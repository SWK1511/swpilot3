package Week3.Problem1;

import java.util.ArrayList;

// 동식물 목록을 관리하는 클래스
public class LifeNest {
    // Organism 객체들을 저장하는 리스트
    private ArrayList<Organism> organismList = new ArrayList<>();

    // 동식물을 리스트에 추가하는 메서드
    public void addOrganism(Organism o) {
        organismList.add(o); // 리스트에 객체 추가
        System.out.println("[LifeNest] " + o.getName() + "이(가) 추가되었습니다.");
    }

    // 동식물을 이름으로 찾아서 삭제하는 메서드
    public void removeOrganism(String name) {
        // 리스트에서 조건에 맞는 요소를 제거
        organismList.removeIf(o -> {
            // 이름이 일치하는 객체를 찾으면 삭제
            if (o.getName().equals(name)) {
                System.out.println("[LifeNest] " + name + "이(가) 삭제되었습니다.");
                return true; // 삭제할 대상임을 표시
            }
            return false; // 조건에 맞지 않으면 유지
        });
    }

    // 전체 동식물 정보를 출력하는 메서드
    public void printAllOrganisms() {
        System.out.println("전체 동식물 목록 출력:");
        // 리스트에 있는 모든 Organism 객체의 정보를 출력
        for (Organism o : organismList) {
            o.displayInfo(); // Organism 클래스의 정보 출력 메서드 호출
        }
    }

    // 주어진 이름으로 동식물을 검색하는 메서드 (보너스 기능)
    public Organism searchOrganismByName(String name) {
        // 리스트를 순회하며 이름이 일치하는 Organism을 찾음
        for (Organism o : organismList) {
            if (o.getName().equals(name)) return o; // 찾은 경우 해당 객체 반환
        }
        return null; // 못 찾은 경우 null 반환
    }
}