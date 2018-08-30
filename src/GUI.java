import javax.swing.*;
import java.util.logging.Logger;

import GUI.MainFrame;

/*
 Make this class build the all the GUI elements together, JPanel, JFrame etc...

    + Add elements using a factory method for UI methods - e.g. - addElementToUI(type, basic config)
    + Add each element to a method which init the GUI class then
      call the init method from the constructor
 */

public class GUI implements Runnable {

    private boolean shouldFill = false;
    private JMenu fileMenu = new JMenu("Menu");
    private JMenuItem file = new JMenuItem("File");
    private JMenuItem exit = new JMenuItem("Exit");
    private BallsPanel bp;
    private static final Logger logger = Logger.getLogger(GUI.class.getName());

    //    create a dictionary with some default values for GUI
    public GUI() {
        /*

            + Set up the MainFrame
            + Set up the BallsPanel
         */
        new MainFrame("Simulation Remastered");
        bp = new BallsPanel();
        logger.info("Current thread: "+ Thread.currentThread());

    }

    @Override
    public void run(){

        new Timer(20, bp).start();


    }
    /*
    private JPanel CreateBallPanel() {
        JPanel DEPRECATED.ballPanel = new JPanel();
        DEPRECATED.ballPanel.setPreferredSize();
        return DEPRECATED.ballPanel;
    }
    */




}
