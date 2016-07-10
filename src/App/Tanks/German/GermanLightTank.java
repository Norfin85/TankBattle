package App.Tanks.German;

import App.Tanks.Tank;

/**
 * Created by User on 06.07.2016.
 */
public class GermanLightTank extends Tank {
    private int armor;
    public GermanLightTank(){
        super(100, 30, 10., 20.);
        this.armor = 3;
    }

    @Override
    public int getArmor() {
        return armor;
    }

    @Override
    public String getName() {
        return "GERMAN_LIGHT";
    }
}
