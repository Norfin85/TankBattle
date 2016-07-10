package App.Tanks;

import App.Tanks.German.GermanTankFactory;
import App.Tanks.Ussr.UssrTankFactory;

/**
 * Created by User on 06.07.2016.
 */
public class FactoryProducer {
    public static TankFactory getFactory(String choice){

        if(choice.equalsIgnoreCase("USSR")){
            return new UssrTankFactory();

        }else if(choice.equalsIgnoreCase("GERMAN")){
            return new GermanTankFactory();
            //бросаем исключение если ничего не подошло
        } else {
            throw new IllegalArgumentException("Illegal choice: " + choice);
        }
    }
}
