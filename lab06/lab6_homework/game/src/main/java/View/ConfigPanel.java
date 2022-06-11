package View;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
    JLabel winner;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        label = new JLabel("Grid size:");
        rowSpinner = new JSpinner(new SpinnerNumberModel(8, 2, 100, 1));
        colSpinner = new JSpinner(new SpinnerNumberModel(8, 2, 100, 1));
        createBtn = new JButton("Create");
        winner = new JLabel("");
        add(winner);
        add(label);
        add(rowSpinner);
        add(colSpinner);
        add(createBtn);

        createBtn.addActionListener(this::resizeGrid);
    }

    public int getRows() {
        return (int) rowSpinner.getValue();
    }

    public int getCols() {
        return (int) colSpinner.getValue();
    }

    public void setRows(int rows) {
        rowSpinner.setValue(Integer.valueOf(rows));
    }

    public void setCols(int cols) {
        colSpinner.setValue(Integer.valueOf(cols));
    }

    private void resizeGrid(ActionEvent e) {
        unsetWinner();
        frame.canvas.resizeGrid();
        frame.repaint();
    }

    public void setWinner() {
        if (frame.canvas.game.winner == 0) {
            winner.setForeground(Color.BLUE);
            winner.setText("BLUE WON!");
        } else {
            winner.setForeground(Color.RED);
            winner.setText("RED WON!");
        }

        frame.canvas.repaintBoard();
        frame.repaint();
    }
    
    public void unsetWinner(){
         winner.setText("");
    }
}
