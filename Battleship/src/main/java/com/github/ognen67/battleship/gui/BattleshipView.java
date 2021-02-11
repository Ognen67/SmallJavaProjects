package com.github.ognen67.battleship.gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Optional;

public class BattleshipView {

    public static void main(String[] args) {

        int numOfTiles = 8;
        BattleshipGame game = new BattleshipGame(numOfTiles);

        JFrame window = new JFrame();
        JPanel panel1 = new JPanel() {
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
                    x = (this.getWidth() - squareLength * 8) / 2;
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
                    x = (this.getWidth() - squareLength * 8) / 2;
                }
            }
        };


        JLabel label1 = new JLabel("Player 1's board");
        JLabel label2 = new JLabel("Player 2's board");
        label1.setHorizontalAlignment(JLabel.CENTER);
        label1.setVerticalAlignment(JLabel.CENTER);
        label2.setHorizontalAlignment(JLabel.CENTER);
        label2.setVerticalAlignment(JLabel.CENTER);
        label1.setBounds(new Rectangle(100, 50));
        label2.setBounds(new Rectangle(100, 50));

        GridBagLayout gridBagLayout = new GridBagLayout();
        window.setLayout(gridBagLayout);
        GridBagConstraints gbc = new GridBagConstraints();

        panel1.setBounds(1, 2, 400, 400);
        window.setSize(500, 500);

        window.setTitle("Battleship");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


//        gbc.gridx = 0;
//        gbc.gridy = 0;
//        window.add(label1, gbc);
//        gbc.gridx = 0;
//        gbc.gridy = 1;
//        gbc.gridwidth = 2;
//        window.add(panel1, gbc);
//        gbc.gridx = 0;
//        gbc.gridy = 2;
//        window.add(new JLabel("info screen"), gbc);

        JPanel infoPanel = new JPanel();
        JLabel label = new JLabel("Hello");
        label.setBackground(Color.GRAY);
        infoPanel.add(label);
        infoPanel.setBounds(0, 20, 200, 20);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        window.add(infoPanel, gbc);
//        window.add(new JButton("1"), gbc);
//        gbc.gridx = 1;
//        gbc.gridy = 0;
//        gbc.weightx = 1;
//        gbc.weighty = 0;
//        window.add(new JButton("2"), gbc);
//        gbc.gridx = 2;
//        gbc.gridy = 0;
//        gbc.weightx = 1;
//        gbc.weighty = 0;
//        window.add(new JButton("3"), gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.ipady = 200;
        window.add(panel1, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.ipady = 200;
        window.add(panel2, gbc);


        window.setVisible(true);


        ImageIcon image = new ImageIcon(BattleshipView.class.getResource("/battleshiplogo.png"));
        window.setIconImage(image.getImage());
    }
}
