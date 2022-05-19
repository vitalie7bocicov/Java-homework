package View;

import Model.Game;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JPanel;

/**
 *
 * @author vital
 */
public class DrawingPanel extends JPanel {

    private final MainFrame frame;
    int rows, cols;
    int canvasWidth = 500, canvasHeight = 500;
    int boardWidth, boardHeight;
    int cellWidth, cellHeight;
    int padX, padY;
    int stoneSize = 20;
    Game game;

    BufferedImage image; //the offscreen image
    Graphics2D offscreen; //the offscreen graphics

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        createOffscreenImage();
        init(frame.configPanel.getRows(), frame.configPanel.getCols());
    }

    private void createOffscreenImage() {
        image = new BufferedImage(
                canvasWidth, canvasHeight, BufferedImage.TYPE_INT_ARGB);
        offscreen = image.createGraphics();
        offscreen.setColor(Color.WHITE); //fill the image with white
        offscreen.fillRect(0, 0, canvasWidth, canvasHeight);
    }

    final void init(int rows, int cols) {
        game = new Game(rows, cols);
        this.rows = rows;
        this.cols = cols;
        this.padX = stoneSize + 10;
        this.padY = stoneSize + 10;
        this.cellWidth = (canvasWidth - 2 * padX) / (cols - 1);
        this.cellHeight = (canvasHeight - 2 * padY) / (rows - 1);
        this.boardWidth = (cols - 1) * cellWidth;
        this.boardHeight = (rows - 1) * cellHeight;

        setPreferredSize(new Dimension(canvasWidth, canvasHeight));

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                checkStone(e.getX(), e.getY());
                repaint();
            }
//Can’t use lambdas, JavaFX does a better job in these cases
        });
    }

    private boolean checkStoneCoordinates(int x, int y) {
        if ((x % cellWidth / 2 > stoneSize) || (x % cellWidth / 2 < stoneSize / 2)) {
            return false;
        }
        if ((y % cellHeight / 2 > stoneSize) || (y % cellHeight / 2 < stoneSize / 2)) {
            return false;
        }
        return true;
    }

    public void resizeGrid() {
        offscreen.setColor(Color.WHITE); //fill the image with white
        offscreen.fillRect(0, 0, canvasWidth, canvasHeight);
        this.rows = frame.configPanel.getRows();
        this.cols = frame.configPanel.getCols();
        this.padX = stoneSize + 10;
        this.padY = stoneSize + 10;
        this.cellWidth = (canvasWidth - 2 * padX) / (cols - 1);
        this.cellHeight = (canvasHeight - 2 * padY) / (rows - 1);
        this.boardWidth = (cols - 1) * cellWidth;
        this.boardHeight = (rows - 1) * cellHeight;
        game = new Game(rows, cols);
        setPreferredSize(new Dimension(canvasWidth, canvasHeight));

    }

    public void repaintBoard() {
        createOffscreenImage();
        
        this.rows=game.rows;
        this.cols=game.cols;
        this.frame.configPanel.setRows(rows);
        this.frame.configPanel.setCols(cols);
        this.padX = stoneSize + 10;
        this.padY = stoneSize + 10;
        this.cellWidth = (canvasWidth - 2 * padX) / (cols - 1);
        this.cellHeight = (canvasHeight - 2 * padY) / (rows - 1);
        this.boardWidth = (cols - 1) * cellWidth;
        this.boardHeight = (rows - 1) * cellHeight;
        
        setPreferredSize(new Dimension(canvasWidth, canvasHeight));
        
    }

    @Override
    public void update(Graphics g) {
    } //No need for update

    @Override
    protected void paintComponent(Graphics graphics) {
        graphics.drawImage(image, 0, 0, this);
        paintGrid(graphics);
        paintSticks(graphics);
        paintStones(graphics);
    }

    private void drawStone(int x, int y, int color) {

        if (color == 0) {
            offscreen.setColor(Color.BLUE);
        } else {
            offscreen.setColor(Color.RED);
        }

        x = padX + x * cellWidth;
        y = padY + y * cellHeight;
        offscreen.drawOval(x - stoneSize / 2, y - stoneSize / 2, stoneSize, stoneSize);
        offscreen.fillOval(x - stoneSize / 2, y - stoneSize / 2, stoneSize, stoneSize);

        offscreen.drawImage(image, 0, 0, this);
    }

    private void checkStone(int x, int y) {
        int posX = x / cellWidth;
        int posY = y / cellHeight;
        boolean gameOver=false;
        if (!game.over && checkStoneCoordinates(x, y) && game.isPlayable(posX, posY)) {

            if (!game.started) {
                game.lastMove = game.getNode(posY, posX);
                 if(game.player==0)
                    game.player=1;
                else
                    game.player=0;
                game.getNode(posY, posX).setPlayer(game.player);
                drawStone(posX, posY, game.player);
                gameOver=game.checkGameOver(posY,posX);
                game.started = true;
                game.lastMove = game.getNode(posY, posX);
            } else if (game.lastMove.isAdjacent(game.getNode(posY, posX))) {
                if(game.player==0)
                    game.player=1;
                else
                    game.player=0;
                game.getNode(posY, posX).setPlayer(game.player);
                drawStone(posX, posY, game.player);
                gameOver=game.checkGameOver(posY,posX);
                game.lastMove = game.getNode(posY, posX);
            }
            if(gameOver)
                frame.configPanel.setWinner();
        }
    }

    private void paintStones(Graphics graphics) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int tempPlayer = game.getNode(row, col).getPlayer();
                if (tempPlayer != -1) {
                    drawStone(col, row, tempPlayer);
                }
            }
        }
        graphics.drawImage(image, 0, 0, this);
    }

    private void paintGrid(Graphics graphics) {

        offscreen.setColor(Color.DARK_GRAY);
//horizontal lines
        for (int row = 0; row < rows; row++) {
            int x1 = padX;
            int y1 = padY + row * cellHeight;
            int x2 = padX + boardWidth;
            int y2 = y1;
            offscreen.drawLine(x1, y1, x2, y2);
        }
//vertical lines 
        for (int col = 0; col < cols; col++) {
            int x1 = padX + col * cellWidth;
            int y1 = padY;
            int x2 = x1;
            int y2 = y1 + boardHeight;
            offscreen.drawLine(x1, y1, x2, y2);
        }
//intersections
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int x = padX + col * cellWidth;
                int y = padY + row * cellHeight;
                offscreen.setColor(Color.LIGHT_GRAY);
                offscreen.drawOval(x - stoneSize / 2, y - stoneSize / 2, stoneSize, stoneSize);
            }
        }
        graphics.drawImage(image, 0, 0, this);
    }

    private void paintSticks(Graphics graphics) {
        Stroke defaultStroke;
        defaultStroke = offscreen.getStroke();

        offscreen.setStroke(new BasicStroke(5));
        offscreen.setColor(Color.black);
//vertical sticks
        for (int col = 0; col < cols; col++) {
            for (int row = 0; row < rows - 1; row++) {
                if (game.getNode(row, col).isAdjacent(game.getNode(row + 1, col))) {

                    int x1 = padX + col * cellWidth;
                    int y1 = padY + row * cellHeight;
                    int x2 = x1;
                    int y2 = y1 + cellHeight;
                    offscreen.drawLine(x1, y1, x2, y2);
                }
            }
        }
//horizontal lines
        for (int col = 0; col < cols - 1; col++) {
            for (int row = 0; row < rows; row++) {
                if (game.getNode(row, col).isAdjacent(game.getNode(row, col + 1))) {
                    int x1 = padX + col * cellWidth;
                    int y1 = padY + row * cellHeight;
                    int x2 = x1 + cellWidth;
                    int y2 = y1;
                    offscreen.drawLine(x1, y1, x2, y2);

                }
            }
        }
        offscreen.setStroke(defaultStroke);
        graphics.drawImage(image, 0, 0, this);
    }
    
    
}
