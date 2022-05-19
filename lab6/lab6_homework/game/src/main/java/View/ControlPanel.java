/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.Game;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author vital
 */
public class ControlPanel extends JPanel {

    final MainFrame frame;
    JButton exitBtn = new JButton("Exit");
    JButton loadBtn = new JButton("Load");
    JButton saveGame = new JButton("Save Game");
    JButton savePNG = new JButton("Save as PNG");

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        add(savePNG);
        add(saveGame);
        add(loadBtn);
        add(exitBtn);

//configure listeners for all buttons
        exitBtn.addActionListener(this::exitGame);
        savePNG.addActionListener(this::saveAsPNG);
        saveGame.addActionListener(this::save);
        loadBtn.addActionListener(this::load);
    }

    private void exitGame(ActionEvent e) {
        frame.dispose();
    }

    private void saveAsPNG(ActionEvent event) {
        try {
            ImageIO.write(frame.canvas.image, "png", new File("C:\\Users\\vital\\Desktop\\game.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void save(ActionEvent event) {
        Game game = frame.canvas.game;
        try {
            FileOutputStream fos = new FileOutputStream("game.ser");
            ObjectOutputStream out = new ObjectOutputStream(fos);
            out.writeObject(game);
            out.flush();
            fos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ControlPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ControlPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void load(ActionEvent e) {
        try {
            FileInputStream fis = new FileInputStream("game.ser");
            ObjectInputStream in = new ObjectInputStream(fis);
            
            frame.canvas.game = (Game)in.readObject();
            fis.close();
            if(frame.canvas.game.over)
                frame.configPanel.setWinner();
            frame.canvas.repaintBoard();
            frame.repaint();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ControlPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ControlPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControlPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
