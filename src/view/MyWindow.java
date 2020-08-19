package view;

import controller.ButtonListener;
import controller.Main;
import controller.MouseEventListener;
import model.Bomb.bigBomb;
import model.Bomb.smallBomb;
import model.GameFigure;
import model.Sounds;
import model.Towers.*;
import model.User;
import javax.swing.*;
import java.awt.*;

public class MyWindow extends JFrame {

    public MyCanvas canvas;
    private JPanel buttonPanel;
    private JPanel menu;
    private JPanel[] purchaseMenu = new JPanel[]{new JPanel(), new JPanel(), new JPanel()};
    private JPanel settingsPanel;
    private JButton startButton;
    private JButton quitButton;
    private JButton newGunTower;
    private JButton newMissileTower;
    private JButton newLaserTower;
    private JButton newFlameTower;
    private JButton newSmallBomb;
    private JButton newBigBomb;
    private JButton nextWave;
    private JButton upgradeButton;
    private JButton cancelButton;
    private JButton sellButton;
    private JPanel upgradePanel;
    private JTextArea textArea;
    private JButton lvl1;
    private JButton lvl2;
    private JButton lvl3;

    public static JRadioButton[] difficulty = new JRadioButton[3];
    private JRadioButton[] endless = new JRadioButton[2];
    private Container cp = getContentPane();

    public void init(){
        setSize(1290,675);
        setLocation(100,100);
        setTitle("Game Engine");
        canvas = new MyCanvas();

        MouseEventListener listener = new MouseEventListener();
        canvas.addMouseListener(listener);
        canvas.addMouseMotionListener(listener);

        canvas.setFocusable(true);
    // Content Pane
        cp.add(BorderLayout.CENTER, canvas);
    // Start button
        startButton = new JButton("Start");
        startButton.setFocusable(false);
        buttonPanel = new JPanel();
        buttonPanel.add(startButton);
    // Quit button
        quitButton = new JButton("Quit");
        quitButton.setFocusable(false);
        buttonPanel.add(quitButton);
    // Cancel Button
        cancelButton = new JButton("Cancel");
        cancelButton.setEnabled(false);
        buttonPanel.add(cancelButton);
    // Text Area
        textArea = new JTextArea();
        buttonPanel.add(textArea);
        cp.add(BorderLayout.SOUTH, buttonPanel);
    // Menu panel
        menu = new JPanel();
        menu.setLayout(new GridLayout(4,1));
    // Settings menu panel
        settingsPanel = new JPanel();
        settingsPanel.setLayout(new GridLayout(8,1));
    // Settings menu buttons
        difficulty[0] = new JRadioButton("Easy");
        difficulty[1] = new JRadioButton("medium");
        difficulty[2] = new JRadioButton("hard");
        endless[0] = new JRadioButton("Endless waves off");
        endless[1] = new JRadioButton("Endless waves On");
        ButtonGroup difficultyGroup = new ButtonGroup();
        for(int i = 0; i < difficulty.length; i++){
            settingsPanel.add(difficulty[i]);
            difficultyGroup.add(difficulty[i]);
        }
        ButtonGroup endlessGroup = new ButtonGroup();
        for(int i = 0; i < endless.length; i++){
            settingsPanel.add(endless[i]);
            endlessGroup.add(endless[i]);
        }
        lvl1 = new JButton("Star Wars");
        lvl1.setFocusable(false);
        lvl2 = new JButton("Halo");
        lvl2.setFocusable(false);
        lvl3 = new JButton("UCO C.S. Dept.");
        lvl3.setFocusable(false);
        settingsPanel.add(lvl1);
        settingsPanel.add(lvl2);
        settingsPanel.add(lvl3);
        cp.add(BorderLayout.WEST,settingsPanel);
        difficulty[0].setSelected(true);
        endless[0].setSelected(true);
    // Button listeners
        ButtonListener BL = new ButtonListener(this);
        startButton.addActionListener((e) -> {
            if(!Main.running){
                int lives = 50 - 10 * selectedDifficulty(), bank = 400 - 50 * selectedDifficulty();
            // Enable/Disable buttons
                startButton.setEnabled(false);
                cancelButton.setEnabled(true);
            // Purchase Menu panel
                purchaseMenu[0].setLayout(new GridLayout(1,2));
                purchaseMenu[1].setLayout(new GridLayout(1,2));
                purchaseMenu[2].setLayout(new GridLayout(1,2));
            // Gun tower button
                newGunTower = new JButton("<html><center>Gun Tower<br>$" + gunTower.PRICE + "</center></html>");
                newGunTower.setFocusable(false);
                purchaseMenu[0].add(newGunTower);
            // Missile tower button
                newMissileTower = new JButton("<html><center>Missile Tower<br>$" + missileTower.PRICE + "</center></html>");
                newMissileTower.setFocusable(false);
                purchaseMenu[0].add(newMissileTower);
            // Laser tower button
                newLaserTower = new JButton("<html><center>Laser Tower<br>$" + laserTower.PRICE + "</center></html>");
                newLaserTower.setFocusable(false);
                purchaseMenu[1].add(newLaserTower);
            // Flame tower button
                newFlameTower = new JButton("<html><center>Flame Tower<br>$" + flameTower.PRICE + "</center></html>");
                newFlameTower.setFocusable(false);
                purchaseMenu[1].add(newFlameTower);
            // Small Bomb button
                newSmallBomb = new JButton("<html><center>Small Bomb<br>$" + smallBomb.PRICE + "</center></html>");
                newSmallBomb.setFocusable(false);
                purchaseMenu[2].add(newSmallBomb);
            // Big Bomb button
                newBigBomb = new JButton("<html><center>Big Bomb<br>$" + bigBomb.PRICE + "</center></html>");
                newBigBomb.setFocusable(false);
                purchaseMenu[2].add(newBigBomb);
            // Next Wave button
                nextWave = new JButton("Next Wave:#" + ButtonListener.getWaveCount());
                nextWave.setFocusable(false);
            // Add buttons to panel
                for(int i = 0; i < purchaseMenu.length;i++){
                    menu.add(purchaseMenu[i]);        }
                menu.add(nextWave);
            // Button Listeners
                newGunTower.addActionListener(BL);
                newMissileTower.addActionListener(BL);
                newLaserTower.addActionListener(BL);
                newFlameTower.addActionListener(BL);
                newSmallBomb.addActionListener(BL);
                newBigBomb.addActionListener(BL);
                nextWave.addActionListener(BL);
            // Initiate user
                Main.user = new User(lives, bank);
                Main.running = true;
                cp.remove(settingsPanel);
                cp.add(BorderLayout.EAST, menu);
                buttonPanel.add(textArea);
                buttonPanel.remove(startButton);
                if (Main.selectedMap == 1) {
                    Sounds.loadSound(Sounds.funBegins);
                    textArea.setText("Now THIS is podracing!");
                }else if (Main.selectedMap == 2) {
                    Sounds.loadSound(Sounds.whatAboutHalo);
                    textArea.setText("I need a weapon...");
                }else {
                    textArea.setText("Don't forget you're homework assignment!");
                }
            }else {
                System.exit(0);
            }
        });
        quitButton.addActionListener(BL);
        cancelButton.addActionListener(BL);
        lvl1.addActionListener(BL);
        lvl2.addActionListener(BL);
        lvl3.addActionListener(BL);
    }
// Return buttons
    public JButton getQuitButton(){return quitButton;}
    public JButton getCancelButton(){return cancelButton;}
    public JButton getlvl1(){return lvl1;}
    public JButton getlvl2(){return lvl2;}
    public JButton getlvl3(){return lvl3;}
    public JButton getNewGunTower(){return newGunTower;}
    public JButton getNewMissileTower(){return newMissileTower;}
    public JButton getNewLaserTower(){return newLaserTower;}
    public JButton getNewFlameTower(){return newFlameTower;}
    public JButton getNewSmallBomb(){return newSmallBomb;}
    public JButton getNewBigBomb(){return newBigBomb;}
    public JButton getNextWave(){return nextWave;}
// Return selected difficulty
    public int selectedDifficulty(){
        if(difficulty[0].isSelected()){ return 0; }
        else if(difficulty[1].isSelected()){ return 1; }
        else{ return 2; }
    }
// Return endless mode selection
    public boolean selectedEndless(){
        if(endless[0].isSelected()){ return false; }
        else{ return true; }
    }

// Tower is selected
    public void displayUpgradeMenu(GameFigure g){
    // initialize upgrade panel
        upgradePanel = new JPanel();
        upgradePanel.setLayout(new GridLayout(2,1));
    // initialize upgrade button
        upgradeButton = new JButton("<html><center>Upgrade cost:<br>$" + g.getUpgrade_price() + "<br>" + g.getUpgradeStat() + "</center></html>");
        upgradeButton.setFocusable(false);
        upgradePanel.add(upgradeButton);
    // initialize sell button
        sellButton = new JButton("<html><center>Sell:<br>$" + g.value/2 + "</center></html>");
        sellButton.setFocusable(false);
        upgradePanel.add(sellButton);
    // Add panel to content pane
        menu.removeAll();
        menu.setLayout(new GridLayout(3,1));
        menu.add(upgradePanel);
        menu.add(purchaseMenu[2]);
        menu.add(nextWave);
    // Button listeners
        upgradeButton.addActionListener((e) -> {
            g.upgrade();
            g.selected = false;
            displayMenu();
        });
        sellButton.addActionListener((e) -> {
            g.done = true;
            g.selected = false;
            Main.user.addMoney(g.value/2);
            displayMenu();
        });
    }

// Tower is unselected
    public void displayMenu(){
        menu.removeAll();
        menu.setLayout(new GridLayout(4,1));
        menu.add(purchaseMenu[0]);
        menu.add(purchaseMenu[1]);
        menu.add(purchaseMenu[2]);
        menu.add(nextWave);
    }

    public void displayTextBox(String s) {
        textArea.setText(s);
    }
}