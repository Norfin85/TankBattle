package ru.norfin85.tankbattle.Tanks.Ussr;

import ru.norfin85.tankbattle.Tanks.Tank;
import ru.norfin85.tankbattle.Tanks.TankFactory;

/**
 * Created by User on 05.07.2016.
 */
public class UssrTankFactory implements TankFactory {
    @Override
    public Tank createGermanTank(TankType type, int id) {
        return null;
    }

    public Tank createUssrTank(TankType type, int id) {
        {
            Tank ussrTank = null;
            switch (type) {
                case LIGHT:
                    ussrTank = new UssrLightTank(id);
                    break;

                case MEDIUM:
                    ussrTank = new UssrMediumTank(id);
                    break;

                case HEAVY:
                    ussrTank = new UssrHeavyTank(id);
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
