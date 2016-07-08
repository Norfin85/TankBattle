/**
 * Created by User on 05.07.2016.
 */
public abstract class Tank {
    private int health, damage, dislocation, actionPoints;
    private double timeToReload, timeToTurn;

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

    public double getTimeToReload() {
        return timeToReload;
    }

    public double getTimeToTurn() {
        return timeToTurn;
    }

    public void createDamage(int damage) {
        health = health - damage;
    }

    abstract int getArmor();

    abstract String getName();

    public Tank(int health, int damage, double timeToReload, double timeToTurn) {
        this.health = health;
        this.damage = damage;
        this.timeToReload = timeToReload;
        this.timeToTurn = timeToTurn;
    }
}
