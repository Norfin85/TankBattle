package App.Tanks.German;

import App.Tanks.Tank;
import App.Tanks.TankFactory;

/**
 * Created by User on 05.07.2016.
 */
public class GermanTankFactory implements TankFactory {
    @Override
    public Tank createGermanTank(TankType type) {
        Tank germanTank = null;
        switch (type) {
            case LIGHT:
                germanTank = new GermanLightTank();
                break;

            case MEDIUM:
                germanTank = new GermanMediumTank();
                break;

            case HEAVY:
                germanTank = new GermanHeavyTank();
                break;

            default:
                //если тип неверный бросаем исключение
                throw new IllegalArgumentException("Illegal type of tank: "
                        + type);
        }
        return germanTank;
    }

    @Override
    public Tank createUssrTank(TankType type) {
        return null;
    }
}