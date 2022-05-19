package View;

/**
 *
 * @author vital
 */
import Model.City;
import Model.Territory;
import Tools.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class MapFrame extends JFrame {

    int width = 1160;
    int height = 899;
    int radius = 5;
    double posX, posY;
    BufferedImage image;

    public MapFrame() throws IOException {
        super("World map");
        image = ImageIO.read(new File("world-map.jpg"));
        setSize(width + 14, height - 100);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void draw(Territory... args) {
        CoordinatesTool tool = new CoordinatesTool(width, height);

        JPanel pane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                super.paintComponent(g2d);
                g2d.drawImage(image, 0, 0, null);//draw map
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);

                for (Territory territory : args) {
                    g2d.setColor(Color.RED);
                    City city = (City) territory;
                    if (city != null) {
                        posX = tool.getX(city.getLongitude());
                        posY = tool.getY(city.getLatitude());
                        Ellipse2D.Double shape = new Ellipse2D.Double(posX - radius / 2, posY - radius / 2, radius, radius);

                        g2d.fill(shape);
                        g2d.draw(shape);
                        g2d.setColor(Color.WHITE);
                        g.setFont(new Font("TimesRoman", Font.PLAIN, 18));
                        g2d.drawString(city.getName(), (int) posX + radius, (int) posY + radius);
                    }

                }

            }
        };
        this.add(pane);
        setVisible(true);
    }

}
