package App.Tanks;

import App.Tanks.Tank;

/**
 * Created by User on 05.07.2016.
 */
public interface TankFactory {
    enum TankType{LIGHT, MEDIUM, HEAVY}
    Tank createGermanTank(TankType type);
    Tank createUssrTank(TankType type);
}
