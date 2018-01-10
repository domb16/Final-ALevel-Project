import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.Random;

public class ballPanel extends JPanel implements ActionListener { // defines the class and extends the JPanel so it can use the JPanels
                                                                 // preset methods and implements an ActionListener for the Timer to function
                                                                // whatever is inside this class' actionPerformed it is called every millisecond as long as the timer is running

    ArrayList<Ball> balls = new ArrayList<Ball>(); // creates an unlimited sized arrayList for every Ball object
    Random rnd = new Random(); // creates a new random object called rnd

    public void actionPerformed(ActionEvent e){ // an action event data type is needed as a parameter for any new actionListener
        for(Ball ball : balls){ // an advanced for loop is created to loop through every Ball type object which we initialized as "balls" earlier
            ball.move(); // the move method is started for every Ball object
        }
        repaint(); // the repaint method is a method for the JPanel which basically when called will update the JPanel every method call.
    }

    public ballPanel(){ // the constructor is created for the class
        super(); // the class is made super so it can be accessed from another class
        setPreferredSize(new Dimension(640,480)); // the JPanel's size is defined
        setBorder(new BevelBorder(BevelBorder.RAISED)); // creates a border to identify the JPanel and make it easier to see during runtime, the border is Raised so it looks like it is raised
        setBackground(new Color(Sim.random(255),Sim.random(255),Sim.random(255))); // set the colour of the background to be grey.
        /*This component listener is useless in my case but it is still a nice addition to the code just in case I decide to set the JFrame to be resizable
         * I decided to keep this keep in here anyway as a way to show my progress from where it started from */
        addComponentListener(new ComponentAdapter() { // adds a componentListener to the JPanel and creates a new ComponentAdapter where automatically generated code blocks appear

            @Override
            public void componentResized(ComponentEvent componentEvent) { // this code block helps to deal with the component Adapter
                if(ballPanel.this == componentEvent.getComponent()){ // selection statement to say that if the component is the JPanel/Frame
                    for(Ball ball : balls){ // loop through every ball in the arrayList
                        ball.setBounds(getWidth(),getHeight()); // set the limit at which the ball can bounce at to the components new Width and Height
                    }
                }
            }
        });
    }

    public void paintComponent(Graphics g){ // Paint component with the Graphics parameters, this method is in charge of dealing with whatever is painted on the JPanel at runtime
        super.paintComponent(g); // supersize the method so it can be accessed from other classes
        g.drawRect(0,0, 640,480); // this line will create the "ball container" which the balls will be drawn in.


        for(Ball ball : balls){ // loop through all the balls in the arrayList once again
            ball.draw(g); // paint every ball onto the JPanel that is contained inside the arrayList
        }
    }

    public void addBall(){
         balls.add(new Ball(this,rnd.nextInt(640),rnd.nextInt(240),640,480)); /*creates a new ball with the given parameters where the ball can be spawned
                                                                                                         anywhere in the X axis but only at the top half of the JPanel*/

    }

    public void remBall(){

       for(Ball ball : balls){
           balls.remove(ball);
       }


    }


}
