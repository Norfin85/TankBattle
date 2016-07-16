package App.Tanks;

/**
 * Created by User on 05.07.2016.
 */
public abstract class Tank {
    private int health, damage, curDislocation, actionPoints,
            timeToReload, timeToTurn, armor;

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

    public void doAction(Tank tank) {
        if (curDislocation != 0) {
            if (actionPoints >= timeToTurn && curDislocation == 1) {
                curDislocation = curDislocation - 1;
                actionPoints = actionPoints + timeToReload - timeToTurn;
                System.out.println(getName() + " развернулся.");
            } else if (actionPoints >= timeToTurn) {
                curDislocation = curDislocation - 1;
                actionPoints -= timeToTurn;
                System.out.println(getName() + " повернул на 90 градусов.");
            }
        } else {
            if (actionPoints >= timeToReload) {
                tank.createDamage(damage);
                actionPoints -= timeToReload;
                System.out.println(getName() + " нанес " + (damage - tank.getArmor()) +
                        " урона. У противника осталось " + tank.getHealth() + " очков жизни.");
            }
        }
    }

    public int getArmor() {
        return armor;
    }

    public abstract String getName();

    public Tank(int health, int damage, int timeToReload, int timeToTurn, int armor) {
        this.health = health;
        this.damage = damage;
        this.timeToReload = timeToReload;
        this.timeToTurn = timeToTurn;
        this.armor = armor;
        curDislocation = 0;
        actionPoints = 0;
    }

    public int getActionPoints() {
        return actionPoints;
    }

    public void setActionPoints(int actionPoints) {
        this.actionPoints += actionPoints;
    }
}
