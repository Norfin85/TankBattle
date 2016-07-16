package App.Tanks.Ussr;

import App.Tanks.Tank;
import App.Tanks.TankFactory;

/**
 * Created by User on 05.07.2016.
 */
public class UssrTankFactory implements TankFactory {
    @Override
    public Tank createGermanTank(TankType type) {
        return null;
    }

    public Tank createUssrTank(TankType type) {
        {
            Tank ussrTank = null;
            switch (type) {
                case LIGHT:
                    ussrTank = new UssrLightTank();
                    break;

                case MEDIUM:
                    ussrTank = new UssrMediumTank();
                    break;

                case HEAVY:
                    ussrTank = new UssrHeavyTank();
                    break;

                default:
                    throw new IllegalArgumentException("Illegal type of tank: "
                            + type);
                    //throw some exception
            }
            return ussrTank;
        }
    }
}
