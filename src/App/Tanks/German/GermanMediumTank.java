package App.Tanks.German;

import App.Tanks.Tank;

/**
 * Created by User on 06.07.2016.
 */
public class GermanMediumTank extends Tank {
    private int armor;
    public GermanMediumTank(){
        super(200, 60, 30., 40.);
        this.armor = 10;
    }
    @Override
    public int getArmor() {
        return armor;
    }

    @Override
    public String getName() {
        return "GERMAN_MEDIUM";
    }
}
