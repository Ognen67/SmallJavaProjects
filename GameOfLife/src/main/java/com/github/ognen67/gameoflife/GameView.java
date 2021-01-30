package com.github.ognen67.gameoflife;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.atomic.AtomicInteger;

public class GameView {

    static boolean[][] board = new boolean[8][8];
    static boolean isBlack = false;
    static AtomicInteger lastX = new AtomicInteger(-1);
    static AtomicInteger lastY = new AtomicInteger(-1);
    private static boolean run;
    private static int speed = 1000;

    public static void main(String[] args) throws InterruptedException {

        GameView gameView = new GameView();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = isBlack;
            }
        }
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
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        g.setColor(board[i][j] ? Color.BLACK : Color.WHITE);
                        g.fillRect(x, y, squareLength, squareLength);
                        y += squareLength;
                    }
                    x += squareLength;
                    y = (this.getHeight() - squareLength * 8) / 2;
                }
                System.out.println(this.getSize());
            }
        };

        panel.setBackground(Color.GRAY);
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                changeTileState(e, panel, board, lastX, lastY);
            }
        });
        panel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                System.out.println(e);
                changeTileState(e, panel, board, lastX, lastY);
            }
        });

        JComboBox<Integer> dropdown = new JComboBox<>();
        dropdown.addItem(1);
        dropdown.addItem(2);
        dropdown.addItem(5);
        dropdown.addItem(50);
        dropdown.addItem(500);
        dropdown.addItem(750);
        dropdown.addItem(1000);
        dropdown.setSelectedItem(speed);
        dropdown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                speed = (int) dropdown.getSelectedItem();
            }
        });

        panel.add(dropdown);
        JButton b = new JButton("Play");
        b.setSize(60, 100);
        b.setBounds(50, 100, 60, 30);
        b.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                run = !run;
                b.setText(run ? "Pause" : "Play");
            }
        });
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (run) {
                        board = gameView.step();
                        panel.repaint();
                    }
                    try {
                        Thread.sleep(speed);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        window.add(panel);
        panel.add(b);
        window.setSize(400, 400);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);




    }

    public void setAlive(int x, int y) {
        board[x][y] = true;
    }

    public void setDead(int x, int y) {
        this.board[x][y] = false;
    }

    public int countAliveNeighbours(int x, int y) {
        int count = 0;

        count += getState(x - 1, y - 1);
        count += getState(x, y - 1);
        count += getState(x + 1, y - 1);

        count += getState(x - 1, y);
        count += getState(x + 1, y);

        count += getState(x - 1, y + 1);
        count += getState(x, y + 1);
        count += getState(x + 1, y + 1);

        return count;
    }

    public int getState(int x, int y) {
        if (x < 0 || x >= 8) {
            return 0;
        }
        if (y < 0 || y >= 8) {
            return 0;
        }
        if (board[x][y]) {
            return 1;
        }
        return 0;
    }

    public boolean[][] step() {

        boolean[][] newBoard = new boolean[8][8];

        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                int aliveNeighbours = countAliveNeighbours(x, y);
                if (getState(x, y) == 1) {
                    if (aliveNeighbours < 2) {
                        newBoard[x][y] = false;
                    } else if (aliveNeighbours == 2 || aliveNeighbours == 3) {
                        newBoard[x][y] = true;
                    } else if (aliveNeighbours > 3) {
                        newBoard[x][y] = false;
                    }
                } else {
                    if (aliveNeighbours == 3) {
                        newBoard[x][y] = true;
                    }
                }
            }
        }
        return newBoard;
    }

    private static void changeTileState(MouseEvent e, JPanel panel, boolean[][] grid, AtomicInteger lastX, AtomicInteger lastY) {
        System.out.println(e);
        int squareLength = Math.min(panel.getWidth() / 8, panel.getHeight() / 8);
        int xMargin = (panel.getWidth() - squareLength * 8) / 2;
        int yMargin = (panel.getHeight() - squareLength * 8) / 2;
        int i = (e.getX() - xMargin) / squareLength;
        int j = (e.getY() - yMargin) / squareLength;
        System.out.println(grid[i][j]);

        if (lastX.intValue() == i && lastY.intValue() == j) {
            return;
        }
        lastX.set(i);
        lastY.set(j);
        grid[i][j] = !grid[i][j];
        panel.repaint();
    }
}
