package App.Tanks;

import App.TankBattle;
import App.Tanks.German.GermanTankFactory;
import App.Tanks.Ussr.UssrTankFactory;

/**
 * Created by User on 06.07.2016.
 */
public class FactoryProducer {

    public enum TankType {USSR, GERMAN}
    TankType choice;
    public static TankFactory getFactory(TankType choice) {
        switch (choice) {
            case USSR:
                return new UssrTankFactory();
            case GERMAN:
                return new GermanTankFactory();
            default:
                throw new IllegalArgumentException("Illegal choice: " + choice);
        }
    }
}
