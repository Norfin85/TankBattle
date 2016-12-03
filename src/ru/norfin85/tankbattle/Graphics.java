package ru.norfin85.tankbattle;

import ru.norfin85.tankbattle.Tanks.PushingListener;
import ru.norfin85.tankbattle.Tanks.Tank;
import ru.norfin85.tankbattle.Tanks.Ussr.UssrLightTank;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import static ru.norfin85.tankbattle.TankBattle.battleTank;
import static ru.norfin85.tankbattle.TankBattle.germanTanks;

public class Graphics {
    private static final JFrame frame = new JFrame("Tank battle"); //Создаем окно
    private static final JPanel mainPanel = new JPanel(); //Главаная панель-обертка
    private static final JPanel leftPanel = new JPanel(); //левая панель-обертка
    private static final JPanel centerPanel = new JPanel(); //средняя панель-обертка
    private static final JPanel rightPanel = new JPanel(); //правая панель-обертка
    private static JPanel textPanel; //панель-обертка для текста, создаем отступы
    private static final JPanel leftTankPanel = new JPanel(); //создаем танковую панель
    private static final JPanel rightTankPanel = new JPanel();
    private static final JTextPane currentBattle = new JTextPane();
    private static final JTextPane leftHealth = new JTextPane(); //текстовое поле хелсов
    private static final JTextPane rightHealth = new JTextPane(); //текстовое поле хелсов
    private static final JTextPane battleList = new JTextPane();
    private static final JScrollPane jsp = new JScrollPane(battleList);
    private static final Border border = BorderFactory.createLineBorder(Color.BLACK);//создаем рамку
    private static final JButton button = new JButton("Начать бой"); //добавляем кнопку
    //создаем танки
    private static final TreeMap<Integer, JProgressBar> ussrTanksGraphics = new TreeMap<>();
    private static final TreeMap<Integer, JProgressBar> germanTanksGraphics = new TreeMap<>();
    //создаем вспомогательный объекты для стиля текста
    private static StyledDocument doc;
    private static SimpleAttributeSet simpleAttributeSet;

    public static void createAndShowGUI() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //действие при закрытии окна
        frame.pack(); //оптимизируем окно под размеры элементов
        frame.setVisible(true); //делаем окно видимым
        frame.setResizable(false); //Запрещаем изменять размеры окна
        frame.setSize(800, 600); //Устанавливаем размер окна
        //Назначаем менеджер размещения - ящик, размещение компонентов сверху вниз
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        //Назначаем менеджер размещения - ящик, размещение компонентов слева направо
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
        mainPanel.setPreferredSize(new Dimension(800, 500)); //размер панели
        leftPanel.setPreferredSize(new Dimension(200, 500)); //размер панели
        textPanel = new JPanel(); //инициализируем текстовую панель
        textPanel.setPreferredSize(new Dimension(200, 50)); //размер панели
        //Настраиваем стиль и размещение текста внутри текстового поля
        doc = leftHealth.getStyledDocument();
        simpleAttributeSet = new SimpleAttributeSet();
        StyleConstants.setAlignment(simpleAttributeSet, StyleConstants.ALIGN_CENTER);
        StyleConstants.setFontSize(simpleAttributeSet, 18);
        simpleAttributeSet.addAttribute(StyleConstants.CharacterConstants.Foreground, Color.RED);
        doc.setParagraphAttributes(0, doc.getLength(), simpleAttributeSet, false);
        leftHealth.setPreferredSize(new Dimension(100, 30)); //размер поля
        leftHealth.setText("");
        leftHealth.setEditable(false);
        leftHealth.setBorder(border); //добавляем рамку в текстовое поле хелсов
        textPanel.setBorder(new EmptyBorder(10, 50, 10, 50)); //создаем отступы для текстового поля
        textPanel.add(leftHealth); //добавляем в панель текстовое поле
        leftTankPanel.setPreferredSize(new Dimension(200, 450)); //размер панели
        for (int i = 0; i < 6; i++) {
            ussrTanksGraphics.put(i, new JProgressBar());
            if (i < 3) {
                ussrTanksGraphics.get(i).setMinimum(0);
                ussrTanksGraphics.get(i).setMaximum(100);
                ussrTanksGraphics.get(i).setValue(100);
                ussrTanksGraphics.get(i).setString("Легкий танк СССР " + (i + 1));
            } else if (i > 2 && i < 5) {
                ussrTanksGraphics.get(i).setMinimum(0);
                ussrTanksGraphics.get(i).setMaximum(200);
                ussrTanksGraphics.get(i).setValue(200);
                ussrTanksGraphics.get(i).setString("Средний танк СССР " + (i - 2));
            } else if (i > 4) {
                ussrTanksGraphics.get(i).setMinimum(0);
                ussrTanksGraphics.get(i).setMaximum(500);
                ussrTanksGraphics.get(i).setValue(500);
                ussrTanksGraphics.get(i).setString("Тяжелый танк СССР");
            }
            ussrTanksGraphics.get(i).setStringPainted(true);
            ussrTanksGraphics.get(i).setPreferredSize(new Dimension(190, 50));
            germanTanksGraphics.put(i + 6, new JProgressBar());
            if (i < 3) {
                germanTanksGraphics.get(i + 6).setMinimum(0);
                germanTanksGraphics.get(i + 6).setMaximum(100);
                germanTanksGraphics.get(i + 6).setValue(100);
                germanTanksGraphics.get(i + 6).setString("Легкий немецкий танк " + (i + 1));
            } else if (i > 2 && i < 5) {
                germanTanksGraphics.get(i + 6).setMinimum(0);
                germanTanksGraphics.get(i + 6).setMaximum(200);
                germanTanksGraphics.get(i + 6).setValue(200);
                germanTanksGraphics.get(i + 6).setString("Средний немецкий танк " + (i - 2));
            } else if (i > 4) {
                germanTanksGraphics.get(i + 6).setMinimum(0);
                germanTanksGraphics.get(i + 6).setMaximum(500);
                germanTanksGraphics.get(i + 6).setValue(500);
                germanTanksGraphics.get(i + 6).setString("Тяжелый немецкий танк");
            }
            germanTanksGraphics.get(i + 6).setStringPainted(true);
            germanTanksGraphics.get(i + 6).setPreferredSize(new Dimension(190, 50));
        }
        for (Map.Entry<Integer, JProgressBar> entry : ussrTanksGraphics.entrySet())
            leftTankPanel.add(entry.getValue());
        leftPanel.add(textPanel); //добавляем в левую панель текстовую панель
        leftPanel.add(leftTankPanel); //добавляем в левую панель танковую панель
        centerPanel.setPreferredSize(new Dimension(400, 500));
        centerPanel.setBorder(new EmptyBorder(5, 5, 5, 5)); //размер панели
        textPanel = new JPanel(); //переопределяем панель
        textPanel.setPreferredSize(new Dimension(390, 70)); //размер панели
        //переопределяем стиль документа и настраиваем стиль и размещение текста внутри текстового поля
        doc = currentBattle.getStyledDocument();
        simpleAttributeSet = new SimpleAttributeSet();
        StyleConstants.setAlignment(simpleAttributeSet, StyleConstants.ALIGN_CENTER);
        StyleConstants.setFontSize(simpleAttributeSet, 18);
        StyleConstants.setFontFamily(simpleAttributeSet, "Comic Sans MS");
        simpleAttributeSet.addAttribute(StyleConstants.CharacterConstants.Foreground, new Color(0, 105, 33));
        doc.setParagraphAttributes(0, doc.getLength(), simpleAttributeSet, false);
        currentBattle.setText("");
        currentBattle.setEditable(false);
        currentBattle.setPreferredSize(new Dimension(380, 60)); //размер панели
        currentBattle.setBorder(border); //создаем рамку
        textPanel.setBorder(new EmptyBorder(5, 5, 5, 5)); //создаем отступы
        textPanel.add(currentBattle); //добавляем в левую панель текстовую панель
        centerPanel.add(textPanel); //добавляем в центральную панель текстовую панель
        textPanel = new JPanel(); //переопределяем панель
        textPanel.setPreferredSize(new Dimension(390, 430)); //размер панели
        //переопределяем стиль документа и настраиваем стиль и размещение текста внутри текстового поля
        doc = battleList.getStyledDocument();
        simpleAttributeSet = new SimpleAttributeSet();
        StyleConstants.setAlignment(simpleAttributeSet, StyleConstants.ALIGN_LEFT);
        StyleConstants.setFontSize(simpleAttributeSet, 12);
        StyleConstants.setFontFamily(simpleAttributeSet, "Times New Roman, cursive");
        simpleAttributeSet.addAttribute(StyleConstants.CharacterConstants.Foreground, new Color(112, 126, 173));
        doc.setParagraphAttributes(0, doc.getLength(), simpleAttributeSet, false);
        battleList.setText("");
        battleList.setEditable(false);
        battleList.setPreferredSize(new Dimension(370, 420)); //размер панели
        battleList.setBorder(border); //создаем рамку
        textPanel.setBorder(new EmptyBorder(5, 5, 5, 5)); //создаем отступы
        jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jsp.setPreferredSize(new Dimension(380, 420));
        textPanel.add(jsp); //добавляем в текстовую панель текстовое поле
        centerPanel.add(textPanel); //добавляем в центральную панель текстовую панель
        rightPanel.setPreferredSize(new Dimension(200, 500)); //размер панели
        textPanel = new JPanel(); //переопределяем текстовую панель
        textPanel.setPreferredSize(new Dimension(200, 50)); //размер панели
        //переопределяем стиль документа и настраиваем стиль и размещение текста внутри текстового поля
        doc = rightHealth.getStyledDocument();
        simpleAttributeSet = new SimpleAttributeSet();
        StyleConstants.setAlignment(simpleAttributeSet, StyleConstants.ALIGN_CENTER);
        StyleConstants.setFontSize(simpleAttributeSet, 18);
        simpleAttributeSet.addAttribute(StyleConstants.CharacterConstants.Foreground, Color.RED);
        doc.setParagraphAttributes(0, doc.getLength(), simpleAttributeSet, false);
        rightHealth.setPreferredSize(new Dimension(100, 30)); //размер поля
        rightHealth.setText("");
        rightHealth.setEditable(false);
        rightHealth.setBorder(border); //создаем рамку
        textPanel.setBorder(new EmptyBorder(10, 50, 10, 50)); //создаем отступы
        textPanel.add(rightHealth); //добавляем в текстовую панель текстовое поле
        rightTankPanel.setPreferredSize(new Dimension(200, 450));  //размер панели
        for (Map.Entry<Integer, JProgressBar> entry : germanTanksGraphics.entrySet())
            rightTankPanel.add(entry.getValue());
        rightPanel.add(textPanel); //добавляем в правую панель текстовую панель
        rightPanel.add(rightTankPanel); //добавляем в правую панель танковую панель
        mainPanel.add(leftPanel); //добавляем в главную панель левую панель
        mainPanel.add(centerPanel); //добавляем в главную панель центральную панель
        mainPanel.add(rightPanel); //добавляем в главную панель правую панель
        button.setPreferredSize(new Dimension(100, 50)); //размер кнопки
        button.addActionListener(new PushingListener());
        button.setAlignmentX(Component.CENTER_ALIGNMENT); //центральное размещение
        button.addActionListener(new PushingListener());
        frame.add(mainPanel); //добавляем в окно главную панель
        frame.add(button); //добавление в окно кнопку
    }

    public static void setButton(String text, Boolean setActive) {
        button.setText(text);
        button.setEnabled(setActive);
        button.repaint();
    }

    public static void setHealthes(Tank ussrTank, Tank germanTank) {
        leftHealth.setText(Integer.toString(ussrTank.getHealth()));
        leftHealth.repaint();
        rightHealth.setText(Integer.toString(germanTank.getHealth()));
        rightHealth.repaint();
    }

    public static void setCurrentBattle(Tank ussrTank, Tank germanTank) {
        currentBattle.setText("Начался бой между " + ussrTank.getName() +
                " и " + germanTank.getName());
        currentBattle.repaint();
    }

    public static void printDislocation(Tank ussrTank, Tank germanTank) {
        String dislocation = "0 градусов";
        if (ussrTank.getCurDislocation() == 1) dislocation = "90 градусов";
        else if (ussrTank.getCurDislocation() == 2) dislocation = "180 градусов";
        battleList.setText(ussrTank.getName() + " расположение - " + dislocation + "\n");
        if (germanTank.getCurDislocation() == 0) dislocation = "0 градусов";
        else if (germanTank.getCurDislocation() == 1) dislocation = "90 градусов";
        else if (germanTank.getCurDislocation() == 2) dislocation = "180 градусов";
        battleList.setText(germanTank.getName() + " расположение - " + dislocation + "\n");
        battleList.repaint();
    }

    public static void printBattleAction(Tank firstTank, Tank secondTank, String action) {
        if (action.equals("Урон")) {
            battleList.setText(battleList.getText() + firstTank.getName() + " нанес " +
                    (firstTank.getDamage() - secondTank.getArmor()) + " урона. У противника осталось " +
                    secondTank.getHealth() + " очков жизни.\n");
        } else if (action.equals("Поворот") && firstTank != null) {
            battleList.setText(battleList.getText() +
                    firstTank.getName() + " повернул на 90 градусов.\n");
        } else if (action.equals("Разворот") && firstTank != null) {
            battleList.setText(battleList.getText() +
                    firstTank.getName() + " развернулся.\n");
        } else if (action.equals("Уничтожение") && firstTank != null) {
            battleList.setText(battleList.getText() +
                    firstTank.getName() + " уничтожен.\n");
        }
        battleList.repaint();
    }

    public static void updateFrame() {
        frame.update(frame.getGraphics());
    }

    public static void updateBattleList() {
        centerPanel.update(centerPanel.getGraphics());
    }

    public static void startBattle() {
        battleList.setText(battleTank());
        battleList.repaint();
        setButton("Продолжить бой", true);
        //frame.update(frame.getGraphics());
    }

    public static void setTankHealth(int id, int percent) {
        if (id < 6) ussrTanksGraphics.get(id).setValue(percent);
        if (id > 5) germanTanksGraphics.get(id).setValue(percent);
    }
}
