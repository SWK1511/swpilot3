package Week3.Problem3;
import java.util.ArrayList;

public class LifeNest {
    private ArrayList<Organism> organismList;

    public LifeNest() {
        organismList = new ArrayList<>();
    }

    public void addOrganism(Organism organism) {
        organismList.add(organism);
        System.out.println("[추가] " + organism.getName() + "이(가) 저장소에 추가되었습니다.");
    }

    public void removeOrganism(Organism organism) {
        if (organismList.remove(organism)) {
            System.out.println("[삭제] " + organism.getName() + "이(가) 저장소에서 제거되었습니다.");
        } else {
            System.out.println("[오류] 해당 생물이 목록에 없습니다.");
        }
    }

    public void displayAll() {
        System.out.println("\n=== 저장된 모든 생물 정보 ===");
        if (organismList.isEmpty()) {
            System.out.println("저장소가 비어 있습니다.");
        } else {
            for (Organism o : organismList) {
                o.displayInfo();
                System.out.println("--------------------------");
            }
        }
    }
}