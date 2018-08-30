import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

import GUI.MainFrame;

public class GUI implements Runnable{

    private boolean shouldFill = false;
    private JMenu fileMenu = new JMenu("Menu");
    private JMenuItem file = new JMenuItem("File");
    private JMenuItem exit = new JMenuItem("Exit");

    //    create a dictionary with some default values for GUI
    public GUI() {
        new MainFrame("Simulation Remastered");
        new BallsPanel();
    }

    private JPanel CreateBallPanel() {
        JPanel ballPanel = new JPanel();
        ballPanel.setPreferredSize();
        return ballPanel;
    }



    @Override
    public void run() {

        new Timer(20, ).start;

    }
}
