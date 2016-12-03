package ru.norfin85.tankbattle.Tanks.German;

import ru.norfin85.tankbattle.Tanks.Tank;

/**
 * Created by User on 06.07.2016.
 */
public class GermanMediumTank extends Tank {
    private String name;

    public GermanMediumTank(int id){
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
