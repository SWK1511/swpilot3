package Week3.Problem1; // 이 클래스가 속한 패키지를 지정합니다.

// 동물이나 식물과 같은 생명체 정보를 담는 클래스
public class Organism {
    // 생명체의 이름, 종(species), 서식지(habitat)를 저장하는 필드
    private String name;
    private String species;
    private String habitat;

    // 생성자(Constructor)
    // 객체 생성 시 이름, 종, 서식지를 초기화합니다.
    public Organism(String name, String species, String habitat) {
        this.name = name;           // 이름 초기화
        this.species = species;     // 종 초기화
        this.habitat = habitat;     // 서식지 초기화
    }

    // 생명체의 정보를 출력하는 메서드
    public void displayInfo() {
        // "이름, 종, 서식지" 형식으로 출력
        System.out.println(name + ", " + species + ", " + habitat);
    }

    // 이름을 반환하는 getter 메서드 (외부에서 이름을 읽을 수 있게 함)
    public String getName() {
        return name;
    }

    // 서식지를 변경할 수 있는 setter 메서드
    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }
}