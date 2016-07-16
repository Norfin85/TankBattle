package App.Tanks.Ussr;

import App.Tanks.Tank;

/**
 * Created by User on 05.07.2016.
 */
public class UssrHeavyTank extends Tank {

    public UssrHeavyTank() {
        super(500, 100, 100, 200, 20);
    }

    @Override
    public String getName() {
        return "USSR_HEAVY";
    }
}
