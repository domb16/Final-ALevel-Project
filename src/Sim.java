

import java.awt.*;
import java.awt.event.*;
import java.util.Hashtable;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class Sim extends JFrame { 

    static final int DELAY = 20; 
    static BallPanel ballContainer = new BallPanel();
    private boolean shouldFill = true;
    private JMenu fileMenu = new JMenu("Menu");
    private JMenuItem file = new JMenuItem("File");
    private JMenuItem exit = new JMenuItem("Exit");

    JSlider gravitySlider = new JSlider(JSlider.HORIZONTAL,-10,10,0); 
                                                                                

    JSlider xFrictionSlider = new JSlider(JSlider.HORIZONTAL,-100,100,0);

    JSlider radiusSlider = new JSlider(JSlider.HORIZONTAL,10,100,50);
    JSlider energySlider = new JSlider(JSlider.HORIZONTAL,10,100,50);
    


    public Sim() {

        super("Sim"); 
        setPreferredSize(new Dimension(1280, 720)); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        getContentPane().setLayout(new GridBagLayout()); 
        setResizable(false); 
        getContentPane().setBackground(Color.ORANGE); 
                                                    
        setTitle("Ball Simulation by Dominic Balog");
        gui();
        pack();
        setVisible(true);

        new Timer(DELAY, ballContainer).start(); 

    }

    public void gui(){

        JButton addBallButton = new JButton(new AbstractAction("Add Ball") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ballContainer.addBall();
            }
            

        });

        GridBagConstraints c = new GridBagConstraints();

        if (shouldFill) {
            
            c.fill = GridBagConstraints.HORIZONTAL;
        }

        JMenuBar menuBar = new JMenuBar();



        addBallButton.setPreferredSize(new Dimension(200, 50));
        addBallButton.setMultiClickThreshhold(1000); 
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
                }
            }
        });



        removeButton.setPreferredSize(new Dimension(200, 50));
        removeButton.setMultiClickThreshhold(1000); 
        c.gridy = 2;
        c.gridx = 0;
        c.insets = new Insets(10,10,10,10);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = .5;


        getContentPane().add(removeButton,c);



        
        
        Hashtable gravityTable = new Hashtable(); 
        gravityTable.put( new Integer( 0 ), new JLabel("Gravity") ); 
        gravityTable.put( new Integer( -10 ), new JLabel("-10") );
        gravityTable.put( new Integer( 10 ), new JLabel("10") ); 
        gravitySlider.setLabelTable( gravityTable); 
        gravitySlider.setBackground(Color.cyan);
        gravitySlider.setPaintTicks(true); 
        gravitySlider.setPaintLabels(true); 
        gravitySlider.addChangeListener(new ChangeListener() { 
            @Override
            public void stateChanged(ChangeEvent e) { 
                JSlider source = (JSlider)e.getSource(); 
                int jsValue = 0; 
                if(!source.getValueIsAdjusting()){ 
                    jsValue = source.getValue(); 
                    Ball.setGravity(jsValue); 
                }else{
                    Ball.setGravity(jsValue); 
                }

            }
        });

        c.gridy = 0;
        c.gridx = 0;
        c.fill = GridBagConstraints.HORIZONTAL;

        c.weightx = .5;

        getContentPane().add(gravitySlider,c);


        
        
        Hashtable xFricTable = new Hashtable(); 
        xFricTable.put( new Integer( 0 ), new JLabel("Friction") ); 
        xFricTable.put( new Integer( - 100), new JLabel("-100") );
        xFricTable.put( new Integer( 100 ), new JLabel("100") ); 
        xFrictionSlider .setLabelTable( xFricTable); 
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

        
        
        Hashtable radiusTable = new Hashtable(); 
        radiusTable.put( new Integer( 50 ), new JLabel("Radius") ); 
        radiusTable.put( new Integer( 10), new JLabel("10") );
        radiusTable.put( new Integer( 100 ), new JLabel("100") ); 
        radiusSlider.setLabelTable( radiusTable); 
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

        
        
        Hashtable energyTable = new Hashtable(); 
        energyTable.put( new Integer( 50 ), new JLabel("Energy") ); 
        energyTable.put( new Integer( 100), new JLabel("100" ));
        energyTable.put( new Integer( 0 ), new JLabel("0")  ); 
        energySlider.setLabelTable( energyTable); 
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
        return (int) Math.round((Math.random() * maxRange)); 
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Sim::new);
    }


}

