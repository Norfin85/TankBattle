package ru.norfin85.tankbattle;

import ru.norfin85.tankbattle.Tanks.FactoryProducer;
import ru.norfin85.tankbattle.Tanks.Tank;
import ru.norfin85.tankbattle.Tanks.TankFactory;

import java.util.*;

import static ru.norfin85.tankbattle.Graphics.*;
import static ru.norfin85.tankbattle.Writer.battleActionWriter;
import static ru.norfin85.tankbattle.Writer.dislocationWriter;


/**
 * Created by User on 06.07.2016.
 */
public class TankBattle {
    public static Map<Integer, Tank> ussrTanks;
    public static Map<Integer, Tank> germanTanks;
    public static List<String> battleLog = new ArrayList<>();
    public static int n = -1;

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
        ussrTanks = new TreeMap<>();
        germanTanks = new TreeMap<>();
        TankFactory ussrTankFactory = FactoryProducer.getFactory(FactoryProducer.FactoryType.USSR);
        for (int i = 0; i < 3; i++) {
            Tank tankTemp = ussrTankFactory.createUssrTank(TankFactory.TankType.LIGHT, i);
            tankTemp.setName("Легкий танк СССР " + (i + 1));
            ussrTanks.put(tankTemp.getId(), tankTemp);
        }
        for (int i = 0; i < 2; i++) {
            Tank tankTemp = ussrTankFactory.createUssrTank(TankFactory.TankType.MEDIUM, i + 3);
            tankTemp.setName("Средний танк СССР " + (i + 1));
            ussrTanks.put(tankTemp.getId(), tankTemp);
        }
        for (int i = 0; i < 1; i++) {
            Tank tankTemp = ussrTankFactory.createUssrTank(TankFactory.TankType.HEAVY, i + 5);
            tankTemp.setName("Тяжелый танк СССР");
            ussrTanks.put(tankTemp.getId(), tankTemp);
        }
        TankFactory germanTankFactory = FactoryProducer.getFactory(FactoryProducer.FactoryType.GERMAN);
        for (int i = 0; i < 3; i++) {
            Tank tankTemp = germanTankFactory.createGermanTank(TankFactory.TankType.LIGHT, i + 6);
            tankTemp.setName("Легкий немецкий танк " + (i + 1));
            germanTanks.put(tankTemp.getId(), tankTemp);
        }
        for (int i = 0; i < 2; i++) {
            Tank tankTemp = germanTankFactory.createGermanTank(TankFactory.TankType.MEDIUM, i + 9);
            tankTemp.setName("Средний немецкий танк " + (i + 1));
            germanTanks.put(tankTemp.getId(), tankTemp);
        }
        for (int i = 0; i < 1; i++) {
            Tank tankTemp = germanTankFactory.createGermanTank(TankFactory.TankType.HEAVY, i + 11);
            tankTemp.setName("Тяжелый немецкий танк");
            germanTanks.put(tankTemp.getId(), tankTemp);
        }

        /*while (!ussrTanks.isEmpty() && !germanTanks.isEmpty())
            battleTank(ussrTanks, germanTanks);
        if (!ussrTanks.isEmpty())
            for (Tank tank : ussrTanks) System.out.println(tank.getName());
        else
            System.out.println("Все танки СССР уничтожены!");
        if (!germanTanks.isEmpty())
            for (Tank tank : germanTanks) System.out.println(tank.getName());
        else
            System.out.println("Все танки Германии уничтожены!");*/
    }

    public static String battleTank() {
        //получаем случайную пару танков
        n++;
        int rUssr, rGerman;
        battleLog.add(n, "");
        List<Integer> keysUssr = new ArrayList<>();
        keysUssr.add(0);
        List<Integer> keysGerman = new ArrayList<>();
        keysGerman.add(0);
        Random r = new Random(System.currentTimeMillis());
        if (ussrTanks.size() >= 1) keysUssr = new ArrayList<>(ussrTanks.keySet());
        if (keysUssr.size() >= 2) rUssr = keysUssr.get(r.nextInt(keysUssr.size()));
        else {
            rUssr = keysUssr.get(0);
        }
        keysGerman = new ArrayList<>(germanTanks.keySet());
        if (germanTanks.size() >= 1) keysGerman = new ArrayList<>(germanTanks.keySet());
        if (keysGerman.size() >= 2) rGerman = keysGerman.get(r.nextInt(keysGerman.size()));
        else {
            rGerman = keysGerman.get(0);
        }
        Tank curUssrTank = ussrTanks.get(rUssr);
        Tank curGermanTank = germanTanks.get(rGerman);
        int maxHealthU = 0;
        int maxHealthG = 0;
        if (rUssr < 3) maxHealthU = 100;
        else if (rUssr > 2 && curUssrTank.getId() < 5) maxHealthU = 200;
        else if (rUssr == 5) maxHealthU = 500;
        else if (rGerman < 9) maxHealthG = 100;
        else if (rGerman > 8 && curUssrTank.getId() < 11) maxHealthG = 200;
        else if (rGerman == 11) maxHealthG = 500;
        setHealthes(curUssrTank, curGermanTank);
        setCurrentBattle(curUssrTank, curGermanTank);
        //updateFrame();
        //определяем начальные условия: расположение танков
        //0 - лоб, 1 - бок, 2 - зад
        curUssrTank.setCurDislocation(r.nextInt(3));
        curGermanTank.setCurDislocation(r.nextInt(3));
        if (curUssrTank.getCurDislocation() == 0) curUssrTank.setActionPoints(curUssrTank.getTimeToReload());
        if (curGermanTank.getCurDislocation() == 0) curGermanTank.setActionPoints(curGermanTank.getTimeToReload());
        battleLog.set(n, dislocationWriter(curUssrTank, curGermanTank, battleLog.get(n)));
        //updateBattleList();
        //определяем кто первый стреляет: 0 - СССР, 1 - Германия
        int whoFirst = r.nextInt(2);
        if (whoFirst == 0) {
            while (true) {
                curUssrTank.setActionPoints(10); //даем танку 10 очков дейстия
                if (curUssrTank.getHealth() > 0) { //проверяем жив ли танк
                    battleLog.set(n, curUssrTank.doAction(curGermanTank, battleLog.get(n))); // танк делает ход
                } else {
                    battleLog.set(n, battleLog.get(n) + battleActionWriter(curUssrTank, null, "Унитожение"));
                    //updateBattleList();
                    setTankHealth(rUssr, 0);
                    ussrTanks.remove(rUssr);
                    return battleLog.get(n);
                }
                curGermanTank.setActionPoints(10);
                if (curGermanTank.getHealth() > 0) //проверяем жив ли танк
                    battleLog.set(n, curGermanTank.doAction(curUssrTank, battleLog.get(n))); // танк делает ход
                else {
                    battleLog.set(n, battleLog.get(n) + battleActionWriter(curGermanTank, null, "Унитожение"));
                    //updateBattleList();
                    setTankHealth(rGerman, 0);
                    germanTanks.remove(rGerman);
                    return battleLog.get(n);
                }
            }
        } else {
            while (true) {
                curGermanTank.setActionPoints(10); //даем танку 10 очков дейстия
                if (curGermanTank.getHealth() > 0) { //проверяем жив ли танк
                    //System.out.println(curGermanTank.getActionPoints());
                    battleLog.set(n, curGermanTank.doAction(curUssrTank, battleLog.get(n))); // танк делает ход
                } else {
                    battleLog.set(n, battleLog.get(n) + battleActionWriter(curGermanTank, null, "Унитожение"));
                    //updateBattleList();
                    setTankHealth(rGerman, 0);
                    germanTanks.remove(rGerman);
                    return battleLog.get(n);
                }
                curUssrTank.setActionPoints(10);
                if (curUssrTank.getHealth() > 0) //проверяем жив ли танк
                    battleLog.set(n, curUssrTank.doAction(curUssrTank, battleLog.get(n))); // танк делает ход
                else {
                    battleLog.set(n, battleLog.get(n) + battleActionWriter(curGermanTank, null, "Унитожение"));
                    setTankHealth(rUssr, 0);
                    //updateBattleList();
                    ussrTanks.remove(rUssr);
                    return battleLog.get(n);
                }
            }
        }
    }

    public static int getTanks() {
        int n = 1;
        if (ussrTanks.isEmpty() || germanTanks.isEmpty()) n = 0;
        return n;
    }
}
