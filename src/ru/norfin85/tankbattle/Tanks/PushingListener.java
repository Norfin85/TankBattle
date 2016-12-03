package ru.norfin85.tankbattle.Tanks;
import ru.norfin85.tankbattle.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static ru.norfin85.tankbattle.Graphics.startBattle;
import static ru.norfin85.tankbattle.TankBattle.battleTank;

/**
 * Created by User on 01.09.2016.
 */
public class PushingListener implements ActionListener{
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Начать бой")){
            Graphics.setButton("Продолжить бой", false);
            startBattle();
        }
    }
}
