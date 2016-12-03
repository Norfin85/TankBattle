package ru.norfin85.tankbattle.Tanks;

/**
 * Created by User on 05.07.2016.
 */
public interface TankFactory {
    enum TankType{LIGHT, MEDIUM, HEAVY}
    Tank createGermanTank(TankType type, int id);
    Tank createUssrTank(TankType type, int id);
}
