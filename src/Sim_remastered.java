import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.swing.*;

public class Sim_remastered {

    /*
    Initialise everything and run the program
        + Builder class - puts all other classes into something that works
        + Initialise - Ball_Panel, GUI, Each DEPRECATED.Ball.
            + Ball_Panel should be built in GUI
            + GUI should take care of all element building
            + Each DEPRECATED.Ball should be handled in Ball_Panel
     */
    private static final Logger logger = Logger.getLogger(Sim_remastered.class.getName());
    private List<Object> methodList = new ArrayList<>(){{
//        add the list of runnables here then loop through it
    }};

    private void addClasses( Runnable methodCall){
        methodList.add(methodCall);
    }

    private Sim_remastered() {

        try {
//            for (Runnable method : methodList ) {
            logger.info("Invoking main method: ");
//          .run();
            // this is method reference for new Runnable(){ new <method> }
            SwingUtilities.invokeLater(GUI::new);
            SwingUtilities.invokeLater(BallsPanel::new);


        } catch( Exception e ){
            logger.warning("A method has gone bust: "+ e);
        }
    }


    public static void main(String[] args) {
        new Sim_remastered();
    }
}
