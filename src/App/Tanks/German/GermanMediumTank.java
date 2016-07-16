package App.Tanks.German;

import App.Tanks.Tank;

/**
 * Created by User on 06.07.2016.
 */
public class GermanMediumTank extends Tank {
    public GermanMediumTank(){
        super(200, 60, 30, 40, 10);
    }

    @Override
    public String getName() {
        return "GERMAN_MEDIUM";
    }
}
