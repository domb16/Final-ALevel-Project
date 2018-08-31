package GUI;

import java.awt.*;

public class CustomPanel extends javax.swing.JPanel {
    private int width, height;
    private Container container;
    public CustomPanel(Container container, int width, int height) {
        super();
        this.width = width;
        this.height = height;
        this.container = container;

    }

    protected void initPanel() {
        setPreferredSize(new Dimension(this.width, this.height));
        setBackground(Color.white);
        this.container.add(this);
        setVisible(true);
    }

}
