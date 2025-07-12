package Week3.Problem3;
public class Plant extends Organism {
    private String bloomingSeason;
    private boolean hasFruit;

    public Plant(String name, String species, String habitat, String bloomingSeason, boolean hasFruit) {
        super(name, species, habitat);
        this.bloomingSeason = bloomingSeason;
        this.hasFruit = hasFruit;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("개화 시기: " + bloomingSeason);
        System.out.println("열매 유무: " + (hasFruit ? "있음" : "없음"));
    }

    public String getBloomingSeason() {
        return bloomingSeason;
    }
    public void setBloomingSeason(String bloomingSeason) {
        this.bloomingSeason = bloomingSeason;
    }

    public boolean isHasFruit() {
        return hasFruit;
    }
    public void setHasFruit(boolean hasFruit) {
        this.hasFruit = hasFruit;
    }
}