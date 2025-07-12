package Week3.Problem3;
public class Animal extends Organism {
    private String digestionType;
    private String food;

    public Animal(String name, String species, String habitat, String digestionType, String food) {
        super(name, species, habitat);
        this.digestionType = digestionType;
        this.food = food;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("소화 방식: " + digestionType);
        System.out.println("먹이: " + food);
    }

    public String getDigestionType() {
        return digestionType;
    }
    public void setDigestionType(String digestionType) {
        this.digestionType = digestionType;
    }

    public String getFood() {
        return food;
    }
    public void setFood(String food) {
        this.food = food;
    }
}