package ru.norfin85.tankbattle.Tanks.Ussr;

import ru.norfin85.tankbattle.Tanks.Tank;

/**
 * Created by User on 05.07.2016.
 */
public class UssrHeavyTank extends Tank {

    private String name;

    public UssrHeavyTank(int id) {
        super(500, 100, 100, 200, 20, id);
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
