package com.github.ognen67.gameoflife.mvp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.concurrent.atomic.AtomicInteger;

public class BoardView {


	private final GameOfLifePresenter presenter;
	private int size;

	private final AtomicInteger lastX = new AtomicInteger(-1);
	private final AtomicInteger lastY = new AtomicInteger(-1);
	private volatile boolean[][] board ;
	private JPanel panel;

	public BoardView(GameOfLifePresenter presenter, int size) {

		this.presenter = presenter;
		this.size = size;
		board = new boolean[size][size];
	}

	public JPanel createBoardPanel() {
		panel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);

				int x, y;
				int widthPerOne = this.getWidth() / size;
				int heightPerOne = this.getHeight() / size;
				int squareLength = Math.min(widthPerOne, heightPerOne);
				x = (this.getWidth() - squareLength * size) / 2;
				y = (this.getHeight() - squareLength * size) / 2;
				for (int i = 0; i < size; i++) {
					for (int j = 0; j < size; j++) {
						g.setColor(board[i][j]? Color.GREEN:Color.BLACK);
						g.fillRect(x, y, squareLength, squareLength);
						y += squareLength;
					}
					x += squareLength;
					y = (this.getHeight() - squareLength * size) / 2;
				}
			}
		};

		panel.setBackground(Color.GRAY);
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				Point point = getSelectedTile(e, panel);
				presenter.flipTile(point.x, point.y);
			}
		});
		panel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				Point point = getSelectedTile(e, panel);
				if (lastX.intValue() == point.x && lastY.intValue() == point.y) {
					return;
				}
				lastX.set(point.x);
				lastY.set(point.y);
				presenter.flipTile(point.x, point.y);
			}
		});
		return panel;
	}

	private Point getSelectedTile(MouseEvent e, JPanel panel) {
		int squareLength = Math.min(panel.getWidth() / size, panel.getHeight() / size);
		int xMargin = (panel.getWidth() - squareLength * size) / 2;
		int yMargin = (panel.getHeight() - squareLength * size) / 2;
		int i = (e.getX() - xMargin) / squareLength;
		int j = (e.getY() - yMargin) / squareLength;
		return new Point(i, j);
	}

	public void drawBoard(boolean[][] board) {
		this.board=board;
		panel.repaint();
	}
}
