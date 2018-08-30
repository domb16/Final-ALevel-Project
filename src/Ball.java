import javax.swing.*;
import java.awt.*;

class Ball {

    private static int radius= 35; 
    private static final int SPEED = 10; 
    private static double gravity = 9.81; 
    private static double xFriction = 0.8; 
    private static double energyLoss = 0.65; 
    private static final double  DT = 0.2; 
    private int x,y,maxX,maxY; 
    private int speedX = 20, speedY = 0;
    JPanel panel; 

    Ball(JPanel panel, int x, int y, int maxX, int maxY){

        this.x = x; this.y = y; this.maxX = maxX ; this.maxY = maxY; 
        this.panel = panel; 

    }

    /*Getters and Setter
    *
    * The getters consist of returning the value that was collected in some way, just returns the value that was stored inside that variable
    *
    * The setters are a bit more complex and require a parameter to set the new values to, setters overwrite the values in the chosen variables essentially
    *
    * */

    static void setxFriction(double xFriction) {
        Ball.xFriction = xFriction;
    }

    static void setEnergyLoss(double energyLoss) {
        Ball.energyLoss = energyLoss;
    }

    static void setRadius(int radius) {
        Ball.radius = radius;
    }

    static void setGravity(double gravity) {
        Ball.gravity = gravity;
    }



    void setBounds(int maxX, int maxY){
        this.maxX = maxX; this.maxY = maxY;

    }

    void move(){
           
           
        if (x + speedX > maxX - radius) { 
            x =  (maxX - radius); 
            speedX *= xFriction;
            speedX = -speedX; 
        } else if (x + speedX < 0) { 
            x = 0; 
            speedX *=xFriction;
            speedX = -speedX; 
        } else

            x += speedX; 

        if( y > maxY - radius){ 

            speedX *= xFriction; 

            if(Math.abs(speedX)< .9) { 
                speedX = x * speedX;
                speedY = 0; 

                y = maxY - radius;
            }
        }
        if(y + radius > maxY ){ 
            y =  (maxY - radius); 
            speedY = -speedY;  
            speedY *= energyLoss; 

        } else if (y < 0)  { 
            y = 0 ; 
            speedY *= energyLoss; 
            speedY = -speedY; 
        }else
            
            speedY += gravity;
        
        y +=  speedY*DT +0.5*gravity*DT*DT; 


/*
        x += speedX;
        y += speedY;

        if (x<0) { speedX=-speedX; x=0; }
        if (y<0) { speedY=-speedY; y=0; }
        if (x+RADIUS>maxX) { speedX=-speedX; x=maxX-RADIUS; }
        if (y+RADIUS>maxY) { speedY=-speedY; y=maxY-RADIUS; }
*/
    }

    void draw(Graphics g){
        Graphics2D g2d = (Graphics2D)g; 
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
        
        g2d.setColor(new Color(Sim.random(255)));
        g2d.fillOval(x,y,radius,radius); 
    }

}
