package App.Tanks.German;

import App.Tanks.Tank;

/**
 * Created by User on 06.07.2016.
 */
public class GermanLightTank extends Tank {
    public GermanLightTank(){
        super(100, 30, 10, 20, 3);
    }

    @Override
    public String getName() {
        return "GERMAN_LIGHT";
    }
}
