package ru.norfin85.tankbattle;

import ru.norfin85.tankbattle.Tanks.Tank;

/**
 * Created by User on 02.11.2016.
 */
public class Writer {

    public static String dislocationWriter(Tank ussrTank, Tank germanTank, String battleLog) {
        String dislocation = "0 градусов";
        if (ussrTank.getCurDislocation() == 1) dislocation = "90 градусов";
        else if (ussrTank.getCurDislocation() == 2) dislocation = "180 градусов";
        battleLog += ussrTank.getName() + " расположение - " + dislocation + "\n";
        if (germanTank.getCurDislocation() == 0) dislocation = "0 градусов";
        else if (germanTank.getCurDislocation() == 1) dislocation = "90 градусов";
        else if (germanTank.getCurDislocation() == 2) dislocation = "180 градусов";
        battleLog += germanTank.getName() + " расположение - " + dislocation + "\n";
        return battleLog;
    }

    public static String battleActionWriter(Tank firstTank, Tank secondTank, String action) {
        String battleLog = "";
        if (action.equals("Урон")) {
            battleLog = firstTank.getName() + " нанес " + (firstTank.getDamage() -
                    secondTank.getArmor()) + " урона. У противника осталось " + secondTank.getHealth() +
                    " очков жизни.\n";
        } else if (action.equals("Поворот") && firstTank != null) {
            battleLog = firstTank.getName() + " повернул на 90 градусов.\n";
        } else if (action.equals("Разворот") && firstTank != null) {
            battleLog = firstTank.getName() + " развернулся.\n";
        } else if (action.equals("Уничтожение") && firstTank != null) {
            battleLog = firstTank.getName() + " уничтожен.\n";
        }
        return battleLog;
    }

}
