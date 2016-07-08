/**
 * Created by User on 05.07.2016.
 */
public class UssrLightTank extends Tank {
    private int armor;
    public UssrLightTank(){
        super(100, 30, 10., 20.);
        this.armor = 3;
    }

    @Override
    public int getArmor() {
        return armor;
    }

    @Override
    String getName() {
        return "USSR_LIGHT";
    }
}
