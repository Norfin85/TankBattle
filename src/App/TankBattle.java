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
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Tank> ussrTanks = new ArrayList<Tank>();
        ArrayList<Tank> germanTanks = new ArrayList<Tank>();
        TankFactory ussrTankFactory = FactoryProducer.getFactory(FactoryProducer.FactoryType.USSR);
        for (int i = 0; i < 5; i++)
            ussrTanks.add(ussrTankFactory.createUssrTank(TankFactory.TankType.LIGHT));
        for (int i = 0; i < 3; i++)
            ussrTanks.add(ussrTankFactory.createUssrTank(TankFactory.TankType.MEDIUM));
        for (int i = 0; i < 1; i++)
            ussrTanks.add(ussrTankFactory.createUssrTank(TankFactory.TankType.HEAVY));

        TankFactory germanTankFactory = FactoryProducer.getFactory(FactoryProducer.FactoryType.GERMAN);
        for (int i = 0; i < 5; i++)
            germanTanks.add(germanTankFactory.createGermanTank(TankFactory.TankType.LIGHT));
        for (int i = 0; i < 3; i++)
            germanTanks.add(germanTankFactory.createGermanTank(TankFactory.TankType.MEDIUM));
        for (int i = 0; i < 1; i++)
            germanTanks.add(germanTankFactory.createGermanTank(TankFactory.TankType.HEAVY));
        while (!ussrTanks.isEmpty() && !germanTanks.isEmpty())
            battleTank(ussrTanks, germanTanks);
        if (!ussrTanks.isEmpty())
            for (Tank tank : ussrTanks) System.out.println(tank);
        else
            System.out.println("Все танки СССР уничтожены!");
        if (!germanTanks.isEmpty())
            for (Tank tank : germanTanks) System.out.println(tank);
        else
            System.out.println("Все танки Германии уничтожены!");
    }

    public static void battleTank(ArrayList<Tank> ussrTanks, ArrayList<Tank> germanTanks) throws InterruptedException {
        //получаем случайную пару танков
        int rUssr = 0, rGerman = 0;
        Random r = new Random(System.currentTimeMillis());
        if (ussrTanks.size() >= 2) rUssr = r.nextInt(ussrTanks.size() - 1);
        if (germanTanks.size() >= 2) rGerman = r.nextInt(germanTanks.size() - 1);
        Tank curUssrTank = ussrTanks.get(rUssr);
        Tank curGermanTank = germanTanks.get(rGerman);
        System.out.println("Начался бой между " + curUssrTank.getName() + " и " + curGermanTank.getName());
        //определяем начальные условия: расположение танков
        //0 - лоб, 1 - бок, 2 - зад
        curUssrTank.setCurDislocation(r.nextInt(2));
        curGermanTank.setCurDislocation(r.nextInt(2));
        if (curUssrTank.getCurDislocation() == 0) curUssrTank.setActionPoints(curUssrTank.getTimeToReload());
        if (curGermanTank.getCurDislocation() == 0) curGermanTank.setActionPoints(curGermanTank.getTimeToReload());
        System.out.println(curUssrTank.getName() + " расположение - " + curUssrTank.getCurDislocation());
        System.out.println(curGermanTank.getName() + " расположение - " + curGermanTank.getCurDislocation());
        //определяем кто первый стреляет: 0 - СССР, 1 - Германия
        int whoFirst = r.nextInt(1);
        if (whoFirst == 0) {
            while (true) {
                curUssrTank.setActionPoints(10); //даем танку 10 очков дейстия
                if (curUssrTank.getHealth() > 0) { //проверяем жив ли танк
                    //System.out.println(curUssrTank.getActionPoints());
                    curUssrTank.doAction(curGermanTank); // танк делает ход
                } else {
                    System.out.println(curUssrTank.getName()+" уничтожен.");
                    ussrTanks.remove(rUssr);
                    break;
                }
                Thread.sleep(1000); // пауза 0,1 секунда
                curGermanTank.setActionPoints(10);
                if (curGermanTank.getHealth() > 0) //проверяем жив ли танк
                    curGermanTank.doAction(curUssrTank); // танк делает ход
                else {
                    System.out.println(curGermanTank.getName()+" уничтожен.");
                    germanTanks.remove(rGerman);
                    break;
                }
            }
        } else {
            while (true) {
                curGermanTank.setActionPoints(10); //даем танку 10 очков дейстия
                if (curGermanTank.getHealth() > 0) { //проверяем жив ли танк
                    System.out.println(curGermanTank.getActionPoints());
                    curGermanTank.doAction(curUssrTank); // танк делает ход
                } else {
                    System.out.println(curGermanTank.getName()+" уничтожен.");
                    germanTanks.remove(rGerman);
                    break;
                }
                Thread.sleep(1000); // пауза 1 секунда
                curUssrTank.setActionPoints(10);
                if (curUssrTank.getHealth() > 0) //проверяем жив ли танк
                    curUssrTank.doAction(curUssrTank); // танк делает ход
                else {
                    System.out.println(curUssrTank.getName()+" уничтожен.");
                    ussrTanks.remove(rUssr);
                    break;
                }
            }
        }
    }
}