package App;

import App.Tanks.FactoryProducer;
import App.Tanks.Tank;
import App.Tanks.TankFactory;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by User on 06.07.2016.
 */
public class TankBattle {
    public static void main(String[] args){
        ArrayList<Tank> ussrTanks = new ArrayList<Tank>();
        ArrayList<Tank> germanTanks = new ArrayList<Tank>();
        TankFactory ussrTankFactory = FactoryProducer.getFactory("USSR");
        ussrTanks.add(ussrTankFactory.createUssrTank("LIGHT"));
        ussrTanks.add(ussrTankFactory.createUssrTank("MEDIUM"));
        ussrTanks.add(ussrTankFactory.createUssrTank("HEAVY"));

        TankFactory germanTankFactory = FactoryProducer.getFactory("GERMAN");
        germanTanks.add(germanTankFactory.createGermanTank("LIGHT"));
        germanTanks.add(germanTankFactory.createGermanTank("MEDIUM"));
        germanTanks.add(germanTankFactory.createGermanTank("HEAVY"));
        battleTank(ussrTanks, germanTanks);
        for(Tank tank : ussrTanks) System.out.println(tank);
        for(Tank tank : germanTanks) System.out.println(tank);

    }

    public static void battleTank(ArrayList<Tank> ussrTanks, ArrayList<Tank> germanTanks)
    {
        //получаем случайную пару танков
        Random r = new Random(System.currentTimeMillis());
        int rUssr = r.nextInt(2);
        int rGerman = r.nextInt(2);
        Tank curUssrTank = ussrTanks.get(rUssr);
        Tank curGermanTank = germanTanks.get(rGerman);
        System.out.println("Начался бой между " + curUssrTank.getName() + " и " + curGermanTank.getName());
        //определяем начальные условия: расположение танков
        //0 - лоб, 1 - бок, 2 - зад
        int curUssrTankDislocation = r.nextInt(2);
        int curGermanTankDislocation = r.nextInt(2);
        // определяем запас времени танка и кто первым стреляет
        double numTacts = curUssrTankDislocation * curUssrTank.getTimeToTurn() -
                curGermanTankDislocation * curGermanTank.getTimeToTurn();
            //если танк СССР быстрее развернулся то он успевает нанести бонусные выстрелы
            if (numTacts < 0){
                curGermanTank.createDamage((int)(-numTacts/curUssrTank.getTimeToReload() + 1)
                        * (curUssrTank.getDamage() - curGermanTank.getArmor()));
                while (true) {
                    curUssrTank.createDamage(curGermanTank.getDamage() - curUssrTank.getArmor());
                    if (curUssrTank.getHealth() < 0){
                        ussrTanks.remove(rUssr);
                        System.out.println(curUssrTank.getName() + " - уничтожен");
                        break;
                    }
                    curGermanTank.createDamage(curUssrTank.getDamage() - curGermanTank.getArmor());
                    if (curGermanTank.getHealth() < 0) {
                        germanTanks.remove(rGerman);
                        System.out.println(curGermanTank.getName() + " - уничтожен");
                        break;
                    }
                }
            }
            //и наоборот
            else if(numTacts > 0){
                curUssrTank.createDamage((int)(numTacts/curGermanTank.getTimeToReload() + 1) *
                        (curGermanTank.getDamage() - curUssrTank.getArmor()));
                while (true) {
                    curGermanTank.createDamage(curUssrTank.getDamage() - curGermanTank.getArmor());
                    if (curGermanTank.getHealth() < 0) {
                        germanTanks.remove(rGerman);
                        System.out.println(curGermanTank.getName() + " - уничтожен");
                        break;
                    }
                    curUssrTank.createDamage(curGermanTank.getDamage() - curUssrTank.getArmor());
                    if (curUssrTank.getHealth() < 0) {
                        ussrTanks.remove(rUssr);
                        System.out.println(curUssrTank.getName() + " - уничтожен");
                        break;
                    }
                }
            }
            else if(numTacts == 0){
                if (r.nextInt(1) == 0) {
                    while (true) {
                        curGermanTank.createDamage(curUssrTank.getDamage() - curGermanTank.getArmor());
                        if (curGermanTank.getHealth() < 0) {
                            germanTanks.remove(rGerman);
                            System.out.println(curGermanTank.getName() + " - уничтожен");
                            break;
                        }
                        curUssrTank.createDamage(curGermanTank.getDamage() - curUssrTank.getArmor());
                        if (curUssrTank.getHealth() < 0) {
                            ussrTanks.remove(rUssr);
                            System.out.println(curUssrTank.getName() + " - уничтожен");
                            break;
                        }
                    }
                }
                else {
                    while (true) {
                        curUssrTank.createDamage(curGermanTank.getDamage() - curUssrTank.getArmor());
                        if (curUssrTank.getHealth() < 0){
                            ussrTanks.remove(rUssr);
                            System.out.println(curUssrTank.getName() + " - уничтожен");
                            break;
                        }
                        curGermanTank.createDamage(curUssrTank.getDamage() - curGermanTank.getArmor());
                        if (curGermanTank.getHealth() < 0) {
                            germanTanks.remove(rGerman);
                            System.out.println(curGermanTank.getName() + " - уничтожен");
                            break;
                        }
                    }
                }
            }
    }
}
