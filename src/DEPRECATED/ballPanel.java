package DEPRECATED;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 *  DEPRECATED
 *
 *
 *
 */

public class ballPanel extends JPanel implements ActionListener {
                                                                 
                                                                

    ArrayList<Ball> balls = new ArrayList<Ball>();
    ArrayList<Speed> ballSpeed = new ArrayList<Speed>();
    Random rnd = new Random(); 

    public void actionPerformed(ActionEvent e){ 
        for(Ball ball : balls){
            ball.move(); 
        }
        repaint(); 
    }

    ballPanel(){
        super(); 
        setPreferredSize(new Dimension(640,480)); 
        setBorder(new BevelBorder(BevelBorder.RAISED)); 
        setBackground(new Color(Sim.random(255),Sim.random(255),Sim.random(255))); 

        addComponentListener(new ComponentAdapter() { 

            @Override
            public void componentResized(ComponentEvent componentEvent) { 
                if(ballPanel.this == componentEvent.getComponent()){
                    for(Ball ball : balls){
                        ball.setBounds(getWidth(),getHeight()); 
                    }
                }
            }
        });
    }

    public void paintComponent(Graphics g){ 
        super.paintComponent(g); 
        g.drawRect(0,0, 640,480); 


        for(Ball ball : balls){
            ball.draw(g); 
        }
    }

    void addBall(){
         balls.add(new Ball(this,rnd.nextInt(640),rnd.nextInt(240),640,480)); /*creates a new ball with the given parameters where the ball can be spawned
                                                                                                         anywhere in the X axis but only at the top half of the JPanel*/

    }

    void remBall(){

       for(Ball ball : balls){
           balls.remove(ball);
       }


    }


}
