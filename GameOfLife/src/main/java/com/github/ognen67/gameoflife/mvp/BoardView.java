package com.github.ognen67.gameoflife.mvp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class BoardView {

    private final GameOfLifePresenter presenter;
    private final AtomicInteger lastX = new AtomicInteger(-1);
    private final AtomicInteger lastY = new AtomicInteger(-1);
    private volatile boolean[][] board;
    private JPanel panel;
    private int tileSize = 5;
    private int rows;
    private int columns;

    public BoardView(GameOfLifePresenter presenter) {

        this.presenter = presenter;
    }

    public JPanel createBoardPanel() {
        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                columns = this.getWidth() / tileSize;

                rows = this.getHeight() / tileSize;
                System.out.println("Rows: " + rows + " Columns: " + columns);
                board = presenter.getBoard(rows, columns);
                int x = 0, y = 0;
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < columns; j++) {
                        g.setColor(board[i][j] ? Color.GREEN : Color.BLACK);
                        g.fillRect(x, y, tileSize, tileSize);
                        x += tileSize;
                    }
                    y += tileSize;
                    x = 0;
                }
            }
        };

        panel.setBackground(Color.GRAY);
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                getSelectedTile(e).ifPresent(value -> presenter.flipTile(value.x, value.y));
            }
        });
        panel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                getSelectedTile(e).ifPresent(point -> {
                    if (lastX.intValue() == point.x && lastY.intValue() == point.y) {
                        return;
                    }
                    lastX.set(point.x);
                    lastY.set(point.y);
                    presenter.flipTile(point.x, point.y);
                });
            }
        });
        return panel;
    }

    private Optional<Point> getSelectedTile(MouseEvent e) {
        int x = (e.getY()) / tileSize;
        int y = (e.getX()) / tileSize;
        if (x >= rows || y >= columns || x < 0 || y < 0) {
            return Optional.empty();
        }
        return Optional.of(new Point(x, y));
    }

    public void drawBoard(boolean[][] board) {
        this.board = board;
        panel.repaint();
    }
}
