package Week3.Problem3;
public class BiodomeFamily03 {
    public static void main(String[] args) {
        LifeNest lifeNest = new LifeNest();

        // 동물 객체 2개
        Animal lion = new Animal("사자", "포유류", "사바나", "육식", "고기");
        Animal rabbit = new Animal("토끼", "포유류", "숲", "초식", "풀");

        // 식물 객체 2개
        Plant rose = new Plant("장미", "관목", "정원", "봄", true);
        Plant pine = new Plant("소나무", "침엽수", "산", "봄", false);

        // 추가
        lifeNest.addOrganism(lion);
        lifeNest.addOrganism(rabbit);
        lifeNest.addOrganism(rose);
        lifeNest.addOrganism(pine);

        // 전체 출력
        lifeNest.displayAll();

        // 삭제
        lifeNest.removeOrganism(rabbit);
        lifeNest.removeOrganism(rose);

        // 다시 출력
        lifeNest.displayAll();
    }
}