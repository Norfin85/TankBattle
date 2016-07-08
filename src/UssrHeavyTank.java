/**
 * Created by User on 05.07.2016.
 */
public class UssrHeavyTank extends Tank {
    private int armor;

    public UssrHeavyTank() {
        super(500, 100, 100., 200.);
        this.armor = 20;
    }
    @Override
    public int getArmor() {
        return armor;
    }

    @Override
    String getName() {
        return "USSR_HEAVY";
    }
}
