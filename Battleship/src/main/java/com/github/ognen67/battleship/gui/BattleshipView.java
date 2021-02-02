package com.github.ognen67.battleship.gui;

import javax.swing.*;

public class BattleshipView {

    public JPanel getPanel() {
        return panel;
    }

    public static void main(String[] args) {

        JFrame window = new JFrame();
        JPanel panel = new JPanel() {

        };

        BattleshipView view = new BattleshipView();
        window.setVisible(true);
        window.add(panel);
        window.setSize(600, 600);

    }

}
