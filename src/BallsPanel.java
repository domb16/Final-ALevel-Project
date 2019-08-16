import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import UI.CustomPanel;
import javax.swing.*;
import java.util.logging.Logger;

public class BallsPanel extends CustomPanel implements ActionListener, Runnable {

//    private int width, height;
    private static final Logger logger = Logger.getLogger(BallsPanel.class.getName());



    BallsPanel(Container container, int panelWidth, int panelHeight) {
        super(container, panelWidth, panelHeight);

        logger.info(String.format("BallsPanel created with dimensions: %s %s",
                panelWidth, panelHeight));

        initPanel();
        setBackground(Color.cyan);
        container.add(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void run() {
       new Timer(20, this).start();


    }
}
