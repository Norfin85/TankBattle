/**
 * Created by User on 06.07.2016.
 */
public class GermanHeavyTank extends Tank {
    private int armor;

    public GermanHeavyTank() {
        super(500, 100, 100., 200.);
        this.armor = 20;
    }
    @Override
    public int getArmor() {
        return armor;
    }

    @Override
    String getName() {
        return "GERMAN_HEAVY";
    }
}
