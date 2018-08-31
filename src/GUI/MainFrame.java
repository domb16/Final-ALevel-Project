package GUI;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private Color frameColor;
    private int frameWidth, frameHeight;

    public MainFrame(String title) throws HeadlessException {
        super(title);
        initFrame();

    }

    private void initFrame(){
        frameInit();
        setJFrameSize(frameWidth, frameHeight);
        setFrameBG(frameColor);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        setVisible(true);
    }

    public void addElementToPane(Component c, Object contraints){
        this.getContentPane().add(c, contraints);
    }


    private void setJFrameSize(int width, int height){
        this.frameWidth = width;
        this.frameHeight = height;
        width = 1280;
        height = 720;
        getContentPane().setPreferredSize(new Dimension(width, height));
    }

    private void setFrameBG(Color color){
        this.frameColor = color;
        color = Color.ORANGE;
        getContentPane().setBackground(color);
    }

}
