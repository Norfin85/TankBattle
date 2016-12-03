package ru.norfin85.tankbattle.Tanks.German;

import ru.norfin85.tankbattle.Tanks.Tank;
import ru.norfin85.tankbattle.Tanks.TankFactory;

/**
 * Created by User on 05.07.2016.
 */
public class GermanTankFactory implements TankFactory {
    @Override
    public Tank createGermanTank(TankType type, int id) {
        Tank germanTank = null;
        switch (type) {
            case LIGHT:
                germanTank = new GermanLightTank(id);
                break;

            case MEDIUM:
                germanTank = new GermanMediumTank(id);
                break;

            case HEAVY:
                germanTank = new GermanHeavyTank(id);
                break;

            default:
                //если тип неверный бросаем исключение
                throw new IllegalArgumentException("Illegal type of tank: "
                        + type);
        }
        return germanTank;
    }

    @Override
    public Tank createUssrTank(TankType type, int ID) {
        return null;
    }
}