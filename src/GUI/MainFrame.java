package GUI;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame(String title) throws HeadlessException {
        super(title);
        initFrame();

    }

    private void initFrame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setPreferredSize(new Dimension(640,480));
        getContentPane().setBackground(Color.ORANGE);
        setResizable(false);
        pack();
        setVisible(true);
    }

    protected void addElementToPane(Component c, Object contraints){
        this.getContentPane().add(c, contraints);
    }

}
