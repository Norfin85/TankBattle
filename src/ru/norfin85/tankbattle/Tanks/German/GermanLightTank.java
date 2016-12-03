package ru.norfin85.tankbattle.Tanks.German;

import ru.norfin85.tankbattle.Tanks.Tank;

/**
 * Created by User on 06.07.2016.
 */
public class GermanLightTank extends Tank {
    private String name;

    public GermanLightTank(int id) {
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
