package Week3.Problem1; // 이 파일이 포함된 패키지를 정의합니다. 파일 경로와 일치해야 합니다.

public class BiodomeFamily01 {
    public static void main(String[] args) {
        // 동식물을 관리할 LifeNest 객체 생성
        LifeNest nest = new LifeNest();

        // 동물과 식물 객체 생성
        Organism penguin = new Organism("펭귄", "동물", "남극");
        Organism koala = new Organism("코알라", "동물", "호주");
        Organism cactus = new Organism("선인장", "식물", "사막");
        Organism peppermint = new Organism("페퍼민트", "식물", "정원");
        Organism cat = new Organism("고양이", "동물", "모든 곳");

        // 생성한 객체들을 LifeNest에 추가
        nest.addOrganism(penguin);
        nest.addOrganism(koala);
        nest.addOrganism(cactus);
        nest.addOrganism(peppermint);
        nest.addOrganism(cat);

        // 현재 저장된 전체 동식물 목록 출력
        nest.printAllOrganisms();

        // 특정 이름의 동물과 식물 객체를 삭제
        nest.removeOrganism("코알라");
        nest.removeOrganism("선인장");

        // 펭귄 객체의 서식지를 "해변"으로 변경
        penguin.setHabitat("해변");

        // 변경 및 삭제 후, 전체 동식물 목록 다시 출력
        nest.printAllOrganisms();

        // 보너스 기능: 이름으로 동식물 검색
        // 보너스 기능: 이름으로 동식물 검색
// 보너스 기능: 이름으로 동식물 검색
        if (args.length == 0) {
            System.out.println("검색할 동식물 이름을 인자로 입력하세요.");
            return;
        }
        Organism found = nest.searchOrganismByName(args[0]);
        if (found == null) {
            System.out.println(args[0] + "을(를) 찾을 수 없습니다.");
        } else {
            System.out.println("찾은 동식물 정보:");
            found.displayInfo();
        }
    }
}