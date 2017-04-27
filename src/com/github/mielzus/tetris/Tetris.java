package com.github.mielzus.tetris;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Tetris extends JFrame {

    JLabel statusbar;
    SideBar sidepanel;

    public Tetris() {
        statusbar = new JLabel(" 0");
        sidepanel = new SideBar();
        sidepanel.setPreferredSize(new Dimension(100,400));
        sidepanel.setOpaque(true);
        sidepanel.setBackground(Color.CYAN);
        Board board = new Board(this);
        board.setOpaque(true);
        board.setBackground(Color.BLACK);
        add(statusbar, BorderLayout.SOUTH);
        add(sidepanel, BorderLayout.EAST);
        add(board);
        board.start();
        setSize(300, 400);
        setTitle("Tetris");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
   }

   public JLabel getStatusBar() {
       return statusbar;
   }
   
   public SideBar getSidePanel() {
       return sidepanel;
   }

    public static void main(String[] args) {

        Tetris game = new Tetris();
        game.setLocationRelativeTo(null);
        game.setVisible(true);

    } 
}