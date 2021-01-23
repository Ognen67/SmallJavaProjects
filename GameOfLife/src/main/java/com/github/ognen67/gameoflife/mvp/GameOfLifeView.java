package com.github.ognen67.gameoflife.mvp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameOfLifeView {


    public static void main(String[] args) {
        GameOfLifePresenter presenter = new GameOfLifePresenter();
        GameOfLifeView gameOfLifeView = new GameOfLifeView(presenter);
        presenter.setView(gameOfLifeView);
        presenter.start();
    }

    private final GameOfLifePresenter presenter;
    private BoardView boardView;

    public GameOfLifeView(GameOfLifePresenter presenter) {
        this.presenter = presenter;
    }

    public void drawView() {
        JFrame window = new JFrame();
        window.setLayout(new GridBagLayout());
        addControlPanel(window);
        addBoardPanel(window);
        window.setSize(400, 400);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

    private void addControlPanel(JFrame window) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        window.add(buildControlsPanel(), gbc);
    }

    private void addBoardPanel(JFrame window) {
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.gridy = 1;
        gbc2.gridx = 0;
        gbc2.weightx = 1.0;
        gbc2.weighty = 1.0;
        gbc2.fill = GridBagConstraints.BOTH;
        boardView = new BoardView(presenter);
        window.add(boardView.createBoardPanel(), gbc2);
    }

    private JPanel buildControlsPanel() {
        JPanel controlsPanel = new JPanel();
        controlsPanel.add(createSpeedDropdown());
        controlsPanel.add(createPlayPauseButton());
        return controlsPanel;
    }


    private JButton createPlayPauseButton() {
        JButton b = new JButton("Play");
        b.setSize(60, 100);
        b.setBounds(50, 100, 60, 30);
        b.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                presenter.playPause();
                b.setText(b.getText().equals("Pause") ? "Play" : "Pause");
            }
        });
        return b;
    }

    private JComboBox<Integer> createSpeedDropdown() {
        JComboBox<Integer> dropdown = new JComboBox<>();
        dropdown.addItem(1);
        dropdown.addItem(2);
        dropdown.addItem(5);
        dropdown.addItem(50);
        dropdown.addItem(500);
        dropdown.addItem(750);
        dropdown.addItem(1000);
        dropdown.setSelectedItem(1000);
        dropdown.addActionListener(e -> {
            Integer speed = (Integer) dropdown.getSelectedItem();
            if (speed != null) {
                presenter.setSpeed(speed);
            }

        });
        return dropdown;
    }

    public void drawBoard(boolean[][] board) {
        boardView.drawBoard(board);
    }
}
