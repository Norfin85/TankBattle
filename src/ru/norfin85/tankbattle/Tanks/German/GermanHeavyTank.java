package ru.norfin85.tankbattle.Tanks.German;

import ru.norfin85.tankbattle.Tanks.Tank;

/**
 * Created by User on 06.07.2016.
 */
public class GermanHeavyTank extends Tank {


    private String name;

    public GermanHeavyTank(int id) {
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
