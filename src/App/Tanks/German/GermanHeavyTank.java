package App.Tanks.German;

import App.Tanks.Tank;

/**
 * Created by User on 06.07.2016.
 */
public class GermanHeavyTank extends Tank {

    public GermanHeavyTank() {
        super(500, 100, 100, 200, 20);
    }

    @Override
    public String getName() {
        return "GERMAN_HEAVY";
    }
}
