

import java.awt.*;
import java.awt.event.*;
import java.util.Hashtable;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class Sim extends JFrame { // extends the JFrame to access all of the methods that the JFrame offers without having to create a separate one

    static final int DELAY = 20; // constant delay for the timer that is used when it is initialised
    static ballPanel ballContainer = new ballPanel(); // a new ball panel object is created from the ballPanel class
    private boolean shouldFill = true;
    private JMenu fileMenu = new JMenu("Menu");
    private JMenuItem file = new JMenuItem("File");
    private JMenuItem exit = new JMenuItem("Exit");

    JSlider gravitySlider = new JSlider(JSlider.HORIZONTAL,-10,10,0); // initialises the sliders for each of the variables and also reduces the number of errors
                                                                                // that can appear as the slider is given a Min and Max value so the user can only choose the values given so no validation is required.

    JSlider xFrictionSlider = new JSlider(JSlider.HORIZONTAL,-100,100,0);

    JSlider radiusSlider = new JSlider(JSlider.HORIZONTAL,10,100,50);
    JSlider energySlider = new JSlider(JSlider.HORIZONTAL,10,100,50);
    //JSlider xSpeedSlider = new JSlider(JSlider.HORIZONTAL,-50,50,0);


    public Sim() {

        super("Sim"); // the class is supersized
        setPreferredSize(new Dimension(1280, 720)); // the JFrames size is set using the dimension library
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // basic close line of code for the JFrame where it'll close as the RED button is pressed in the top right corner
        getContentPane().setLayout(new GridBagLayout()); // the layout for the JFrame is set up, also if the getContentPane is not before setLayout the JFrames layout will continue to be null
        setResizable(false); // makes it so the created window cannot be resized by dragging the corners or edges of the box, this is why the component resize method is useless in the Ball class
        getContentPane().setBackground(Color.ORANGE); // getContentPane is only required if a change to the looks and feels of the Component occurs otherwise if it only changes it functionality the getContent...is not needed...
                                                    // also this line is pretty self-contained so no explanation is needed for what this code does.
        setTitle("Ball Simulation by Dominic Balog");
        gui();
        pack();
        setVisible(true);

        new Timer(DELAY, ballContainer).start(); //creates and starts a new timers so whenever this constructor is called a new Timer is created straight away.

    }

    public void gui(){

        JButton addBallButton = new JButton(new AbstractAction("Add Ball") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ballContainer.addBall();
            }
            // this line of code defines what the button will do when it is pressed, in this case a new ball will be added to the ball container which we created in the ballContainer's class and the addBall method will be called/run

        });

        GridBagConstraints c = new GridBagConstraints();

        if (shouldFill) {
            //natural height, maximum width
            c.fill = GridBagConstraints.HORIZONTAL;
        }

        JMenuBar menuBar = new JMenuBar();



        addBallButton.setPreferredSize(new Dimension(200, 50));
        addBallButton.setMultiClickThreshhold(1000); // this line of code will stop the button from working for 1.5 seconds stopping the user from spamming it and if the user does spam it, nothing will happen.
        c.gridy = 2;
        c.gridx = 1;
        c.insets = new Insets(10,10,10,10);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = .5;


        getContentPane().add(addBallButton,c);

        JButton removeButton = new JButton(new AbstractAction("Remove Ball") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try{
                ballContainer.remBall();
            }catch(Exception e){
                }// this line of code defines what the button will do when it is pressed, in this case a new ball will be removed from the ball container which we created in the ballContainer's class and the remBall method will be called/run
            }
        });



        removeButton.setPreferredSize(new Dimension(200, 50));
        removeButton.setMultiClickThreshhold(1000); // this line of code will stop the button from working for 1.5 seconds stopping the user from spamming it and if the user does spam it, nothing will happen.
        c.gridy = 2;
        c.gridx = 0;
        c.insets = new Insets(10,10,10,10);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = .5;


        getContentPane().add(removeButton,c);



        //gravitySlider.setMinorTickSpacing((int)0.1); // the smaller lines underneath the slider
        //gravitySlider.setMajorTickSpacing(1); // the big gaps that are shown in the slider
        Hashtable gravityTable = new Hashtable(); // a new HashTable is created for the JLabels
        gravityTable.put( new Integer( 0 ), new JLabel("Gravity") ); // the JLabel will replace the TickSpacings and therefore the first 2 lines are useless
        gravityTable.put( new Integer( -10 ), new JLabel("-10") );
        gravityTable.put( new Integer( 10 ), new JLabel("10") ); // these 3 lines just set the Middle, left, and rightmost labels for the sliders to help the user navigate
        gravitySlider.setLabelTable( gravityTable); // this line adds the labels to the slider itself so it is now visible
        gravitySlider.setBackground(Color.cyan);
        gravitySlider.setPaintTicks(true); // paints the Ticks
        gravitySlider.setPaintLabels(true); // paints the Labels onto the slider
        gravitySlider.addChangeListener(new ChangeListener() { // the slider is added a new changeListener which is called if the slider is moved at runtime.
            @Override
            public void stateChanged(ChangeEvent e) { // this override method is run when the slider is changed with the ChangeEvent data type parameter
                JSlider source = (JSlider)e.getSource(); // the source is considered to be the JSlider itself therefore the source will just be acquired using a getter and encapsulated to be a JSlider
                int jsValue = 0; // the sliders value is initialised
                if(!source.getValueIsAdjusting()){ // if the value is not adjusting then
                    jsValue = source.getValue(); // the sliders value is acquired using another getter
                    Ball.setGravity(jsValue); // and simultaneously the new gravity value is set using the setter which was created in the Ball class
                }else{
                    Ball.setGravity(jsValue); // if the slider is adjusting on the other hand then just set the value to be the value that the slider is adjusted to.
                }

            }
        });

        c.gridy = 0;
        c.gridx = 0;
        c.fill = GridBagConstraints.HORIZONTAL;

        c.weightx = .5;

        getContentPane().add(gravitySlider,c);


        //xFrictionSlider .setMinorTickSpacing(10);
        //xFrictionSlider .setMajorTickSpacing(50);
        Hashtable xFricTable = new Hashtable(); // a new HashTable is created for the JLabels
        xFricTable.put( new Integer( 0 ), new JLabel("Friction") ); // the JLabel will replace the TickSpacings and therefore the first 2 lines are useless
        xFricTable.put( new Integer( - 100), new JLabel("-100") );
        xFricTable.put( new Integer( 100 ), new JLabel("100") ); // these 3 lines just set the Middle, left, and rightmost labels for the sliders to help the user navigate
        xFrictionSlider .setLabelTable( xFricTable); // this line adds the labels to the slider itself so it is now visible
        xFrictionSlider.setBackground(Color.cyan);
        xFrictionSlider .setPaintTicks(true);
        xFrictionSlider .setPaintLabels(true);
        xFrictionSlider .addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider)e.getSource();
                int jsValue = 0;
                if(!source.getValueIsAdjusting()){
                    jsValue = source.getValue();
                    Ball.setxFriction(jsValue/100);
                }else{
                    jsValue = 0;
                    Ball.setxFriction(jsValue/100);
                }

            }
        });

        c.gridy = 0;
        c.gridx = 1;
        c.weightx = .5;
        c.insets = new Insets(10,10,10,10);

        c.fill = GridBagConstraints.HORIZONTAL;


        getContentPane().add(xFrictionSlider ,c );

        //radiusSlider.setMinorTickSpacing(5);
        //radiusSlider.setMajorTickSpacing(25);
        Hashtable radiusTable = new Hashtable(); // a new HashTable is created for the JLabels
        radiusTable.put( new Integer( 50 ), new JLabel("Radius") ); // the JLabel will replace the TickSpacings and therefore the first 2 lines are useless
        radiusTable.put( new Integer( 10), new JLabel("10") );
        radiusTable.put( new Integer( 100 ), new JLabel("100") ); // these 3 lines just set the Middle, left, and rightmost labels for the sliders to help the user navigate
        radiusSlider.setLabelTable( radiusTable); // this line adds the labels to the slider itself so it is now visible
        radiusSlider.setBackground(Color.cyan);
        radiusSlider.setPaintTicks(true);
        radiusSlider.setPaintLabels(true);
        radiusSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider)e.getSource();
                int jsValue = 0;
                if(!source.getValueIsAdjusting()){
                    jsValue = source.getValue();
                    Ball.setRadius(jsValue);
                }else{
                    Ball.setRadius(jsValue);
                }

            }
        });

        c.gridy = 1;
        c.gridx = 1;
        c.weightx = .5;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 1;
        getContentPane().add(radiusSlider,c);

        //energySlider.setMinorTickSpacing(10);
        //energySlider.setMajorTickSpacing(50);
        Hashtable energyTable = new Hashtable(); // a new HashTable is created for the JLabels
        energyTable.put( new Integer( 50 ), new JLabel("Energy") ); // the JLabel will replace the TickSpacings and therefore the first 2 lines are useless
        energyTable.put( new Integer( 100), new JLabel("100" ));
        energyTable.put( new Integer( 0 ), new JLabel("0")  ); // these 3 lines just set the Middle, left, and rightmost labels for the sliders to help the user navigate
        energySlider.setLabelTable( energyTable); // this line adds the labels to the slider itself so it is now visible
        energySlider.setBackground(Color.cyan);
        energySlider.setPaintTicks(true);
        energySlider.setPaintLabels(true);
        energySlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider)e.getSource();
                int jsValue = 0;
                if(!source.getValueIsAdjusting()){
                    jsValue = source.getValue();
                    Ball.setEnergyLoss(jsValue/100);
                }else{
                    Ball.setEnergyLoss(jsValue/100);
                }

            }
        });

        c.gridy = 1;
        c.gridx = 0;
        c.weightx = .5;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 1;
        getContentPane().add(energySlider,c);


        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx  = 5;
        c.gridy = 1;
        c.gridheight = 3;
        c.gridwidth = 3;
        c.weightx = 0.5;

        setJMenuBar(menuBar);
        file.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
        fileMenu.add(file);
        fileMenu.add(exit);
        menuBar.add(fileMenu);

        getContentPane().add(ballContainer,c);

    }

    public static int random(int maxRange) {
        return (int) Math.round((Math.random() * maxRange)); // this is a custom made random method which I use a lot in the program and preferred this over the Math.random method as that only goes from 0.0 - 1.0 and would also require me being redundant in my code
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() { // the SwingUtilities makes sure that the GUI is not run in the Main Thread and is run in the EDT(Event Dispatcher Thread) which allows Swing GUI to show on screen.
            @Override
            public void run() {
                new Sim();
            } // a new constructor is called every time the program is started
        });
    }


}

