package ru.norfin85.tankbattle.Tanks;

import static ru.norfin85.tankbattle.Writer.battleActionWriter;

/**
 * Created by User on 05.07.2016.
 */
public abstract class Tank {
    private int health, damage, curDislocation, actionPoints,
            timeToReload, timeToTurn, armor, id;

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

    public int getTimeToReload() {
        return timeToReload;
    }

    public int getTimeToTurn() {
        return timeToTurn;
    }

    public void createDamage(int damage) {
        health = health - damage + getArmor();
    }

    public void setCurDislocation(int curDislocation) {
        this.curDislocation = curDislocation;
    }

    public int getCurDislocation() {
        return curDislocation;
    }

    public String doAction(Tank tank, String battleLog) {
        if (curDislocation != 0) {
            if (actionPoints >= timeToTurn && curDislocation == 1) {
                curDislocation = curDislocation - 1;
                actionPoints = actionPoints + timeToReload - timeToTurn;
                battleLog += battleActionWriter (this, null, "Разворот");
            } else if (actionPoints >= timeToTurn) {
                curDislocation = curDislocation - 1;
                actionPoints -= timeToTurn;
                battleLog += battleActionWriter (this, null, "Поворот");
            }
        } else {
            if (actionPoints >= timeToReload) {
                tank.createDamage(damage);
                actionPoints -= timeToReload;
                battleLog += battleActionWriter (this, tank, "Урон");
            }
        }
        return battleLog;
    }

    public int getArmor() {
        return armor;
    }

    public Tank(int health, int damage, int timeToReload, int timeToTurn, int armor, int id) {
        this.health = health;
        this.damage = damage;
        this.timeToReload = timeToReload;
        this.timeToTurn = timeToTurn;
        this.armor = armor;
        this.id = id;
        curDislocation = 0;
        actionPoints = 0;
    }

    public int getActionPoints() {
        return actionPoints;
    }

    public void setActionPoints(int actionPoints) {
        this.actionPoints += actionPoints;
    }

    public abstract void setName(String name);

    public abstract String getName();

    public int getId() {
        return id;
    }
}
