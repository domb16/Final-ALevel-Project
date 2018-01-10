import javax.swing.*;
import java.awt.*;

public class Ball {

    private static int radius= 35; // initial radius of the ball
    private static final int SPEED = 10; // initial speed
    private static double gravity = 9.81; // initial gravity
    private static double xFriction = 0.8; // initial friction that acts on the ball
    private static double energyLoss = 0.65; // initial energyLoss that is applied at each bounce
    private static final double  DT = 0.2; // constant time that the physics engine uses.
    private int x,y,maxX,maxY; // useful variables like coordinates x,y that are used in the move method, and some initialization for the Speeds
    private int speedX = 20, speedY = 0;
    JPanel panel; // creates a new JPanel

    public Ball(JPanel panel,int x,int y, int maxX, int maxY){ // this constructor will be called every single time a new Ball object is created and will require value for each parameter

        this.x = x; this.y = y; this.maxX = maxX ; this.maxY = maxY; // equalises the parameters to the variables in the class this helps with returning values
        this.panel = panel; // same with this equalises the panel to the panel that was created outside the constructor

    }

    /*Getters and Setter
    *
    * The getters consist of returning the value that was collected in some way, just returns the value that was stored inside that variable
    *
    * The setters are a bit more complex and require a parameter to set the new values to, setters overwrite the values in the chosen variables essentially
    *
    * */

    public static void setxFriction(double xFriction) {
        Ball.xFriction = xFriction;
    }

    public static void setEnergyLoss(double energyLoss) {
        Ball.energyLoss = energyLoss;
    }

    public static void setRadius(int radius) {
        Ball.radius = radius;
    }

    public static void setGravity(double gravity) {
        Ball.gravity = gravity;
    }



    public void setBounds(int maxX, int maxY){
        this.maxX = maxX; this.maxY = maxY;

    }

    public void move(){
           // x+= speedX;
           // y+= speedY;
        if (x + speedX > maxX - radius) { // (RIGHT)x changes if it hits a wall, checks where the edge of the Project.ball is. radius*2
            x =  (maxX - radius); // this is one of the simultaneous actions that happen when the ball hits a wall
            speedX *= xFriction;
            speedX = -speedX; // changes direction of the ball so now it moves back the opposite way
        } else if (x + speedX < 0) { // (LEFT) side of the wall
            x = 0; // specifies the x coordinates minimum value
            speedX *=xFriction;
            speedX = -speedX; // the direction also changes once again
        } else

            x += speedX; // if the ball is not hitting a wall then the position of it is moved by the simple rule of x = x+ dx

        if( y > maxY - radius){ // if the ball is at the bottom of the environment

            speedX *= xFriction; // then friction is applied to the speed of the ball

            if(Math.abs(speedX)< .9) { // if the positive value of the speed is less than 0.8
                speedX = x * speedX;
                speedY = 0; // ball stops moving

                y = maxY - radius;
            }
        }
        if(y + radius > maxY ){ // while the ball is in the air and not touching the floor
            y =  (maxY - radius); // y is set a default value
            speedY = -speedY;  // ball bounces back as long as y is more than 0
            speedY *= energyLoss; // the value of the speed of change in the y coord is multiplied by a constant energy loss so overtime itll come to an end

        } else if (y < 0)  { // if y is less than 0 which shouldnt be allowed
            y = 0 ; // y is 0
            speedY *= energyLoss; // the value of the speed of change in the y coord is multiplied by a constant energy loss so overtime itll come to an end
            speedY = -speedY; // direction changes just in case ball might bounce back up
        }else
            //velocity formula
            speedY += gravity;
        //position formula
        y +=  speedY*DT +0.5*gravity*DT*DT; // if neither of them return true dy is updated with the vertical component formula for projectile motion


/*
        x += speedX;
        y += speedY;

        if (x<0) { speedX=-speedX; x=0; }
        if (y<0) { speedY=-speedY; y=0; }
        if (x+RADIUS>maxX) { speedX=-speedX; x=maxX-RADIUS; }
        if (y+RADIUS>maxY) { speedY=-speedY; y=maxY-RADIUS; }
*/
    }

    public void draw(Graphics g){
        Graphics2D g2d = (Graphics2D)g; // converts and encapsulates the value of a Graphics variable into a Graphics2D variable where more methods are available
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // Rendering hints helps the rendering of the painted objects and makes them look smoother
        //g2d.setColor(new Color(Sim.random(255),Sim.random(255),Sim.random(255))); // the colour of the balls change according to RGB at every method call
        g2d.setColor(new Color(Sim.random(255)));
        g2d.fillOval(x,y,radius,radius); // creates an oval given its x,y coordinates and the radius
    }

}
