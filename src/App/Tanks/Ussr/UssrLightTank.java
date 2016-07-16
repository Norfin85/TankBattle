package App.Tanks.Ussr;

import App.Tanks.Tank;

/**
 * Created by User on 05.07.2016.
 */
public class UssrLightTank extends Tank {
    public UssrLightTank(){
        super(100, 30, 10, 20, 3);
    }


    @Override
    public String getName() {
        return "USSR_LIGHT";
    }
}
