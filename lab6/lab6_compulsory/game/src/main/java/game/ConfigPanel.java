/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author vital
 */
public class ConfigPanel extends JPanel {

    final MainFrame frame;
    JLabel label;
    JSpinner rowSpinner;
    JSpinner colSpinner;
    JButton createBtn;
    
public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        label = new JLabel("Grid size:");
        rowSpinner = new JSpinner(new SpinnerNumberModel(10, 2, 100, 1));
        colSpinner = new JSpinner(new SpinnerNumberModel(10, 2, 100, 1));
        createBtn = new JButton("Create");
        add(label); //JPanel uses FlowLayout by default
        add(rowSpinner);
        add(colSpinner);
        add(createBtn);
    }
    
    public int getRows(){
        return (int)rowSpinner.getValue();
    }
    
    public int getCols(){
        return (int)colSpinner.getValue();
    }
}
