package com.github.ognen67.battleship.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class BattleshipView {

    public static void main(String[] args) {

        int numOfTiles = 8;
        BattleshipGame game = new BattleshipGame(numOfTiles);

        JFrame window = new JFrame();
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                int x = 0, y = 0;
                int widthPerOne = this.getWidth() / 8;
                int heightPerOne = this.getHeight() / 8;
                int squareLength = Math.min(widthPerOne, heightPerOne);
                x = (this.getWidth() - squareLength * 8) / 2;
                y = (this.getHeight() - squareLength * 8) / 2;

                game.currentPlayer = 1;
                for (int i = 0; i < numOfTiles; i++) {
                    for (int j = 0; j < numOfTiles; j++) {
                        char element = game.getCurrentPlayerBoard().board[i][j];
                        Color color = Color.WHITE;
                        if (element == '-') color = Color.WHITE;
                        else if (element == 's') color = Color.BLUE;
                        g.setColor(color);
                        g.fillRect(x, y, squareLength, squareLength);
                        x += squareLength;
                    }
                    y += squareLength;
                    x = (this.getWidth() - squareLength * 8) /2 ;
                }
            }
        };

        JPanel panel2 = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                int x = 0, y = 0;
                int widthPerOne = this.getWidth() / 8;
                int heightPerOne = this.getHeight() / 8;
                int squareLength = Math.min(widthPerOne, heightPerOne);
                x = (this.getWidth() - squareLength * 8) / 2;
                y = (this.getHeight() - squareLength * 8) / 2;

                game.currentPlayer = 2;
                for (int i = 0; i < numOfTiles; i++) {
                    for (int j = 0; j < numOfTiles; j++) {
                        char element = game.getCurrentPlayerBoard().board[i][j];
                        Color color = Color.WHITE;
                        if (element == '-') color = Color.WHITE;
                        else if (element == 's') color = Color.BLUE;
                        g.setColor(color);
                        g.fillRect(x, y, squareLength, squareLength);
                        x += squareLength;
                    }
                    y += squareLength;
                    x = (this.getWidth() - squareLength * 8) /2 ;
                }
            }
        };

        JLabel label1 = new JLabel("Player 1's board");
        JLabel label2 = new JLabel("Player 2's board");
        label1.setHorizontalAlignment(JLabel.CENTER);
        label1.setVerticalAlignment(JLabel.CENTER);
        label2.setHorizontalAlignment(JLabel.CENTER);
        label2.setVerticalAlignment(JLabel.CENTER);

        window.setLayout(new GridLayout(2, 2));

        panel.setBounds(1, 2, 400, 400);
        window.setSize(500,500);

        window.setVisible(true);

        window.setTitle("Battleship");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.add(label1);
        window.add(label2);
        window.add(panel);
        window.add(panel2);
        ImageIcon image = new ImageIcon("C:\\Users\\todor\\Desktop\\SmallJavaProjects\\Battleship\\battleshiplogo.png");
        window.setIconImage(image.getImage());
    }
}
