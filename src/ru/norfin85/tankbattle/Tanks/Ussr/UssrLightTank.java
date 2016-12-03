package ru.norfin85.tankbattle.Tanks.Ussr;

import ru.norfin85.tankbattle.Tanks.Tank;

/**
 * Created by User on 05.07.2016.
 */
public class UssrLightTank extends Tank {
    private String name;

    public UssrLightTank(int id){
        super(100, 30, 10, 20, 3, id);
    }


    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
