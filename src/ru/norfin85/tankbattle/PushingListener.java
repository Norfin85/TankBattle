package ru.norfin85.tankbattle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static ru.norfin85.tankbattle.Graphics.showLog;
import static ru.norfin85.tankbattle.Graphics.startBattle;
import static ru.norfin85.tankbattle.Graphics.updateFrame;
import static ru.norfin85.tankbattle.TankBattle.getTanks;

/**
 * Created by User on 01.09.2016.
 */
public class PushingListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Начать бой")) {
            startBattle();
            Graphics.setButton("Продолжить бой", true);
        }
        if (e.getActionCommand().equals("Продолжить бой")) {
            startBattle();
        }
        if (e.getActionCommand().equals("Лог боя")) showLog();
    }
}
