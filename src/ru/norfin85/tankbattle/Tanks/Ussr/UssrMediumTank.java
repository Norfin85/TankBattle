package ru.norfin85.tankbattle.Tanks.Ussr;

import ru.norfin85.tankbattle.Tanks.Tank;

/**
 * Created by User on 05.07.2016.
 */
public class UssrMediumTank extends Tank {
    private String name;

    public UssrMediumTank(int id) {
        super(200, 60, 30, 40, 10, id);
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
