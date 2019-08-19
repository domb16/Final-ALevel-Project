import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.swing.*;

public class main {

    /*
    Initialise everything and run the program
        + Builder class - puts all other classes into something that works
        + Initialise - Ball_Panel, UI, Each DEPRECATED.Shapes.Shapes.
            + Ball_Panel should be built in UI
            + UI should take care of all element building
            + Each DEPRECATED.Shapes.Shapes should be handled in Ball_Panel
     */

    public static void main(String[] args) {
         SwingUtilities.invokeLater(GUI::new);

    }

}

