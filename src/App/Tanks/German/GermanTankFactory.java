package App.Tanks.German;

import App.Tanks.Tank;
import App.Tanks.TankFactory;

/**
 * Created by User on 05.07.2016.
 */
public class GermanTankFactory implements TankFactory {
    @Override
    public Tank createGermanTank(String typeTank) {
        Tank germanTank = null;
        switch (typeTank)
        {
            case "LIGHT":
                germanTank = new GermanLightTank();
                break;

            case "MEDIUM":
                germanTank = new GermanMediumTank();
                break;

            case "HEAVY":
                germanTank = new GermanHeavyTank();
                break;

            default:
                //если тип неверный бросаем исключение
                throw new IllegalArgumentException("Illegal type of tank: "
                        + typeTank);
        }
        return germanTank;
    }

    @Override
    public Tank createUssrTank(String typeTank) {
        return null;
    }
}
