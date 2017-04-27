package com.github.mielzus.tetris;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SideBar extends JPanel {

	private static final long serialVersionUID = 1L;

	private final int BoardWidth = 5;
    private final int BoardHeight = 22;

    private int shapeI = 0;
    private int shapeJ = 0;
    private int shapeL = 0;
    private int shapeO = 0;
    private int shapeS = 0;
    private int shapeT = 0;
    private int shapeZ = 0;
    
    private int drawX;
    private int drawY;

    private Shape shape;

    private JLabel shapeCountI;
    private JLabel shapeCountJ;
    private JLabel shapeCountL;
    private JLabel shapeCountO;
    private JLabel shapeCountS;
    private JLabel shapeCountT;
    private JLabel shapeCountZ;

    public SideBar() {
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        shapeCountI = new JLabel("I blocks: " + shapeI);
        shapeCountJ = new JLabel("J blocks: " + shapeJ);
        shapeCountL = new JLabel("L blocks: " + shapeL);
        shapeCountO = new JLabel("O blocks: " + shapeO);
        shapeCountS = new JLabel("S blocks: " + shapeS);
        shapeCountT = new JLabel("T blocks: " + shapeT);
        shapeCountZ = new JLabel("Z blocks: " + shapeZ);
        add(shapeCountI);
        add(shapeCountJ);
        add(shapeCountL);
        add(shapeCountO);
        add(shapeCountS);
        add(shapeCountT);
        add(shapeCountZ);
    }

    public void updateScores(Shape.Tetrominoes shape) {
        switch (shape) {
            case NoShape:
                break;
            case LineShape:
                shapeI++;
                shapeCountI.setText("I blocks: " + shapeI);
                break;
            case MirroredLShape:
                shapeJ++;
                shapeCountJ.setText("J blocks: " + shapeJ);
                break;
            case LShape:
                shapeL++;
                shapeCountL.setText("L blocks: " + shapeL);
                break;
            case SquareShape:
                shapeO++;
                shapeCountO.setText("O blocks: " + shapeO);
                break;
            case SShape:
                shapeS++;
                shapeCountS.setText("S blocks: " + shapeS);
                break;
            case TShape:
                shapeT++;
                shapeCountT.setText("T blocks: " + shapeT);
                break;
            case ZShape:
                shapeZ++;
                shapeCountZ.setText("Z blocks: " + shapeZ);
                break;
        }
    }

    public void displayPiece(Shape shape) {
        this.shape = shape;
        repaint();
    }

    int squareWidth() { return (int) getSize().getWidth() / BoardWidth; }
    int squareHeight() { return (int) getSize().getHeight() / BoardHeight; }

    public void paint(Graphics g)
    {
        super.paint(g);

        drawX = (int) getSize().getWidth() / 2 - 10;
        drawY = (int) getSize().getHeight() / 2 + 27;

        if (shape.getShape() != Shape.Tetrominoes.NoShape) {
            int x = 0;
            int y = 0;
            for (int i = 0; i < 4; ++i) {
                x = drawX + shape.x(i)*squareWidth();
                y = drawY - shape.y(i)*squareHeight();
                drawSquare(g, 0 + x, y, shape.getShape());
            }
        }
    }

    private void drawSquare(Graphics g, int x, int y, Shape.Tetrominoes shape)
    {
        /*
         * Colours:
         * Orange
         * Blue
         * Red
         * Light Sky Blue
         * Yellow
         * Magenta
         * Lime Green
         */
        Color colors[] = {
            /*
             * Transparent
             */
            new Color(0, 0, 0),
            /*
             * Z (Red)
             *   []
             * [][]
             * []
             */
            new Color(255, 0, 0),
            /*
             * S (Lime)
             * []
             * [][]
             *   []
             */
            new Color(191, 255, 0),
            /*
             * I (Cyan)
             * []
             * []
             * []
             * []
             */
            new Color(0, 255, 255),
            /*
             * T (Purple)
             *   []
             * [][][]
             */
            new Color(128, 0, 128),
            /*
             * O (Yellow)
             * [][]
             * [][]
             */
             new Color(255, 255, 0),
            /*
             * L (Orange)
             * [][]
             *   []
             *   []
             */
            new Color(255, 128, 0),
            /*
             * J (Blue)
             * [][]
             * []
             * []
             */
            new Color(0, 0, 255)
        };


        Color color = colors[shape.ordinal()];
        g.setColor(color);
        g.fillRect(x + 1, y + 1, squareWidth() - 2, squareHeight() - 2);

        g.setColor(color.brighter());
        g.drawLine(x, y + squareHeight() - 1, x, y);
        g.drawLine(x, y, x + squareWidth() - 1, y);

        g.setColor(color.darker());
        g.drawLine(x + 1, y + squareHeight() - 1, x + squareWidth() - 1, y + squareHeight() - 1);
        g.drawLine(x + squareWidth() - 1, y + squareHeight() - 1, x + squareWidth() - 1, y + 1);
    }
}
