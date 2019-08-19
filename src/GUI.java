import javax.swing.*;
import java.util.logging.Logger;

import Engine.CollisionDetection;
import UI.MainFrame;

/*
 Make this class build the all the UI elements together, CustomPanel, JFrame etc...

    + Add elements using a factory method for UI methods - e.g. - addElementToUI(type, basic config)
    + Add each element to a method which init the UI class then
      call the init method from the constructor
 */

public class GUI implements Runnable {

    private boolean shouldFill = false;
    private JMenu fileMenu = new JMenu("Menu");
    private JMenuItem file = new JMenuItem("File");
    private JMenuItem exit = new JMenuItem("Exit");
    private BallsPanel bp;
    private static final Logger logger = Logger.getLogger(GUI.class.getName());

    GUI() {
        this.run();
    }

    @Override
    public void run(){
        MainFrame mf = new MainFrame("Simulation Remastered");
        logger.info("UI class thread: "+ Thread.currentThread());
        new BallsPanel(mf,1280,720);
        logger.info("BallsPanel class thread: "+ Thread.currentThread());
        logger.info("Number of threads running right now: "+ Thread.activeCount());
        long test = new CollisionDetection().goodMask << 12L;
        logger.info("test: " + test);
    }
    /*
    private CustomPanel CreateBallPanel() {
        CustomPanel DEPRECATED.ballPanel = new CustomPanel();
        DEPRECATED.ballPanel.setPreferredSize();
        return DEPRECATED.ballPanel;
    }
    */




}
